package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.QuestionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity,Long>{
    
}
