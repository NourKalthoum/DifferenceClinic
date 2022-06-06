package com.example.difference_clinic.payload.response;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class FullResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
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
    private List<String> roles;
    private String token;
	



    public FullResponse() {
    }

    public FullResponse(Long id, String firstName, String lastName, String username, String password, String mobile, String gender, String job, Date birthday, Long score, String socialStatus, Boolean status, Boolean isActive, String zipCode, List<String> roles, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.gender = gender;
        this.job = job;
        this.birthday = birthday;
        this.score = score;
        this.socialStatus = socialStatus;
        this.status = status;
        this.isActive = isActive;
        this.zipCode = zipCode;
        this.roles = roles;
        this.token = token;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public FullResponse id(Long id) {
        setId(id);
        return this;
    }

    public FullResponse firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public FullResponse lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public FullResponse username(String username) {
        setUsername(username);
        return this;
    }

    public FullResponse password(String password) {
        setPassword(password);
        return this;
    }

    public FullResponse mobile(String mobile) {
        setMobile(mobile);
        return this;
    }

    public FullResponse gender(String gender) {
        setGender(gender);
        return this;
    }

    public FullResponse job(String job) {
        setJob(job);
        return this;
    }

    public FullResponse birthday(Date birthday) {
        setBirthday(birthday);
        return this;
    }

    public FullResponse score(Long score) {
        setScore(score);
        return this;
    }

    public FullResponse socialStatus(String socialStatus) {
        setSocialStatus(socialStatus);
        return this;
    }

    public FullResponse status(Boolean status) {
        setStatus(status);
        return this;
    }

    public FullResponse isActive(Boolean isActive) {
        setIsActive(isActive);
        return this;
    }

    public FullResponse zipCode(String zipCode) {
        setZipCode(zipCode);
        return this;
    }

    public FullResponse roles(List<String> roles) {
        setRoles(roles);
        return this;
    }

    public FullResponse token(String token) {
        setToken(token);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FullResponse)) {
            return false;
        }
        FullResponse fullResponse = (FullResponse) o;
        return Objects.equals(id, fullResponse.id) && Objects.equals(firstName, fullResponse.firstName) && Objects.equals(lastName, fullResponse.lastName) && Objects.equals(username, fullResponse.username) && Objects.equals(password, fullResponse.password) && Objects.equals(mobile, fullResponse.mobile) && Objects.equals(gender, fullResponse.gender) && Objects.equals(job, fullResponse.job) && Objects.equals(birthday, fullResponse.birthday) && Objects.equals(score, fullResponse.score) && Objects.equals(socialStatus, fullResponse.socialStatus) && Objects.equals(status, fullResponse.status) && Objects.equals(isActive, fullResponse.isActive) && Objects.equals(zipCode, fullResponse.zipCode) && Objects.equals(roles, fullResponse.roles) && Objects.equals(token, fullResponse.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, mobile, gender, job, birthday, score, socialStatus, status, isActive, zipCode, roles, token);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", gender='" + getGender() + "'" +
            ", job='" + getJob() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", score='" + getScore() + "'" +
            ", socialStatus='" + getSocialStatus() + "'" +
            ", status='" + isStatus() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", roles='" + getRoles() + "'" +
            ", token='" + getToken() + "'" +
            "}";
    }

}
