package com.example.difference_clinic.services;

import com.example.difference_clinic.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired 
    private UserRepo userRepo; 
    
}
