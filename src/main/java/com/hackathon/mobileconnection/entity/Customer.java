package com.hackathon.mobileconnection.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long customerId;
	private  String name;
	private  LocalDate dateOfBirth;
	private  String idProof;
	private  String idProofType;
	private  String address;
	private  String emailId;
	private  String mobNumber;
	private String altMobNumber;
	
	
}
