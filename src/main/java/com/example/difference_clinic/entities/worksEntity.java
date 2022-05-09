package com.example.difference_clinic.entities;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "works")
public class worksEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String image;

    public worksEntity() {
    }

    public worksEntity(Long id, String title, String description, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public worksEntity id(Long id) {
        setId(id);
        return this;
    }

    public worksEntity title(String title) {
        setTitle(title);
        return this;
    }

    public worksEntity description(String description) {
        setDescription(description);
        return this;
    }

    public worksEntity image(String image) {
        setImage(image);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof worksEntity)) {
            return false;
        }
        worksEntity worksEntity = (worksEntity) o;
        return Objects.equals(id, worksEntity.id) && Objects.equals(title, worksEntity.title) && Objects.equals(description, worksEntity.description) && Objects.equals(image, worksEntity.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, image);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", image='" + getImage() + "'" +
            "}";
    }
   
}
