package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.Image;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image,Long>{
    
}
