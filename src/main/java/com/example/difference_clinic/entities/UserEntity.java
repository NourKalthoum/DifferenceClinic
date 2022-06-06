package com.example.difference_clinic.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 120)
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
    @JsonIgnoreProperties(value = {"user"},allowSetters = true)
    @OneToMany(mappedBy = "user")
    private List<AppointmentEntity> appointmens;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity(Long id, String username, String password, Set<Role> roles, Boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.status = status;

    }

    public UserEntity(String username, String password, Boolean status) {
        this.username = username;
        this.password = password;
        this.status = status;

    }

    public UserEntity(String username, String password,String firstName, String lastName) {
        
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

    }



    public UserEntity(Long id, String firstName, String lastName, String username, String password, String mobile, String gender, String job, Date birthday, Long score, String socialStatus, Boolean status, Boolean isActive, String zipCode, List<AppointmentEntity> appointmens, Set<Role> roles) {
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
        this.appointmens = appointmens;
        this.roles = roles;
    }
   

   
   
   


}
