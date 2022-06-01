package com.example.difference_clinic.repositories;

import java.util.Optional;

import com.example.difference_clinic.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long>{
    UserEntity findByUsername(String username);
     Optional<UserEntity> findById(long id);
    Optional<UserEntity> findById(int id);
}
