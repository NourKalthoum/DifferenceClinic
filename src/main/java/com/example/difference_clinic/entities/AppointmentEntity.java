package com.example.difference_clinic.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Time;

@Entity
@Table(name = "appointment")
public class AppointmentEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate appointmentDate;
    private Time appointmentTime;
    private boolean status;
    private String diviceType;

    @JsonIgnoreProperties(value = {"appointment"},allowSetters = true)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "appointment_section", joinColumns = @JoinColumn(name = "appointment_id"), inverseJoinColumns = @JoinColumn(name = "bodySections_id"))
    private List<BodySectionsEntity> bodySections;
    private String note;

    @JsonIgnoreProperties(value = {"appointment","question"},allowSetters = true)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserEntity user;


    public AppointmentEntity() {
    }

    public AppointmentEntity(Long id, LocalDate appointmentDate, Time appointmentTime, boolean status, String diviceType, List<BodySectionsEntity> bodySections, String note, UserEntity user) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.diviceType = diviceType;
        this.bodySections = bodySections;
        this.note = note;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return this.appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDiviceType() {
        return this.diviceType;
    }

    public void setDiviceType(String diviceType) {
        this.diviceType = diviceType;
    }

    public List<BodySectionsEntity> getBodySections() {
        return this.bodySections;
    }

    public void setBodySections(List<BodySectionsEntity> bodySections) {
        this.bodySections = bodySections;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    public AppointmentEntity id(Long id) {
        setId(id);
        return this;
    }

    public AppointmentEntity appointmentDate(LocalDate appointmentDate) {
        setAppointmentDate(appointmentDate);
        return this;
    }

    public AppointmentEntity appointmentTime(Time appointmentTime) {
        setAppointmentTime(appointmentTime);
        return this;
    }

    public AppointmentEntity status(boolean status) {
        setStatus(status);
        return this;
    }

    public AppointmentEntity diviceType(String diviceType) {
        setDiviceType(diviceType);
        return this;
    }

    public AppointmentEntity bodySections(List<BodySectionsEntity> bodySections) {
        setBodySections(bodySections);
        return this;
    }

    public AppointmentEntity note(String note) {
        setNote(note);
        return this;
    }

    public AppointmentEntity user(UserEntity user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AppointmentEntity)) {
            return false;
        }
        AppointmentEntity appointmentEntity = (AppointmentEntity) o;
        return Objects.equals(id, appointmentEntity.id) && Objects.equals(appointmentDate, appointmentEntity.appointmentDate) && Objects.equals(appointmentTime, appointmentEntity.appointmentTime) && status == appointmentEntity.status && Objects.equals(diviceType, appointmentEntity.diviceType) && Objects.equals(bodySections, appointmentEntity.bodySections) && Objects.equals(note, appointmentEntity.note) && Objects.equals(user, appointmentEntity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointmentDate, appointmentTime, status, diviceType, bodySections, note, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", appointmentDate='" + getAppointmentDate() + "'" +
            ", appointmentTime='" + getAppointmentTime() + "'" +
            ", status='" + isStatus() + "'" +
            ", diviceType='" + getDiviceType() + "'" +
            ", bodySections='" + getBodySections() + "'" +
            ", note='" + getNote() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }


}
