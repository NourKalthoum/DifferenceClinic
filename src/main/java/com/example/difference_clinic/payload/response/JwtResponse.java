package com.example.difference_clinic.payload.response;

import java.util.Date;
import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private String job;
    private Date birthday;
    private Long score;
    private String socialStatus;
    private Boolean status;
    private Boolean isActive;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, List<String> roles,String firstName, String lastName, String mobile, String gender, String job, Date birthday, Long score, String socialStatus, Boolean status, Boolean isActive) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
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
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
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

    public JwtResponse firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public JwtResponse lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public JwtResponse mobile(String mobile) {
        setMobile(mobile);
        return this;
    }

    public JwtResponse gender(String gender) {
        setGender(gender);
        return this;
    }

    public JwtResponse job(String job) {
        setJob(job);
        return this;
    }

    public JwtResponse birthday(Date birthday) {
        setBirthday(birthday);
        return this;
    }

    public JwtResponse score(Long score) {
        setScore(score);
        return this;
    }

    public JwtResponse socialStatus(String socialStatus) {
        setSocialStatus(socialStatus);
        return this;
    }

    public JwtResponse status(Boolean status) {
        setStatus(status);
        return this;
    }

    public JwtResponse isActive(Boolean isActive) {
        setIsActive(isActive);
        return this;
    }
}
