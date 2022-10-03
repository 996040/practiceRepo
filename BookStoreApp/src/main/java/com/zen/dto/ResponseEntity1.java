package com.zen.dto;

public class ResponseEntity1 {
	
	private Status status;
	
	private BooksDto booksDto;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BooksDto getBooksDto() {
		return booksDto;
	}

	public void setBooksDto(BooksDto booksDto) {
		this.booksDto = booksDto;
	}
	
	

}
