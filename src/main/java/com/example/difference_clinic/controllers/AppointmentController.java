package com.example.difference_clinic.controllers;
import java.sql.Time;
import javax.transaction.Transactional;
import java.time.LocalDate;
import com.example.difference_clinic.entities.AppointmentEntity;
import com.example.difference_clinic.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Appointment")
public class AppointmentController {
    private static final ISO DATE = null;
    @Autowired
    AppointmentService appointmentService;

    @PostMapping(path ="/createAppointment")
	public Object createAppointment(@RequestBody AppointmentEntity appointment) { 
          try {
            appointmentService.createAppointment(appointment);
		return appointment;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
	}

    @GetMapping(path ="/detailesAppointment")
    public Object detailesAppointment(@RequestParam(name = "id") Long id){
        try {
            return appointmentService.getAppointment(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(path = "/AvailableTimes")
    public Object AvailableTimes(@RequestParam(name = "appointmentDate")@DateTimeFormat(iso =DateTimeFormat.ISO.DATE) LocalDate appointmentDate){
        try {
            return appointmentService.AvailableTimes(appointmentDate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
