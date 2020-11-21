package com.hackathon.mobileconnection.dto;

import lombok.Data;

@Data
public class ResponseDto {
	
	private String message;
	private Integer statusCode;
	private Long requestId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Long getRequestid() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	
}
