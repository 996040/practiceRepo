 package com.zen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookRating {

	@Id
//	@GeneratedValue
	private int bookRatingId;
	
	private int bookId;

	private float averageRating;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public int getBookRatingId() {
		return bookRatingId;
	}

	public void setBookRatingId(int bookRatingId) {
		this.bookRatingId = bookRatingId;
	}
	

}
