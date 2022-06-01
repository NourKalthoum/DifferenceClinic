package com.example.difference_clinic.repositories;

import java.time.LocalDate;
import java.util.List;

import com.example.difference_clinic.entities.AppointmentEntity;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Long>{
    
    public AppointmentEntity findById(long id);
    public AppointmentEntity findById(int id);
    @Query(value = "SELECT * FROM AppointmentEntity where appointmentDate = ?1 ")
    List<AppointmentEntity> getAppointmentEntityByAppointmentDate(LocalDate appointmentDate);
    // public AppointmentEntity findByAppointmentDate(LocalDate appointmentDate);
    // @Query("SELECT u FROM AppointmentEntity u WHERE u.appointmentDate = :appointmentDate")
    // List<AppointmentEntity> findAll(LocalDate appointmentDate);
}
