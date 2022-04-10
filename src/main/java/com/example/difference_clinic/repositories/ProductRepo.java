package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity,Long>{
    
}
