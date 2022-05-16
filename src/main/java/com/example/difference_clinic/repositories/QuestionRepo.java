package com.example.difference_clinic.repositories;

import java.util.List;

import com.example.difference_clinic.entities.QuestionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity,Long>{

    public List<QuestionEntity> findAllByOrderByIdDesc();
    public QuestionEntity findById(long id);
    public QuestionEntity findById(int id);
}
