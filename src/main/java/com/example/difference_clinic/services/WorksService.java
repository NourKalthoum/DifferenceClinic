package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.worksEntity;
import com.example.difference_clinic.repositories.WorksRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorksService {
    
    @Autowired
    private WorksRepo worksRepo;

    public List<worksEntity> showAllworks(){
        
		List<worksEntity> works = new ArrayList<worksEntity>();

		for(worksEntity work : worksRepo.findAll()) {
			works.add(work);
		}
		
		return works;
	}

    public worksEntity getwork(long id) {
		
		return worksRepo.findById(id);
	}


    public boolean deletework(Long id)
    {
        worksRepo.delete(worksRepo.findById(id).orElseThrow());
        return worksRepo.findById(id).isEmpty();
    }

    public worksEntity addwork(worksEntity work) {      
		return worksRepo.save(work);
	}

    public worksEntity updatework(Long id,worksEntity work) {
		try {
			return worksRepo.save(work);
		} catch (Exception e) {
	
		}
		return null;
	}

}
