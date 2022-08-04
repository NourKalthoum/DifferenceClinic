package com.example.difference_clinic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ExternalFilePath implements WebMvcConfigurer {

    String ExternalFile = "file:///C:/Users/Mostafa/Desktop/Nour/DifferenceClinic/gallery/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/gallery/**").addResourceLocations(ExternalFile);
    }
}