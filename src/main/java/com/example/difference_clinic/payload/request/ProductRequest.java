package com.example.difference_clinic.payload.request;

public class ProductRequest {

    private String name;
    private String price; 
    private String description;

    public ProductRequest() {
    }

    public ProductRequest(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductRequest name(String name) {
        setName(name);
        return this;
    }

    public ProductRequest price(String price) {
        setPrice(price);
        return this;
    }

    public ProductRequest description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

}
