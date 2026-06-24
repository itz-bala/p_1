package main.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PatientDto {
	
	@NotBlank(message="name is must be")
	private String name;
	
	@Email(message="invalid email")
	
	private String email;
	
	@NotBlank(message="mobilenum must be")
	
	private String mobilenum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	
	
	
	

}
