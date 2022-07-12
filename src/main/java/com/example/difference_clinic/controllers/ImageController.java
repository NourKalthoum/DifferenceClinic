package com.example.difference_clinic.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Random;

import com.example.difference_clinic.entities.Image;
import com.example.difference_clinic.entities.ProductEntity;
import com.example.difference_clinic.payload.request.ProductRequest;
import com.example.difference_clinic.repositories.ImageRepo;
import com.example.difference_clinic.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ImageController {
    
    @Autowired
    ImageRepo imageRepo;

	@Autowired
    ProductService productService;
    
// @PostMapping("/upload-attachment")
// public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
// 	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
// 	Path path = Paths.get("attachments/" + fileName);
// 	try {
// 		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
// 	} catch (IOException e) {
// 		e.printStackTrace();
// 	}
    
//     Image image = new Image();
//     image.setFileName(fileName);
// 	return ResponseEntity.ok(imageRepo.save(image));
// }

@PostMapping("/upload-attachment")
public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file, @RequestParam("product") ProductRequest productRequest) {
	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	Random rand = new Random();
    int randomNum = rand.nextInt((10000000 - 10) + 1) + 10;
	String name = randomNum+fileName;
	Path path = Paths.get("attachments/" + name);
	try {
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException e) {
		e.printStackTrace();
	}
	Image image = new Image();
    image.setFileName("attachments/" + name);
    imageRepo.save(image);
    ProductEntity productEntity = new ProductEntity();
	productEntity.setName(productRequest.getName());
	productEntity.setPrice(productRequest.getPrice());
	productEntity.setDescription(productRequest.getDescription());
	productEntity.setImage(image);
   
	return ResponseEntity.ok(productService.addProduct(productEntity));
}

@GetMapping("/download-attachment")
public ResponseEntity getAttachment(@RequestParam("name") String name) {
	String filepath = "attachments/" + name;
	File file = new File(filepath);
      Resource fileSystemResource = new FileSystemResource(file);
      return ResponseEntity.ok()
          .contentType(MediaType.IMAGE_JPEG)
          .body(fileSystemResource);
}
}

// @GetMapping("/download-attachment")
// public ProductEntity getAttachment(@RequestParam(name = "id") Long id) {
// 	ProductEntity productEntity = new ProductEntity();
// 	productEntity = productService.getProduct(id);

// 	// String name = productEntity.getImage().getFileName();
// 	// String filepath = "attachments/" + name;
// 	// File file = new File(filepath);
//     //   Resource fileSystemResource = new FileSystemResource(file);
//       return ProductEntity.builder()
// 	            .id(productEntity.getId())
//                 .name(productEntity.getName())
//                 .price(productEntity.getPrice())
// 				.description(productEntity.getDescription())
//                 .image(productEntity.getImage()).build();
// }
// }
