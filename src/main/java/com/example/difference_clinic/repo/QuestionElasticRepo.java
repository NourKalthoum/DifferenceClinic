package com.example.difference_clinic.repo;

import java.util.List;


import com.example.difference_clinic.entities.Question;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuestionElasticRepo extends ElasticsearchRepository<Question, Long>{
    
    List<Question> findByQuestionText(String text);
    List<Question> findByAnswer(String text);
    
}
