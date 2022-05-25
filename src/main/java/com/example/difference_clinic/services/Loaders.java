package com.example.difference_clinic.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import com.example.difference_clinic.entities.Question;
import com.example.difference_clinic.repo.QuestionElasticRepo;
import com.example.difference_clinic.repositories.QuestionRepo;

import java.util.List;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    QuestionElasticRepo questionElasticRepo;

    @Autowired
    QuestionRepo questionRepo;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Question.class);
        System.out.println("Loading Data");
        List<Question> questionList = questionRepo.findAll(); //Get from DB
        questionElasticRepo.saveAll(questionList); //loads into Elastic
        System.out.printf("Loading Completed");

    }

}
