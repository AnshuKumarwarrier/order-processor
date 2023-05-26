package com.planet.Error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class OrderErrorResponse {

	
	private LocalDateTime localDateTime;
	private String message;
	private String details;
	private HttpStatus httpStatus;
	
	
	
	
	
	public OrderErrorResponse(LocalDateTime localDateTime, String message, String details, HttpStatus httpStatus) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
		this.httpStatus = httpStatus;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	
	
	
}
