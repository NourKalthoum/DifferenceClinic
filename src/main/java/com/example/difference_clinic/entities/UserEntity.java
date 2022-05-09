package com.example.difference_clinic.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Long mobile;
    private String gender;
    private String job;
    private String birthday;
    private String userType;
    private Long score;
    private String socialStatus;
    private String patientStatus;
    @OneToMany(mappedBy = "user")
    private List<QuestionEntity> questions;



    public UserEntity() {
    }

    public UserEntity(Long id, String firstName, String lastName, Long mobile, String gender, String job, String birthday, String userType, Long score, String socialStatus, String patientStatus, List<QuestionEntity> questions) {
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
        this.questions = questions;
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

    public Long getMobile() {
        return this.mobile;
    }

    public void setMobile(Long mobile) {
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

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
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

    public String getPatientStatus() {
        return this.patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public List<QuestionEntity> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
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

    public UserEntity mobile(Long mobile) {
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

    public UserEntity birthday(String birthday) {
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

    public UserEntity patientStatus(String patientStatus) {
        setPatientStatus(patientStatus);
        return this;
    }

    public UserEntity questions(List<QuestionEntity> questions) {
        setQuestions(questions);
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
        return Objects.equals(id, userEntity.id) && Objects.equals(firstName, userEntity.firstName) && Objects.equals(lastName, userEntity.lastName) && Objects.equals(mobile, userEntity.mobile) && Objects.equals(gender, userEntity.gender) && Objects.equals(job, userEntity.job) && Objects.equals(birthday, userEntity.birthday) && Objects.equals(userType, userEntity.userType) && Objects.equals(score, userEntity.score) && Objects.equals(socialStatus, userEntity.socialStatus) && Objects.equals(patientStatus, userEntity.patientStatus) && Objects.equals(questions, userEntity.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobile, gender, job, birthday, userType, score, socialStatus, patientStatus, questions);
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
            ", patientStatus='" + getPatientStatus() + "'" +
            ", questions='" + getQuestions() + "'" +
            "}";
    }

}
