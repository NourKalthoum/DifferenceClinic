package com.example.difference_clinic.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.ProductEntity;
import com.example.difference_clinic.entities.worksEntity;
import com.example.difference_clinic.repositories.WorksRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class WorksService {
    
    @Autowired
    private WorksRepo worksRepo;

	@Autowired
	ImageStorageService imageStorageService;

    public List<worksEntity> showAllworks(){
        
		List<worksEntity> works = new ArrayList<worksEntity>();

		for(worksEntity work : worksRepo.findAllByOrderByIdDesc()) {
			works.add(work);
		}
		
		return works;
	}

    public worksEntity getwork(long id) {
		
		return worksRepo.findById(id);
	}


    public boolean deletework(Long id)
    {
		try {
			worksEntity works = worksRepo.getById(id);
			imageStorageService.delete(works.getImage());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

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
