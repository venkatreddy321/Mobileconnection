package com.hackathon.mobileconnection.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hackathon.mobileconnection.util.Connection;

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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
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


	@Override
	public String toString() {
		return "CustomerRequest [requestId=" + requestId + ", requestDate=" + requestDate + ", planId=" + planId
				+ ", customerId=" + customerId + ", status=" + status + ", updatedOn=" + updatedOn + ", comments="
				+ comments + ", getRequestId()=" + getRequestId() + ", getRequestDate()=" + getRequestDate()
				+ ", getPlanId()=" + getPlanId() + ", getCustomerId()=" + getCustomerId() + ", getStatus()="
				+ getStatus() + ", getUpdatedOn()=" + getUpdatedOn() + ", getComments()=" + getComments()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
