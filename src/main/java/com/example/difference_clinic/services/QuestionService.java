package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.QuestionEntity;
import com.example.difference_clinic.repositories.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public List<QuestionEntity> showAllQuestionAndAnswer(){
        
		List<QuestionEntity> Questions = new ArrayList<QuestionEntity>();

		for(QuestionEntity qestion : questionRepo.findAllByOrderByIdDesc()) {
            if(qestion.getAnswer() != null)
			Questions.add(qestion);
		}
		
		return Questions;
	}

    public List<QuestionEntity> showCommonQuestionAndAnswer(){
        
		List<QuestionEntity> Questions = new ArrayList<QuestionEntity>();

		for(QuestionEntity qestion : questionRepo.findAllByOrderByIdDesc()) {
            if(qestion.getCommon() == true)
			Questions.add(qestion);
		}
		
		return Questions;
	}

    public List<QuestionEntity> showAllQuestion(){
        
		List<QuestionEntity> Questions = new ArrayList<QuestionEntity>();

		for(QuestionEntity qestion : questionRepo.findAllByOrderByIdDesc()) {
            if(qestion.getAnswer() == null)
			Questions.add(qestion);
		}
		
		return Questions;
	}

    public QuestionEntity getQuestion(long id) {
		
		return questionRepo.findById(id);
	}

    public QuestionEntity addQuestion(QuestionEntity question) {      
		return questionRepo.save(question);
	}

	public boolean deleteQuestion(Long id)
    {
        questionRepo.delete(questionRepo.findById(id).orElseThrow());
        return questionRepo.findById(id).isEmpty();
    }

	public QuestionEntity addAnswer(Long id,QuestionEntity answer) {
		try {
			return questionRepo.save(answer);
		} catch (Exception e) {
	
		}
		return null;
	}
    
}
