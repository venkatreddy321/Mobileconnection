package com.hackathon.mobileconnection.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="customer_request")
public class CustomerRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
	private LocalDateTime requestDate;
	private Long planId;
	private Long customerId;
	private String status;
	private LocalDateTime updatedOn;
	private String comments;
	
	
}
