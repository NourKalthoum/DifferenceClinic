package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.repositories.UserRepo;
import com.example.difference_clinic.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired 
    private UserRepository userRepo; 

    @Autowired
    private UserRepo userRepository;

    public UserEntity getUser(long id) {
		
		return userRepo.findById(id);
	}

    public UserEntity updateUser(Long id,UserEntity user) {
		try {
			return userRepo.save(user);
		} catch (Exception e) {
	
		}
		return null;
	}

    public UserEntity updateRoleUser(String username,UserEntity user) {
		try {
			return userRepo.save(user);
		} catch (Exception e) {
	
		}
		return null;
	}

    public List<UserEntity> showAllUsers(){
        
		List<UserEntity> users = new ArrayList<UserEntity>();

		for(UserEntity user : userRepo.findAllByOrderByIdDesc()) {
			users.add(user);
		}
		
		return users;
	}

    public List<UserEntity> showZibCode(){
        
		List<UserEntity> users = new ArrayList<UserEntity>();

		for(UserEntity user : userRepo.findAllByOrderByIdDesc()) {
            if(user.getIsActive() == false)
			users.add(user);
		}
		
		return users;
	}

    public UserEntity getUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

    public boolean deleteUser(Long id)
    {
        userRepo.delete(userRepo.findById(id).orElseThrow());
        return userRepo.findById(id).isEmpty();
    }

	public List<UserEntity> showVip(){
        
		List<UserEntity> users = userRepository.findTop10ByOrderByScoreDesc();
		
		
		return users;
	}
    
}
