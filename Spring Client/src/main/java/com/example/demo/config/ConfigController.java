package com.example.demo.config;

import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@PermitAll
@RefreshScope
public class ConfigController {

    private final RestTemplate restTemplate;

    @Value("${config.server.uri:http://localhost:8888}")
    private String configServerUri;

    public ConfigController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/fetch-config")
    public String getConfig(@RequestParam(defaultValue = "dev") String profile) {
        String url = configServerUri + "/spring-cloud-config/" + profile;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

}