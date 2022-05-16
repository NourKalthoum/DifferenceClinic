package com.example.difference_clinic.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class UserEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private String job;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String userType;
    private Long score;
    private String socialStatus;
    private boolean patientStatus;
    // @JsonIgnoreProperties(value = {"user"},allowSetters = true)
    // @OneToMany(mappedBy = "user")
    // private List<QuestionEntity> questions;



    public UserEntity() {
    }

    public UserEntity(Long id, String firstName, String lastName, String mobile, String gender, String job, Date birthday, String userType, Long score, String socialStatus, boolean patientStatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.job = job;
        this.birthday = birthday;
        this.userType = userType;
        this.score = score;
        this.socialStatus = socialStatus;
        this.patientStatus = patientStatus;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getScore() {
        return this.score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getSocialStatus() {
        return this.socialStatus;
    }

    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    public boolean isPatientStatus() {
        return this.patientStatus;
    }

    public boolean getPatientStatus() {
        return this.patientStatus;
    }

    public void setPatientStatus(boolean patientStatus) {
        this.patientStatus = patientStatus;
    }

    public UserEntity id(Long id) {
        setId(id);
        return this;
    }

    public UserEntity firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserEntity lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserEntity mobile(String mobile) {
        setMobile(mobile);
        return this;
    }

    public UserEntity gender(String gender) {
        setGender(gender);
        return this;
    }

    public UserEntity job(String job) {
        setJob(job);
        return this;
    }

    public UserEntity birthday(Date birthday) {
        setBirthday(birthday);
        return this;
    }

    public UserEntity userType(String userType) {
        setUserType(userType);
        return this;
    }

    public UserEntity score(Long score) {
        setScore(score);
        return this;
    }

    public UserEntity socialStatus(String socialStatus) {
        setSocialStatus(socialStatus);
        return this;
    }

    public UserEntity patientStatus(boolean patientStatus) {
        setPatientStatus(patientStatus);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) && Objects.equals(firstName, userEntity.firstName) && Objects.equals(lastName, userEntity.lastName) && Objects.equals(mobile, userEntity.mobile) && Objects.equals(gender, userEntity.gender) && Objects.equals(job, userEntity.job) && Objects.equals(birthday, userEntity.birthday) && Objects.equals(userType, userEntity.userType) && Objects.equals(score, userEntity.score) && Objects.equals(socialStatus, userEntity.socialStatus) && patientStatus == userEntity.patientStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobile, gender, job, birthday, userType, score, socialStatus, patientStatus);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", gender='" + getGender() + "'" +
            ", job='" + getJob() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", userType='" + getUserType() + "'" +
            ", score='" + getScore() + "'" +
            ", socialStatus='" + getSocialStatus() + "'" +
            ", patientStatus='" + isPatientStatus() + "'" +
            "}";
    }


}
