package com.example.difference_clinic.payload.response;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo {
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private String job;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Long score;
    private String socialStatus;
    private Boolean status;
    private Boolean isActive;
    private String zipCode;


    public UserInfo() {
    }

    public UserInfo(String firstName, String lastName, String mobile, String gender, String job, Date birthday, Long score, String socialStatus, Boolean status, Boolean isActive, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.job = job;
        this.birthday = birthday;
        this.score = score;
        this.socialStatus = socialStatus;
        this.status = status;
        this.isActive = isActive;
        this.zipCode = zipCode;
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

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isIsActive() {
        return this.isActive;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public UserInfo firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserInfo lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserInfo mobile(String mobile) {
        setMobile(mobile);
        return this;
    }

    public UserInfo gender(String gender) {
        setGender(gender);
        return this;
    }

    public UserInfo job(String job) {
        setJob(job);
        return this;
    }

    public UserInfo birthday(Date birthday) {
        setBirthday(birthday);
        return this;
    }

    public UserInfo score(Long score) {
        setScore(score);
        return this;
    }

    public UserInfo socialStatus(String socialStatus) {
        setSocialStatus(socialStatus);
        return this;
    }

    public UserInfo status(Boolean status) {
        setStatus(status);
        return this;
    }

    public UserInfo isActive(Boolean isActive) {
        setIsActive(isActive);
        return this;
    }

    public UserInfo zipCode(String zipCode) {
        setZipCode(zipCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(firstName, userInfo.firstName) && Objects.equals(lastName, userInfo.lastName) && Objects.equals(mobile, userInfo.mobile) && Objects.equals(gender, userInfo.gender) && Objects.equals(job, userInfo.job) && Objects.equals(birthday, userInfo.birthday) && Objects.equals(score, userInfo.score) && Objects.equals(socialStatus, userInfo.socialStatus) && Objects.equals(status, userInfo.status) && Objects.equals(isActive, userInfo.isActive) && Objects.equals(zipCode, userInfo.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mobile, gender, job, birthday, score, socialStatus, status, isActive, zipCode);
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", gender='" + getGender() + "'" +
            ", job='" + getJob() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", score='" + getScore() + "'" +
            ", socialStatus='" + getSocialStatus() + "'" +
            ", status='" + isStatus() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            "}";
    }

}
