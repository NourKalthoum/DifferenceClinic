package com.example.difference_clinic.repositories;

import java.util.List;

import com.example.difference_clinic.entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long>{

    public List<Question> findAllByOrderByIdDesc();
    public Question findById(long id);
    public Question findById(int id);
    
}
