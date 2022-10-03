package com.zen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zen.entities.Users;
import com.zen.services.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/getUserId/{userId}")
	public Users getUserId(@PathVariable ("userId") int userId) {
		return usersService.getUserId(userId);
	}
	
	@PostMapping("/insertUser")
	public Users insertUser(@RequestBody Users user) {
		return usersService.insertUser(user);
	}
	 

}
