package com.example.difference_clinic.entities;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String price;
    private String image;
    private String description;



    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String price, String image, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductEntity id(Long id) {
        setId(id);
        return this;
    }

    public ProductEntity name(String name) {
        setName(name);
        return this;
    }

    public ProductEntity price(String price) {
        setPrice(price);
        return this;
    }

    public ProductEntity image(String image) {
        setImage(image);
        return this;
    }

    public ProductEntity description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductEntity)) {
            return false;
        }
        ProductEntity productEntity = (ProductEntity) o;
        return Objects.equals(id, productEntity.id) && Objects.equals(name, productEntity.name) && Objects.equals(price, productEntity.price) && Objects.equals(image, productEntity.image) && Objects.equals(description, productEntity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, image, description);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", image='" + getImage() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
   
}
