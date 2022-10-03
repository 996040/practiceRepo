package com.zen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zen.dto.BooksDto;
import com.zen.entities.BookRating;
import com.zen.entities.Books;
import com.zen.repository.BookRatingRepository;
import com.zen.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookRatingRepository bookRatingRepository;
	
//	RestTemplate restTemplate = new RestTemplate();

	@Override
	public BooksDto getBook(int bookId) {

		BooksDto bookDto = new BooksDto();
		
		Books books = bookRepository.findById(bookId).get();

		bookDto.setAuthor(books.getAuthor());
		bookDto.setBookId(books.getBookId());
		bookDto.setBookName(books.getBookName());
		bookDto.setCategory(books.getCategory());
		bookDto.setPublication(books.getPublication());

		BookRating bookRating = bookRatingRepository.findByBookId(bookId);
		if (bookRating == null) {
			bookDto.setAverageRating(0);
		} else {
			bookDto.setAverageRating(bookRating.getAverageRating());

		}

		return bookDto;

	}

	@Override
	public Books insertBook(Books books) {

		return bookRepository.save(books);

	}

	@Override
	public List<Books> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public List<Books> findByBookName(String bookName) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookName(bookName);
	}

	@Override
	public List<Books> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Books> findByPublication(String publication) {
		// TODO Auto-generated method stub
		return bookRepository.findByPublication(publication);
	}

	@Override
	public List<Books> findByCategory(String category) {
		// TODO Auto-generated method stub
		return bookRepository.findByCategory(category);
	}

	@Override
	public void updateBook(Books book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(bookId);
	}

}
