package com.zen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zen.dto.Response;
import com.zen.dto.Status;
import com.zen.entities.UserRating;
import com.zen.services.UserRatingService;

@RestController
public class UserRatingController {

	Response response = new Response();
	Status status = new Status();

	@Autowired
	private UserRatingService userRatingService;

	@GetMapping("/getByRatingId/{ratingId}")
	public Response getByRatingId(@PathVariable("ratingId") int ratingId) {
		UserRating rating = userRatingService.getByRatingId(ratingId);
		status.setStatusCode(200);
		status.setStatusMessage("Book Rating By Rating Id");
		response.setStatus(status);
		response.setUserRating(rating);
		return response;
	}

//	@GetMapping("/getRatingByUserId/{userId}")
//	public Response getByUserId(@PathVariable("userId") int userId) {
//		UserRating rating = userRatingService.getByUserId(userId);
//		status.setStatusCode(200);
//		status.setStatusMessage("Book Rating By UserId");
//		response.setStatus(status);
//		response.setUserRating(rating);
//		return response;
//	}

	@PostMapping("/addUserRating")
	public Response addUserRating(@RequestBody UserRating userRating) {
		UserRating rating = userRatingService.addUserRating(userRating);
		status.setStatusCode(200);
		status.setStatusMessage("User Rating Added Successfully...");
		response.setStatus(status);
		response.setUserRating(rating);
		return response;
	}

}
