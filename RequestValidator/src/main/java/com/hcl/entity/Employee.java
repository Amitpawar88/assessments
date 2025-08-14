package com.hcl.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotBlank(message = "The fullName is a mandatory field")
	private String fullName;
	
	@Pattern(regexp = "\\d{10}", message = "The mobileNumber is a mandatory field")
	private String mobileNumber;
	
	@NotBlank(message = "The emailId is a mandatory field")
	@Email(message = "The emailId should be in a valid email format")
	private String emailId;
	
	@NotBlank(message = "The dateOfBirth is a mandatory field")
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}$", message = "he dateOfBirth should be in YYYY-MM-DD format")
	@JsonFormat(pattern = "YYYY-MM-DD")
	private String dateOfBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Employee() {
		super();
	}
}
