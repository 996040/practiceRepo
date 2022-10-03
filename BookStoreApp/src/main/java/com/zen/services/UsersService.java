package com.zen.services;

import com.zen.entities.Users;

public interface UsersService {

	Users getUserId(int userId);

	Users insertUser(Users user);

}
