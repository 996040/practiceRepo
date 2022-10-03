package com.zen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zen.entities.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {

	List<Books> findByBookName(String bookName);

	List<Books> findByAuthor(String author);

	List<Books> findByPublication(String publication);

	List<Books> findByCategory(String category);
	
	Books findByBookId(int bookId);
	

}
