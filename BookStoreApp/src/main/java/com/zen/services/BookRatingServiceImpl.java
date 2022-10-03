package com.zen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zen.entities.BookRating;
import com.zen.repository.BookRatingRepository;

@Service
public class BookRatingServiceImpl implements BookRatingService{
	
	@Autowired
	private BookRatingRepository bookRatingRepository;

	@Override
	public BookRating getBookRatingByBookId(int bookId) {
		// TODO Auto-generated method stub
		return bookRatingRepository.findById(bookId).get();
	}

}
