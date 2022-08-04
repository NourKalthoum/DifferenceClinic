package com.example.difference_clinic.services;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

@Service
public class ImageStorageService {
   
    private final Path directory = Paths.get("gallery");

    public void init() throws IOException {
        Files.createDirectory(directory);
    }

    
    public String save(MultipartFile file) {
        try {
            Random rand = new Random();
            String newName = rand.nextInt()+'.'+file.getOriginalFilename();

            Files.copy(file.getInputStream(), this.directory.resolve(newName));
            return newName;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    
    public void delete(String filename) throws IOException {
        FileSystemUtils.deleteRecursively(directory.resolve(filename));
    }
}
