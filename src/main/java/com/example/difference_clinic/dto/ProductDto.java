package com.example.difference_clinic.dto;

import java.util.Objects;

public class ProductDto {
    
    private Long id;
    private String name;
    private String price;
    private String image;
    private String order;


    public ProductDto() {
    }

    public ProductDto(Long id, String name, String price, String image, String order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.order = order;
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

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public ProductDto id(Long id) {
        setId(id);
        return this;
    }

    public ProductDto name(String name) {
        setName(name);
        return this;
    }

    public ProductDto price(String price) {
        setPrice(price);
        return this;
    }

    public ProductDto image(String image) {
        setImage(image);
        return this;
    }

    public ProductDto order(String order) {
        setOrder(order);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductDto)) {
            return false;
        }
        ProductDto productDto = (ProductDto) o;
        return Objects.equals(id, productDto.id) && Objects.equals(name, productDto.name) && Objects.equals(price, productDto.price) && Objects.equals(image, productDto.image) && Objects.equals(order, productDto.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, image, order);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", image='" + getImage() + "'" +
            ", order='" + getOrder() + "'" +
            "}";
    }

}
