package com.example.difference_clinic.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aboutCenter")
public class AboutCenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String genesis;
    private String services;

    public AboutCenterEntity() {
    }

    public AboutCenterEntity(Long id, String genesis, String services) {
        this.id = id;
        this.genesis = genesis;
        this.services = services;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenesis() {
        return this.genesis;
    }

    public void setGenesis(String genesis) {
        this.genesis = genesis;
    }

    public String getServices() {
        return this.services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public AboutCenterEntity id(Long id) {
        setId(id);
        return this;
    }

    public AboutCenterEntity genesis(String genesis) {
        setGenesis(genesis);
        return this;
    }

    public AboutCenterEntity services(String services) {
        setServices(services);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AboutCenterEntity)) {
            return false;
        }
        AboutCenterEntity aboutCenterEntity = (AboutCenterEntity) o;
        return Objects.equals(id, aboutCenterEntity.id) && Objects.equals(genesis, aboutCenterEntity.genesis) && Objects.equals(services, aboutCenterEntity.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genesis, services);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", genesis='" + getGenesis() + "'" +
            ", services='" + getServices() + "'" +
            "}";
    }

}
