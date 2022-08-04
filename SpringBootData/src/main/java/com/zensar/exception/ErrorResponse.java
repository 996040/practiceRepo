package com.zensar.exception;

import com.zensar.status.Status;

public class ErrorResponse {

	private Status status;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(Status status) {
		super();
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	

}
