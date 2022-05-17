package com.example.difference_clinic.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class UserEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobile;
    private String gender;
    private String job;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Long score;
    private String socialStatus;
    private boolean isActive;
    private String codeNum;
    // @JsonIgnoreProperties(value = {"user"},allowSetters = true)
    // @OneToMany(mappedBy = "user")
    // private List<QuestionEntity> questions;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection <Role>roles= new ArrayList<>();
   

    public UserEntity() {
    }

    public UserEntity(Long id, String firstName, String lastName, String userName, String password, String mobile, String gender, String job, Date birthday, Long score, String socialStatus, boolean isActive, String codeNum, Collection<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.gender = gender;
        this.job = job;
        this.birthday = birthday;
        this.score = score;
        this.socialStatus = socialStatus;
        this.isActive = isActive;
        this.codeNum = codeNum;
        this.roles = roles;
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

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCodeNum() {
        return this.codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }

    public Collection<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
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

    public UserEntity userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
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

    public UserEntity score(Long score) {
        setScore(score);
        return this;
    }

    public UserEntity socialStatus(String socialStatus) {
        setSocialStatus(socialStatus);
        return this;
    }

    public UserEntity isActive(boolean isActive) {
        setIsActive(isActive);
        return this;
    }

    public UserEntity codeNum(String codeNum) {
        setCodeNum(codeNum);
        return this;
    }

    public UserEntity roles(Collection<Role> roles) {
        setRoles(roles);
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
        return Objects.equals(id, userEntity.id) && Objects.equals(firstName, userEntity.firstName) && Objects.equals(lastName, userEntity.lastName) && Objects.equals(userName, userEntity.userName) && Objects.equals(password, userEntity.password) && Objects.equals(mobile, userEntity.mobile) && Objects.equals(gender, userEntity.gender) && Objects.equals(job, userEntity.job) && Objects.equals(birthday, userEntity.birthday) && Objects.equals(score, userEntity.score) && Objects.equals(socialStatus, userEntity.socialStatus) && isActive == userEntity.isActive && Objects.equals(codeNum, userEntity.codeNum) && Objects.equals(roles, userEntity.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, mobile, gender, job, birthday, score, socialStatus, isActive, codeNum, roles);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", password='" + getPassword() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", gender='" + getGender() + "'" +
            ", job='" + getJob() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", score='" + getScore() + "'" +
            ", socialStatus='" + getSocialStatus() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", codeNum='" + getCodeNum() + "'" +
            ", roles='" + getRoles() + "'" +
            "}";
    }
   
}
