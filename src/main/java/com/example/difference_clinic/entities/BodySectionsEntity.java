package com.example.difference_clinic.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bodySections")
public class BodySectionsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String section;

    public BodySectionsEntity() {
    }

    public BodySectionsEntity(Long id, String section) {
        this.id = id;
        this.section = section;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public BodySectionsEntity id(Long id) {
        setId(id);
        return this;
    }

    public BodySectionsEntity section(String section) {
        setSection(section);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BodySectionsEntity)) {
            return false;
        }
        BodySectionsEntity bodySectionsEntity = (BodySectionsEntity) o;
        return Objects.equals(id, bodySectionsEntity.id) && Objects.equals(section, bodySectionsEntity.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, section);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", section='" + getSection() + "'" +
            "}";
    }
   
    
}
