package com.example.difference_clinic.dto;

import java.util.Objects;

public class WorksDto {
   
    private Long id;
    private String title;
    private String description;
    private String image;
    private String order;


    public WorksDto() {
    }

    public WorksDto(Long id, String title, String description, String image, String order) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.order = order;
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

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public WorksDto id(Long id) {
        setId(id);
        return this;
    }

    public WorksDto title(String title) {
        setTitle(title);
        return this;
    }

    public WorksDto description(String description) {
        setDescription(description);
        return this;
    }

    public WorksDto image(String image) {
        setImage(image);
        return this;
    }

    public WorksDto order(String order) {
        setOrder(order);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorksDto)) {
            return false;
        }
        WorksDto worksDto = (WorksDto) o;
        return Objects.equals(id, worksDto.id) && Objects.equals(title, worksDto.title) && Objects.equals(description, worksDto.description) && Objects.equals(image, worksDto.image) && Objects.equals(order, worksDto.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, image, order);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", image='" + getImage() + "'" +
            ", order='" + getOrder() + "'" +
            "}";
    }

}
