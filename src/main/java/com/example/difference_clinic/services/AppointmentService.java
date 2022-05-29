package com.example.difference_clinic.services;

import java.util.Optional;

import com.example.difference_clinic.entities.AppointmentEntity;
import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.repositories.AppointmentRepo;
import com.example.difference_clinic.repositories.BodySectionsRepo;
import com.example.difference_clinic.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
   
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private BodySectionsRepo bodySectionsRepo;
    
    @Autowired
    private UserRepository userRepository;
    

    // public AppointmentEntity createAppointment(AppointmentEntity appointment) {  
    //   Optional<UserEntity> user = userRepository.findById(appointment.getUser().getId());
    //   if(user.get().getScore() >  0){
    //      user.get().setScore(user.get().getScore()+10); 
    //      userRepository.save(user.get());
	// 	return appointmentRepo.save(appointment);
    //   }
    //  return null;
	// }


}
