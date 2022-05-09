package com.example.difference_clinic.services;

import com.example.difference_clinic.repositories.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    
}
