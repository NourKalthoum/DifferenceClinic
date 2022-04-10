package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.worksEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorksRepo extends JpaRepository<worksEntity,Long>{
    
}
