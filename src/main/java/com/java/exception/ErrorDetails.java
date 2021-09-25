package com.java.exception;

import java.util.Date;

//DTO object that will return to client

public class ErrorDetails {

	private Date timsestamp;

	private String message;

	private String details;

	public ErrorDetails(Date timsestamp, String message, String details) {
		super();
		this.timsestamp = timsestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimsestamp() {
		return timsestamp;
	}

	public void setTimsestamp(Date timsestamp) {
		this.timsestamp = timsestamp;
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

}
