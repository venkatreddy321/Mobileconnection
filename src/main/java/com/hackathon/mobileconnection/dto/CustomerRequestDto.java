package com.hackathon.mobileconnection.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDto {
	@NotNull
	//@Pattern(regexp = "^[a-zA-Z0-9_#$%&’*+/=?^.-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$")
	private  String name;
	@NotNull
	private  LocalDate dateOfBirth;
	@NotNull
	private  String idProof;
	@NotNull
	private  String idProofType;
	@NotNull
	private  String address;
	@NotNull
	private  String emailId;
	@NotNull
	private  String mobNumber;
	@NotNull
	private String altMobNumber;
	@NotNull
	private Long planId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getIdProofType() {
		return idProofType;
	}
	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getAltMobNumber() {
		return altMobNumber;
	}
	public void setAltMobNumber(String altMobNumber) {
		this.altMobNumber = altMobNumber;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}

}
