package com.example.difference_clinic.repositories;

import java.util.Optional;

import com.example.difference_clinic.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    
    UserEntity findByPassword(String password);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    
}
