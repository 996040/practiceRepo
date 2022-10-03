package com.zen.services;

import com.zen.entities.UserRating;

public interface UserRatingService {

	public UserRating getByRatingId(int ratingId);

//	UserRating getByUserId(int userId);

	public UserRating addUserRating(UserRating userRating);

}
