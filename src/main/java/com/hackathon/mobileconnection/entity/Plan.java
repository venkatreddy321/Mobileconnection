package com.hackathon.mobileconnection.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="plan")
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long planId;
	private String planType;
	private Integer validity;
	private String description;
	private Double price;
	
}
