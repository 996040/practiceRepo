package com.zen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zen.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
