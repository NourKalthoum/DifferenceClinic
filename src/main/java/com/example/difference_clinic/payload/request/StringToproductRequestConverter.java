package com.example.difference_clinic.payload.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Component
public class StringToproductRequestConverter implements Converter<String, ProductRequest> {
    
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public ProductRequest convert(String source) {
        return objectMapper.readValue(source, ProductRequest.class);
    }
}
