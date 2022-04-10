package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.OffersEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersRepo extends JpaRepository<OffersEntity,Long> {
    
}
