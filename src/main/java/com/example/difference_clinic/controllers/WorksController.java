package com.example.difference_clinic.controllers;

import com.example.difference_clinic.entities.ProductEntity;
import com.example.difference_clinic.entities.worksEntity;
import com.example.difference_clinic.services.ImageStorageService;
import com.example.difference_clinic.services.WorksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "api/v1/Works")
@CrossOrigin("*")
public class WorksController {
  
    @Autowired
    WorksService worksService;

    @Autowired
    ImageStorageService imageStorageService;
        // all
        @GetMapping(path ="/showAllWorks")
        public Object showAll(){
            try {
                return worksService.showAllworks();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }
        // mobile
        @GetMapping(path = "/detailesWork")
        public Object detailesWork(@RequestParam(name = "id") Long id){
            try {
                return worksService.getwork(id);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }


        
        // dashboard
        @PostMapping(path ="/addWork")
        public Object addWork(@RequestParam("photo") MultipartFile photo,  worksEntity work) {
              try {
                  String imageName = imageStorageService.save(photo);
                  work.setImage(imageName);
                  worksService.addwork(work);
                  return work;
              } catch (Exception e) {
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
              }
        }
        
        @DeleteMapping(path = "/deleteWork")
        public boolean deleteWork(@RequestParam(name = "id") Long id)    
        {
            return worksService.deletework(id);
        }
    
        @PutMapping(path = "/updateWork")
    public Object updateOffer(@RequestParam("photo") MultipartFile photo,  worksEntity work) {

        String imageName = imageStorageService.save(photo);
        work.setImage(imageName);
        try {
            worksEntity updateWork = worksService.getwork(work.getId());
            updateWork.setTitle(work.getTitle());
            updateWork.setDescription(work.getDescription());
            updateWork.setImage(work.getImage());
            worksService.updatework(work.getId(), updateWork);
            return updateWork;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
