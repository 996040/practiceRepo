package com.zen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zen.entities.UserRating;

public interface UserRatingRepository extends JpaRepository<UserRating, Integer> {

//	UserRating getByUserId(int userId);

	UserRating findByUserRating(float userRating);

//	@Query(value = "SELECT user_rating FROM bookstore.user_rating user_rating where book_id = :bookId", nativeQuery = true)
	List<UserRating> findByBookId(int bookId);

}
