package com.zen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zen.entities.BookRating;

public interface BookRatingRepository extends JpaRepository<BookRating, Integer> {

	@Query(value = "SELECT * FROM bookstore.book_rating where book_id = :bookId", nativeQuery = true)
//	@Query(value = "SELECT user_rating FROM bookstore.user_rating user_rating where book_id = :bookId",nativeQuery = true)
	BookRating findByBookId(int bookId);

	BookRating findByAverageRating(float averageRating);

;

}
