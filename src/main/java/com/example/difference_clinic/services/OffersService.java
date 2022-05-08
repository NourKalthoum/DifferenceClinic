package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.OffersEntity;
import com.example.difference_clinic.repositories.OffersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffersService {
    
    @Autowired
    private OffersRepo offersRepo;

    public List<OffersEntity> showAllOffers(){
        
		List<OffersEntity> Offers = new ArrayList<OffersEntity>();

		for(OffersEntity Offer : offersRepo.findAllByOrderByIdDesc()) {
			Offers.add(Offer);
		}
		
		return Offers;
	}

    public OffersEntity getOffer(long id) {
		
		return offersRepo.findById(id);
	}


    public boolean deleteOffer(Long id)
    {
        offersRepo.delete(offersRepo.findById(id).orElseThrow());
        return offersRepo.findById(id).isEmpty();
    }

    public OffersEntity addOffer(OffersEntity offer) {      
		return offersRepo.save(offer);
	}

    public OffersEntity updateOffer(Long id,OffersEntity offer) {
		try {
			return offersRepo.save(offer);
		} catch (Exception e) {
	
		}
		return null;
	}

}
