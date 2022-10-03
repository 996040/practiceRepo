package com.zen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Books {

	@Id
	@Min(value = 1,message = "No BookId Available For the Given Data" )
	private int bookId;

	@NotEmpty(message = "BookName Must Not be Empty")
	private String bookName;

	@NotEmpty(message = "Author Does Not Exists")
	private String author;

	@NotEmpty(message = "Publication should not Null")
	private String publication;

	@NotEmpty(message = "Book Category Must Not Be empty")
	private String category;

	public Books() {
		super();
	}

	public Books(int bookId, @NotEmpty(message = "BookName Must Not be Empty") String bookName,
			@NotEmpty(message = "Author Does Not Exists") String author,
			@NotEmpty(message = "Insert Publication should not Null") String publication,
			@NotEmpty(message = "Book Category Must Not Be empty") String category) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.category = category;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
