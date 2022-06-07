package com.example.difference_clinic.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.difference_clinic.entities.Image;
import com.example.difference_clinic.repositories.ImageRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ImageController {
    
    @Autowired
    ImageRepo imageRepo;
    
@PostMapping("/upload")
public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	Path path = Paths.get("attachments/" + fileName);
	try {
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException e) {
		e.printStackTrace();
	}
    
    Image image = new Image();
    image.setFileName(fileName);
    
    
	// String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	// 	    .path("/files/download/")
	// 		.path(fileName)
	// 		.toUriString();
	return ResponseEntity.ok(imageRepo.save(image));
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
