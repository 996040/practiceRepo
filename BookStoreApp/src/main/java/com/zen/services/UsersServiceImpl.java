package com.zen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zen.entities.Books;
import com.zen.entities.Users;
import com.zen.repository.BookRepository;
import com.zen.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository usersRepository;


	@Override
	public Users getUserId(int userId) {
		// TODO Auto-generated method stub
		return usersRepository.findById(userId).get();
	}

	@Override
	public Users insertUser(Users user) {
	
		return usersRepository.save(user);
	}

}
