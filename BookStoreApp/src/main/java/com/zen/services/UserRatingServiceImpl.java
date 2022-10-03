package com.zen.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zen.entities.BookRating;
import com.zen.entities.Books;
import com.zen.entities.UserRating;
import com.zen.repository.BookRatingRepository;
import com.zen.repository.BookRepository;
import com.zen.repository.UserRatingRepository;

@Service
public class UserRatingServiceImpl implements UserRatingService {

	@Autowired
	private UserRatingRepository userRatingRepository;

	@Autowired
	private BookRatingRepository bookRatingRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public UserRating getByRatingId(int ratingId) {
		// TODO Auto-generated method stub
		return userRatingRepository.findById(ratingId).get();
	}

//	@Override
//	public UserRating getByUserId(int userId) {
//		// TODO Auto-generated method stub
//		return userRatingRepository.getByUserId(userId);
//	}

	@Override
	public UserRating addUserRating(UserRating userRating) {

		BookRating rating = new BookRating();

		Books book = new Books();
		book.setBookId(userRating.getBookId());

		// http://localhost:9797/getBookRatingByBookId/{bookId}
		
		Books books = bookRepository.findByBookId(book.getBookId()); // get books details from here in rest template

		if (userRating.getBookId() == books.getBookId()) {
			userRatingRepository.save(userRating);
		} else {
			throw new NullPointerException("No Book Available for Rating");
		}

		if (userRating.getUserRating() > 5) {
			throw new NullPointerException("Rating Must Not Be greater than 5.0");
		} else {
			userRatingRepository.save(userRating);
		}

		rating.setBookId(userRating.getBookId());
		rating.setAverageRating(userRating.getUserRating());
		rating.setBookRatingId(userRating.getBookId());

		List<UserRating> rate = userRatingRepository.findByBookId(userRating.getBookId());

		float sum = 0;

		for (int i = 0; i < rate.size(); i++) {
			sum += rate.get(i).getUserRating();
		}

		float average = sum / rate.size();

		System.out.println("Average:- " + average);

		System.out.println("Sum:- " + sum);

		rating.setAverageRating(average);

		bookRatingRepository.save(rating);

		return userRating;

	}

}
