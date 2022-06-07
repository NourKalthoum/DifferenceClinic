package com.example.difference_clinic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Image")
public class Image {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String fileName;
    

    public Image() {
    }

    public Image(Long id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Image id(Long id) {
        setId(id);
        return this;
    }

    public Image fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

   

}
