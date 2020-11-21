package com.hackathon.mobileconnection.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.hackathon.mobileconnection.util.Connection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectionResponseDto {
 
	private Long requestId;
	private LocalDateTime requestDate;
	private Long planId;
	private Long customerId;
	private Connection status;
	private LocalDateTime updatedOn;
	private String comments;
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public LocalDateTime getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Connection getStatus() {
		return status;
	}
	public void setStatus(Connection status) {
		this.status = status;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	
}

