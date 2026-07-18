package com.codeNeeTi.onboarding.controller;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @Value("${application.name}")
  private String applicationName;

  @Value("${application.version}")
  private String version;

  @Value("${application.description}")
  private String description;

  @GetMapping("/api/v1/health")
  public ResponseEntity<Map<String, Object>> health() {

    Map<String, Object> response = new LinkedHashMap<>();

    response.put("status", "UP");
    response.put("service", applicationName);
    response.put("version", version);
    response.put("description", description);
    response.put("timestamp", Instant.now());

    return ResponseEntity.ok(response);
  }
}
