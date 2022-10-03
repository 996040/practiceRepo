package com.zen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserRating {

	@Id
	private int ratingId;
	private int bookId;
	private int userId;
	private float userRating;
	private String review;
	
//	@OneToOne(targetEntity = Users.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "users")
//	private Users users;

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getUserRating() {
		return userRating;
	}

	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

//	public Users getUsers() {
//		return users;
//	}
//
//	public void setUsers(Users users) {
//		this.users = users;
//	}
	

}
