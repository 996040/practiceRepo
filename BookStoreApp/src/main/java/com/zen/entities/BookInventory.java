package com.zen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookInventory {

	@Id
	private int bookInventoryId;
	private int capacity;
	private String bookName;
	private int bookId;

	public int getBookInventoryId() {
		return bookInventoryId;
	}

	public void setBookInventoryId(int bookInventoryId) {
		this.bookInventoryId = bookInventoryId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
