package com.example.difference_clinic.controllers;

import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.repositories.UserRepository;
import com.example.difference_clinic.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {
   
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserService userService;
    
    // mobile
    @PutMapping(path ="/updateProfile")
    public Object updateProfile(@RequestBody UserEntity user){
        try {
        UserEntity updateUser= userService.getUser(user.getId());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setJob(user.getJob());
        updateUser.setSocialStatus(user.getSocialStatus());
        updateUser.setMobile(user.getMobile());
        userService.updateUser(user.getId(), updateUser);
        return updateUser;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }
    // dashboard
    @GetMapping(path ="/showAllUsers")
    public Object showAllUsers(){
        try {
            return userService.showAllUsers();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // dashboard
    @GetMapping(path ="/showZibCode")
    public Object showZibCode(){
        try {
            return userService.showZibCode();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // dashboard
    @PutMapping(path ="/updateRole")
    public Object updateRole(@RequestParam(name = "username") String username, @RequestBody UserEntity user){
        try {
        UserEntity updateRoleUser = userService.getUsername(username);
        updateRoleUser.setRoles(user.getRoles());
        userService.updateRoleUser(username, updateRoleUser);
        return updateRoleUser;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }

    // dashboard
    @DeleteMapping(path = "/deleteUser")
    public boolean deleteUser(@RequestParam(name = "id") Long id)    
    {
        return userService.deleteUser(id);
    }

    // mobile
    @GetMapping(path ="/showUser")
    public Object showUser(@RequestParam(name = "username")String username){
        try {
            return userService.getUsername(username);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

     // dashboard
     @GetMapping(path ="/showVip")
     public Object showVip(){
         try {
             return userService.showVip();
         } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
         }
     }
}
