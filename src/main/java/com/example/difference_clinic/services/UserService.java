package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.repositories.RoleRepository;
import com.example.difference_clinic.repositories.UserRepo;
import com.example.difference_clinic.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired 
    private UserRepository userRepo; 

    @Autowired
    private UserRepo userRepository;

	private  PasswordEncoder passwordEncoder;
    @Autowired
	RoleRepository roleRepository;

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

	public UserEntity saveUser(UserEntity user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
	}

	public void addRoleToUser(String username, String roleName) {
        UserEntity user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }
    
	public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
