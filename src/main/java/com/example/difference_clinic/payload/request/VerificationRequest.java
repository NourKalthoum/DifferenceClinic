package com.example.difference_clinic.payload.request;
import java.util.Objects;

import javax.validation.constraints.*;
public class VerificationRequest {
    
    @NotBlank
	private String username;

    @NotBlank
	private String password; 

	@NotBlank
    private String zipCode;


    public VerificationRequest() {
    }

    public VerificationRequest(String username, String password, String zipCode) {
        this.username = username;
        this.password = password;
        this.zipCode = zipCode;
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

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public VerificationRequest username(String username) {
        setUsername(username);
        return this;
    }

    public VerificationRequest password(String password) {
        setPassword(password);
        return this;
    }

    public VerificationRequest zipCode(String zipCode) {
        setZipCode(zipCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VerificationRequest)) {
            return false;
        }
        VerificationRequest verificationRequest = (VerificationRequest) o;
        return Objects.equals(username, verificationRequest.username) && Objects.equals(password, verificationRequest.password) && Objects.equals(zipCode, verificationRequest.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, zipCode);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            "}";
    }
   
}
