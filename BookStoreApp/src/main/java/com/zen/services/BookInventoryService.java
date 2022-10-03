package com.zen.services;

import com.zen.entities.BookInventory;

public interface BookInventoryService {

	public BookInventory getAvailableBook(int Id);
	
	public BookInventory insertIntoInventory(BookInventory bookInventory);
	
	

}
