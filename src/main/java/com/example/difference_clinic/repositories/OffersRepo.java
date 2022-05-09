package com.example.difference_clinic.repositories;

import java.util.List;

import com.example.difference_clinic.entities.OffersEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffersRepo extends JpaRepository<OffersEntity,Long> {
    
    public OffersEntity findById(long id);
    public OffersEntity findById(int id);
    // @Query(value = "SELECT o FROM OffersEntity o ORDER BY order")
    // public List<OffersEntity> findAll();
    public List<OffersEntity> findAllByOrderByIdDesc();
}
