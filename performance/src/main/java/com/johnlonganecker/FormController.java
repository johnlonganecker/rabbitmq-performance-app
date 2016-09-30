package com.johnlonganecker;

import java.util.concurrent.atomic.AtomicLong;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONReader;
import com.rabbitmq.tools.json.JSONWriter;
import com.rabbitmq.perf.Scenario;
import com.rabbitmq.perf.ScenarioFactory;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

  //@RequestMapping(method=RequestMethod.POST)
  @PostMapping("/perf")
  public @ResponseBody PerfResult process(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {

    List<Map> scenariosJSON = null;
    String returnResult = "";
    try {
      scenariosJSON = (List<Map>) new JSONReader().read("[{ 'name': 'consume', 'type': 'simple', 'uri': 'amqp://296d03f3-539b-467c-afd6-f510a7528827:e5d03acnkou3l0tga785btnc4n@rabbitmq-sb.svc.asv.ice.gecis.io:5672/b4a6d819-60fc-400a-8586-243b24de0eba', 'params': [{ 'time-limit': 10, 'producer-count': 4, 'consumer-count': 2, 'queue-name': 'queue_name2' }] }]");
    } catch (Exception e) {
      System.out.println("json is invalid");
      System.exit(1);
    }

    Scenario[] scenarios = new Scenario[scenariosJSON.size()];
    for (int i = 0; i < scenariosJSON.size(); i++) {
      System.out.println(i);
      scenarios[i] = ScenarioFactory.fromJSON(scenariosJSON.get(i), factory);
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

    Gson gson = new Gson();
    returnResult = gson.toJson(results);
    return new PerfResult(returnResult);
  }

  private static void runStaticBrokerTests(Scenario[] scenarios) throws Exception {
    System.out.println("runStaticBroker");
    runTests(scenarios);
  }

  private static void runTests(Scenario[] scenarios) throws Exception {
    System.out.println("runTests");
    for (Scenario scenario : scenarios) {
      System.out.print("Running scenario '" + scenario.getName() + "'");
      scenario.run();
      System.out.println();
      results.put(scenario.getName(), scenario.getStats().results());
    }
  }
}
