package com.zen.entities;

import com.zen.dto.Status;

public class ResponseEntity {

	private Status status;
	private Books books;
	
//	private BooksDto booksDto;
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
//	public BooksDto getBooksDto() {
//		return booksDto;
//	}
//	public void setBooksDto(BooksDto booksDto) {
//		this.booksDto = booksDto;
//	}
	

}
