package com.zen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zen.entities.BookInventory;
import com.zen.services.BookInventoryService;

@RestController
public class BookInventoryController {

	@Autowired
	private BookInventoryService bookInventoryService;

	@GetMapping("/bookAvailable/{inventoryId}")
	public BookInventory getAvailableBook(@PathVariable("inventoryId") int Id) {
		return bookInventoryService.getAvailableBook(Id);
	}

	@PostMapping("/insertIntoInventory")
	public BookInventory insertIntoInventory(@RequestBody BookInventory bookInventory) {
		return bookInventoryService.insertIntoInventory(bookInventory);
	}

}
