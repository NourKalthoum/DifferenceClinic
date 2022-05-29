package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.difference_clinic.entities.Question;
import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.repositories.QuestionRepo;
import com.example.difference_clinic.repositories.UserRepo;
import com.example.difference_clinic.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
	private UserRepo userRepo;

    public List<Question> showAllQuestionAndAnswer(){
        
		List<Question> Questions = new ArrayList<Question>();

		for(Question qestion : questionRepo.findAllByOrderByIdDesc()) {
            if(qestion.getAnswer() != null)
			Questions.add(qestion);
		}
		
		return Questions;
	}

    public List<Question> showCommonQuestionAndAnswer(){
        
		List<Question> Questions = new ArrayList<Question>();

		for(Question qestion : questionRepo.findAllByOrderByIdDesc()) {
            if(qestion.getCommon() == true)
			Questions.add(qestion);
		}
		
		return Questions;
	}

    public List<Question> showAllQuestion(){
        
		List<Question> Questions = new ArrayList<Question>();

		for(Question qestion : questionRepo.findAllByOrderByIdDesc()) {
            if(qestion.getAnswer() == null)
			Questions.add(qestion);
		}
		
		return Questions;
	}

    public Question getQuestion(long id) {
		
		return questionRepo.findById(id);
	}

    public Question addQuestion(Question question) {      
		return questionRepo.save(question);
	}

	public boolean deleteQuestion(Long id)
    {
        questionRepo.delete(questionRepo.findById(id).orElseThrow());
        return questionRepo.findById(id).isEmpty();
    }

	public Question addAnswer(Long id,Question answer) {
		try {
			return questionRepo.save(answer);
		} catch (Exception e) {
	
		}
		return null;
	}
    
	public UserEntity getUser(String username){
		
		 return userRepo.findByUsername(username);
	}
}
