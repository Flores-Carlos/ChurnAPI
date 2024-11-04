package com.challenge.churn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

    private final RestTemplate restTemplate;

    @Autowired
    public AIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPrediction(String inputData) {
        String aiEndpoint = "http://localhost:5000/predict";

        String response = restTemplate.postForObject(aiEndpoint, inputData, String.class);

        return response;
    }
}
