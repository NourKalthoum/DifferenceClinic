package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.AboutCenterEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutCenterRepo extends JpaRepository<AboutCenterEntity,Long>{
    
    public AboutCenterEntity findById(long id);
}
