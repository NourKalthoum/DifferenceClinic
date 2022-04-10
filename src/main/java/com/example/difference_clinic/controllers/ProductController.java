package com.example.difference_clinic.controllers;

import com.example.difference_clinic.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/Product")
public class ProductController {
    
    @Autowired
    ProductService productService;


    @GetMapping(path = "/shoAllProduct")
    public Object shoAll(){
        try {
            return productService.showAllProduct();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }





}
