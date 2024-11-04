package com.challenge.churn.controller;

import com.challenge.churn.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/predict")
    public String predict(@RequestBody String inputData) {
        return aiService.getPrediction(inputData);
    }
}
