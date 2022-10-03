package com.zen.dto;

import com.zen.entities.UserRating;

public class Response {
	
	private Status status;
	
	private UserRating userRating;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserRating getUserRating() {
		return userRating;
	}

	public void setUserRating(UserRating userRating) {
		this.userRating = userRating;
	}
	
	

}
