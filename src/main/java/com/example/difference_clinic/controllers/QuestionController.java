package com.example.difference_clinic.controllers;

import com.example.difference_clinic.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;
}
