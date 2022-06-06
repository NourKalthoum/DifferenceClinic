package com.example.difference_clinic.controllers;
import java.time.LocalDate;
import com.example.difference_clinic.entities.AppointmentEntity;
import com.example.difference_clinic.entities.Question;
import com.example.difference_clinic.services.AppointmentService;
import com.example.difference_clinic.services.QuestionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/auth")
@CrossOrigin("*")
public class AppointmentController {

    // private static final ISO DATE = null;

    @Autowired
    private QuestionService questionService;
    
    @Autowired
    AppointmentService appointmentService;
    
    // mobile
    @PostMapping(path ="/createAppointment")
	public Object createAppointment(@RequestBody AppointmentEntity appointment) { 
          try {
            appointmentService.createAppointment(appointment);
		return appointment;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
	}
    // dashboard
    @GetMapping(path ="/detailesAppointment")
    public Object detailesAppointment(@RequestParam(name = "id") Long id){
        try {
            return appointmentService.getAppointment(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // mobile
    @GetMapping(path = "/AvailableTimes")
    public Object AvailableTimes(@RequestParam(name = "appointmentDate")@DateTimeFormat(iso =DateTimeFormat.ISO.DATE) LocalDate appointmentDate){
        try {
            return appointmentService.AvailableTimes(appointmentDate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // dashboard
    @GetMapping(path = "/ShowAppointmentOfNowDay")
    public Object ShowAppointmentOfNowDay(){
        try {
            return appointmentService.ShowAppointmentOfNowDay();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // dashboard
    @GetMapping(path = "/ShowAppointmentOfDay")
    public Object ShowAppointmentOfDay(@RequestParam(name = "appointmentDate")@DateTimeFormat(iso =DateTimeFormat.ISO.DATE) LocalDate appointmentDate){
        try {
            return appointmentService.ShowAppointmentOfDay(appointmentDate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // dashboard
    @GetMapping(path = "/missed")
    public Object missed(@RequestParam(name = "id") Long id){
        try {
            return appointmentService.missed(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // mobile
    @GetMapping(path = "/ShowAppointmentofUser")
    public Object ShowAppointmentofUser(@RequestParam(name = "id") Long id){
        try {
            return appointmentService.ShowAppointmentofUser(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // mobile and dashboard
    @DeleteMapping(path = "/cancelAppointment")
    public boolean cancelAppointment(@RequestParam(name = "id") Long id)    
    {

        return appointmentService.deleteAppointment(id);
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
}
