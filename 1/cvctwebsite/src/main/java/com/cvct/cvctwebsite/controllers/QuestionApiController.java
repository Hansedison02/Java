package com.cvct.cvctwebsite.controllers;

import com.cvct.cvctwebsite.models.QuestionEntity;
import com.cvct.cvctwebsite.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionApiController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/api/random-question")
    public QuestionEntity getRandomQuestion() {
        return questionService.getRandomQuestion();
    }
}