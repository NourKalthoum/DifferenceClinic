package com.example.difference_clinic.repositories;

import com.example.difference_clinic.entities.BodySectionsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodySectionsRepo extends JpaRepository<BodySectionsEntity,Long>{
    
}
