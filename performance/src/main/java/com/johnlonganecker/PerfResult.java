package com.johnlonganecker;

import java.util.Map;
import java.util.HashMap;

public class PerfResult {
  
  private Map<String, Object> results = new HashMap<String, Object>();

  public PerfResult(Map<String, Object> results) {
    this.results = results;
  }

  public Map<String, Object> getResults() {
    return results;
  }
}
