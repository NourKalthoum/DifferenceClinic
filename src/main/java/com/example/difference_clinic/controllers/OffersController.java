package com.example.difference_clinic.controllers;

import com.example.difference_clinic.entities.OffersEntity;
import com.example.difference_clinic.services.OffersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Offers")
public class OffersController {
  
    @Autowired
    OffersService offersService;

    // all
    @GetMapping(path ="/showAllOffers")
    public Object showAll(){
        try {
            return offersService.showAllOffers();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // all
    @GetMapping(path = "/detailesOffer")
    public Object detailesOffer(@RequestParam(name = "id") Long id){
        try {
            return offersService.getOffer(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    // dashboard
    @PostMapping(path ="/addOffer")
	public Object addOffer(@RequestBody OffersEntity offer) { 
          try {
            offersService.addOffer(offer);
		return offer;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
	}
    
    @DeleteMapping(path = "/deleteOffer")
    public boolean deleteOffer(@RequestParam(name = "id") Long id)    
    {
        return offersService.deleteOffer(id);
    }

    @PutMapping(path ="/updateOffer")
    public Object updateOffer(@RequestParam(name = "id") Long id, @RequestBody OffersEntity offer){
        try {
        OffersEntity updateOffer = offersService.getOffer(id);
        updateOffer.setTitle(offer.getTitle());
        updateOffer.setDescription(offer.getDescription());
        updateOffer.setImage(offer.getImage());
        updateOffer.setOrder(offer.getOrder());
        offersService.updateOffer(id, updateOffer);
        return updateOffer;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }


}
