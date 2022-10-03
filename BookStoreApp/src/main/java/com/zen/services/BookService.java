package com.zen.services;

import java.util.List;

import com.zen.dto.BooksDto;
import com.zen.entities.Books;

public interface BookService {

	public BooksDto getBook(int bookId);

	public List<Books> getAllBooks();

	public Books insertBook(Books books);

	public void updateBook(Books book);

	public void deleteBook(int bookId);

	List<Books> findByBookName(String bookName);

	List<Books> findByAuthor(String author);

	List<Books> findByPublication(String publication);

	List<Books> findByCategory(String category);

}
