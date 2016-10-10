package com.johnlonganecker;

import java.util.concurrent.atomic.AtomicLong;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONReader;
import com.rabbitmq.tools.json.JSONWriter;
import com.rabbitmq.perf.Scenario;
import com.rabbitmq.perf.ScenarioFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import org.springframework.web.util.UriUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import com.google.gson.Gson;

@RestController
//@RequestMapping("/perf")
public class FormController {

  private static final ConnectionFactory factory = new ConnectionFactory();

  private static final Map<String, Object> results = new HashMap<String, Object>();

  @PostMapping("/perftest")
  public @ResponseBody PerfResult process(@RequestBody String scenarioConfig) {

    Map<String, String> env = System.getenv();

    Map scenarioJSON = null;

    String returnResult = "";
    try {
      scenarioJSON = (Map) new JSONReader().read(scenarioConfig);

    } catch (Exception e) {
      e.printStackTrace();
      throw new InvalidJsonException("Parsing ScenarioConfig JSON - " + e.getMessage());
    }

    try {

      // if uri is not specified use vcap variable
      if (!scenarioJSON.containsKey("uri")) {
        Gson gson = new Gson();
        Rabbitmq36 rabbitmqConfig = gson.fromJson(env.get("VCAP_SERVICES"), Rabbitmq36.class);

        scenarioJSON.put("uri", rabbitmqConfig.getRabbitmq36().get(0).getCredentials().getUri());
      }
    } catch(Exception e) {
      System.out.println("warning: failed trying to use Cloud Foundry VCAP ENV Variables");
      e.printStackTrace();
    }

    Scenario[] scenarios = new Scenario[1];
    scenarios[0] = ScenarioFactory.fromJSON(scenarioJSON, factory);

    try {
      runStaticBrokerTests(scenarios);
    } catch(Exception e) {
      e.printStackTrace();
      throw new RunScenarioException("Unable to run scenario - " + e.getMessage());
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
      results.put(scenario.getName(), scenario.getStats().results());
    }
  }
}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class InvalidJsonException extends RuntimeException {
  public InvalidJsonException(String error) {
    super(error);
  }
}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class RunScenarioException extends RuntimeException {
  public RunScenarioException(String error) {
    super(error);
  }
}
