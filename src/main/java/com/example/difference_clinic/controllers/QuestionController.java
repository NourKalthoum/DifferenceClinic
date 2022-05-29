package com.example.difference_clinic.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.Question;
import com.example.difference_clinic.repo.QuestionElasticRepo;
import com.example.difference_clinic.services.Loaders;
import com.example.difference_clinic.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Question")
@CrossOrigin("*")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionElasticRepo questionElasticRepo;

    @Autowired
    private Loaders loders;

    // mobile
    @PostMapping(value = "/search")
    public List<Question> search(@RequestBody final String text) {
        loders.loadAll();
        List<Question> questions = questionElasticRepo.findByQuestionText(text);
        List<Question> answers = questionElasticRepo.findByAnswer(text);
        List<Question> collection = new ArrayList<Question>(); 
        collection.addAll(questions);
        collection.addAll(answers);
        return collection;
    }

    // mobile
    @GetMapping(path ="/showAllQuestionAndAnswer")
    public Object showAllQuestionAndAnswer(){
        try {
            return questionService.showAllQuestionAndAnswer();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // mobile
    @GetMapping(path ="/showCommonQuestionAndAnswer")
    public Object showCommonQuestionAndAnswer(){
        try {
            return questionService.showCommonQuestionAndAnswer();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    // mobile
    @GetMapping(path = "/detailesQuestion")
    public Object detailesQuestion(@RequestParam(name = "id") Long id){
        try {
            return questionService.getQuestion(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // mobile
    @PostMapping(path ="/addQuestion")
	public Object addQuestiont(@RequestBody Question question) { 
          try {
            questionService.addQuestion(question);
		return question;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
	}

     // dashboard
     @GetMapping(path ="/showAllQuestion")
     public Object showAllQuestion(){
         try {
             return questionService.showAllQuestion();
         } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
         }
     }

    // dashboard
    @PutMapping(path ="/addAnswer")
	public Object addAnswer(@RequestParam(name = "id") Long id, @RequestBody Question answeradded){
        try {
        Question answer = questionService.getQuestion(id);
        answer.setAnswer(answeradded.getAnswer());
        answer.setCommon(answeradded.getCommon());
        answer.setUser(questionService.getUser(answeradded.getUser().getUsername()));
        questionService.addAnswer(id, answer);
        return answer;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }

    // dashboard
    @DeleteMapping(path = "/deleteQuestion")
    public boolean deleteQuestion(@RequestParam(name = "id") Long id)    
    {
        return questionService.deleteQuestion(id);
    }
}
