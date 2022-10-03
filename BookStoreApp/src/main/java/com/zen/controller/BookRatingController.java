package com.zen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zen.entities.BookRating;
import com.zen.services.BookRatingService;

@RestController
public class BookRatingController {

	@Autowired
	private BookRatingService bookRatingService;

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/getBookRatingByBookId/{bookId}")
	public BookRating getBookRatingByBookId(@PathVariable("bookId") int bookId) {
		return bookRatingService.getBookRatingByBookId(bookId);
	}
	
	

}
