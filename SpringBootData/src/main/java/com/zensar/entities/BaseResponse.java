package com.zensar.entities;

import com.zensar.status.Status;

public class BaseResponse {
	
	private Status status;
	
	private Details details;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	
	

}
