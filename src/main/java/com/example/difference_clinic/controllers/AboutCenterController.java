package com.example.difference_clinic.controllers;

import com.example.difference_clinic.entities.AboutCenterEntity;
import com.example.difference_clinic.services.AboutCenterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/AboutCenter")
@CrossOrigin("*")
public class AboutCenterController {

    @Autowired
    private AboutCenterService aboutCenterService;

    // all
    @GetMapping(path ="/showAboutCenter")
    public Object showAboutCenter(){
        try {
            return aboutCenterService.getAboutCenter();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    // dashboard
    @PutMapping(path ="/updateAboutCenter")
    public Object updateAboutCenter(@RequestBody AboutCenterEntity aboutCenterEntity){
        try {
        AboutCenterEntity updateaboutCenter = aboutCenterService.getAboutCenter();
        updateaboutCenter.setGenesis(aboutCenterEntity.getGenesis());
        updateaboutCenter.setServices(aboutCenterEntity.getServices());
        aboutCenterService.updateAboutCenter(1, updateaboutCenter);
        return updateaboutCenter;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }
    
}
