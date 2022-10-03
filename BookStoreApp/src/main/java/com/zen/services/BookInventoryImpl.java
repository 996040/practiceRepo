package com.zen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zen.entities.BookInventory;
import com.zen.repository.InventoryRepository;

@Service
public class BookInventoryImpl implements BookInventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public BookInventory getAvailableBook(int Id) {
		// TODO Auto-generated method stub
		return inventoryRepository.findById(Id).get();
	}

	@Override
	public BookInventory insertIntoInventory(BookInventory bookInventory) {
		// TODO Auto-generated method stub
		return inventoryRepository.save(bookInventory);
	}

}
