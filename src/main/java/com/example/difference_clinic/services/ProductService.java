package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.List;

import com.example.difference_clinic.entities.ProductEntity;
import com.example.difference_clinic.repositories.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  
    @Autowired
    private ProductRepo productRepo;

    public List<ProductEntity> showAllProduct(){
        
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		for(ProductEntity product : productRepo.findAll()) {
			products.add(product);
		}
		
		return products;
	}
}
