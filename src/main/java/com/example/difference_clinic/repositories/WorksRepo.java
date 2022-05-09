package com.example.difference_clinic.repositories;

import java.util.List;

import com.example.difference_clinic.entities.worksEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorksRepo extends JpaRepository<worksEntity,Long>{
    
    public worksEntity findById(long id);
    public worksEntity findById(int id);
    // @Query(value = "SELECT w FROM worksEntity w ORDER BY order")
    // public List<worksEntity> findAll();
    public List<worksEntity> findAllByOrderByIdDesc();
}
