package com.johnlonganecker;

import java.util.concurrent.atomic.AtomicLong;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONReader;
import com.rabbitmq.tools.json.JSONWriter;
import com.rabbitmq.perf.Scenario;
import com.rabbitmq.perf.ScenarioFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import com.google.gson.Gson;

@Controller
//@RequestMapping("/perf")
public class FormController {

  private static final ConnectionFactory factory = new ConnectionFactory();

  private static final Map<String, Object> results = new HashMap<String, Object>();

  @RequestMapping("/")
  public String index() {

    return "index.html";
  }

  @PostMapping("/perftest")
  public @ResponseBody PerfResult process(@RequestBody String scenarioConfig) {

    Map<String, String> env = System.getenv();

    HashMap<String, Object> vcap = null;
    //vcap = (HashMap<String, Object>) new JSONReader().read(env.get("VCAP_SERVICES"));

      //["VCAP_SERVICES"]["rabbitmq-36"][0]["credentials"]["uri"]

    Gson gson = new Gson();
    Rabbitmq36 rabbitmqConfig = gson.fromJson(env.get("VCAP_SERVICES"), Rabbitmq36.class);

    List<Map> scenariosJSON = null;
    String returnResult = "";
    try {
      scenariosJSON = (List<Map>) new JSONReader().read(scenarioConfig);
    } catch (Exception e) {
      System.out.println("json is invalid");
      System.exit(1);
    }

    Scenario[] scenarios = new Scenario[scenariosJSON.size()];
    for (int i = 0; i < scenariosJSON.size(); i++) {
      System.out.println(i + " - " + scenariosJSON.get(i));
      scenarios[i] = ScenarioFactory.fromJSON(scenariosJSON.get(i), factory);
    }

    try {
      factory.setUri(rabbitmqConfig.getRabbitmq36().get(0).getCredentials().getUri());
    } catch(Exception e) {
    }

    try {
      runStaticBrokerTests(scenarios);
    } catch(Exception e) {
      System.out.println("Failed to run performance test");
      System.out.println(e.getMessage());
      System.out.println(e);
      System.out.println(e.getCause());
      System.out.println(Arrays.toString(e.getStackTrace()));
      System.exit(1);
    }

    return new PerfResult(results);
  }

  private static void runStaticBrokerTests(Scenario[] scenarios) throws Exception {
    runTests(scenarios);
  }

  private static void runTests(Scenario[] scenarios) throws Exception {
    for (Scenario scenario : scenarios) {
      System.out.print("Running scenario '" + scenario.getName() + "'");
      scenario.run();
      System.out.println();
      results.put(scenario.getName(), scenario.getStats().results());
    }
  }
}
