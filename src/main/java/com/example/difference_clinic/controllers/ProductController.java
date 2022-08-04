package com.example.difference_clinic.controllers;

import com.example.difference_clinic.entities.OffersEntity;
import com.example.difference_clinic.entities.ProductEntity;
import com.example.difference_clinic.services.ImageStorageService;
import com.example.difference_clinic.services.ProductService;

import java.time.LocalDateTime;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

@RestController
@RequestMapping(path = "api/v1/Product")
@CrossOrigin("*")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @Autowired
    ImageStorageService imageStorageService;


    // all
    @GetMapping(path ="/showAllProduct")
    public Object showAll(){
        try {
            return productService.showAllProduct();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // dashboard
    @PostMapping(path = "/addProduct")
    public Object addOffer(@RequestParam("photo") MultipartFile photo,  ProductEntity product) {
        try {
            String imageName = imageStorageService.save(photo);
            product.setImage(imageName);
            productService.addProduct(product);
            return product;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    // mobile
    @GetMapping(path = "/detailsProduct")
    public Object detailsProduct(@RequestParam(name = "id") Long id){
        try {
            return productService.getProduct(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    
    @DeleteMapping(path = "/deleteProduct")
    public boolean deleteProduct(@RequestParam(name = "id") Long id)    
    {
        return productService.deleteProduct(id);
    }

    @PutMapping(path = "/updateProduct")
    public Object updateOffer(@RequestParam("photo") MultipartFile photo,  ProductEntity product) {

        String imageName = imageStorageService.save(photo);
        product.setImage(imageName);
        try {
            ProductEntity updateProduct = productService.getProduct(product.getId());
            updateProduct.setName(product.getName());
            updateProduct.setDescription(product.getDescription());
            updateProduct.setImage(product.getImage());
            updateProduct.setPrice(product.getPrice());
            productService.updateProduct(product.getId(), updateProduct);
            return updateProduct;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



}
