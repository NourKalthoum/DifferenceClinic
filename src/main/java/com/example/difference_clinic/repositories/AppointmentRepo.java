package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.AppointmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Long>{
    
}
