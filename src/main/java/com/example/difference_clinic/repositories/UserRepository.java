package com.example.difference_clinic.repositories;

import java.util.List;
import java.util.Optional;

import com.example.difference_clinic.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    
    UserEntity findByPassword(String password);

    Boolean existsByUsername(String username);

    public UserEntity findById(long id);
    public UserEntity findById(int id);

    public List<UserEntity> findAllByOrderByIdDesc();
    
}
