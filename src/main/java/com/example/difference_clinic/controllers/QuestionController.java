package com.example.difference_clinic.controllers;

import com.example.difference_clinic.entities.QuestionEntity;
import com.example.difference_clinic.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

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
	public Object addQuestiont(@RequestBody QuestionEntity question) { 
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
	public Object addAnswer(@RequestParam(name = "id") Long id, @RequestBody QuestionEntity answeradded){
        try {
        QuestionEntity answer = questionService.getQuestion(id);
        answer.setAnswer(answeradded.getAnswer());
        answer.setCommon(answeradded.getCommon());
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
