package com.example.difference_clinic.security.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.difference_clinic.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
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
    
  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String username, String password, String firstName, String lastName,Date birthday,String mobile,Long score,String socialStatus,Boolean isActive, String job, String gender, boolean status, 
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.score = score;
    this.socialStatus = socialStatus;
    this.status = status;
    this.isActive = isActive;
    this.job = job;
    this.gender = gender;
    this.mobile = mobile;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(UserEntity user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(), 
        user.getUsername(), 
        user.getPassword(), 
        user.getFirstName(),
        user.getLastName(),
        user.getBirthday(),
        user.getMobile(),
        user.getScore(),
        user.getSocialStatus(),
        user.getIsActive(),
        user.getJob(),
        user.getGender(),
        user.getStatus(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMobile() {
    return mobile;
  }

  public String getJob() {
    return job;
  }

  public String getGender() {
    return gender;
  }

  public boolean isIsActive() {
    return this.isActive;
}

public boolean getIsActive() {
    return this.isActive;
}

public boolean isStatus() {
  return this.status;
}

public boolean getStatus() {
  return this.status;
}

  public String getSocialStatus() {
    return socialStatus;
  }
  public Date getBirthday(){
    return birthday;
  }
  

  public Long getScore() {
    return score;
  }

  @Override
  public String getPassword() {
    return password;
  }

  
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
