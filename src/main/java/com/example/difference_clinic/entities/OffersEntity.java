package com.example.difference_clinic.entities;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "offers")
public class OffersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String image;
    


    public OffersEntity() {
    }

    public OffersEntity(Long id, String title, String description, String image) {
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

    public OffersEntity id(Long id) {
        setId(id);
        return this;
    }

    public OffersEntity title(String title) {
        setTitle(title);
        return this;
    }

    public OffersEntity description(String description) {
        setDescription(description);
        return this;
    }

    public OffersEntity image(String image) {
        setImage(image);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OffersEntity)) {
            return false;
        }
        OffersEntity offersEntity = (OffersEntity) o;
        return Objects.equals(id, offersEntity.id) && Objects.equals(title, offersEntity.title) && Objects.equals(description, offersEntity.description) && Objects.equals(image, offersEntity.image);
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
