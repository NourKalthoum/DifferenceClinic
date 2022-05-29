package com.example.difference_clinic.controllers;

import com.example.difference_clinic.entities.AppointmentEntity;
import com.example.difference_clinic.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    // @PostMapping(path ="/createAppointment")
	// public Object createAppointment(@RequestBody AppointmentEntity appointment) { 
    //       try {
    //         appointmentService.createAppointment(appointment);
	// 	return appointment;
    // } catch (Exception e) {
    //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("you are punished , you can not book an appointmant");
    // }
	// }
}
