package com.zen.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zen.dto.BooksDto;
import com.zen.dto.ResponseEntity1;
import com.zen.dto.Status;
import com.zen.entities.Books;
import com.zen.entities.ResponseEntity;
import com.zen.services.BookService;

@RestController
public class BooksController {

	@Autowired
	private BookService bookService;

	@Autowired
	RestTemplate restTemplate;

	public static final String get_AllBooks_URL = "http://localhost:9696/book-api/getAllBooks";
	
	public static final String get_BooksById_URL = "http://localhost:9696/book-api/getBookById/1";

	@GetMapping("/getBook/{bookId}")
	public ResponseEntity1 getBook(@PathVariable("bookId") int bookId) {
		ResponseEntity1 entity = new ResponseEntity1();
		Status status = new Status();
		BooksDto books = bookService.getBook(bookId);
		status.setStatusCode(200);
		status.setStatusMessage("Book with the given Id");
		entity.setStatus(status);
		entity.setBooksDto(books);
		return entity;
	}

	@PostMapping("/insertBook")
	public ResponseEntity insertBook(@RequestBody @Valid Books book) {
		ResponseEntity entity = new ResponseEntity();
		Status status = new Status();
		Books books = bookService.insertBook(book);
		status.setStatusCode(200);
		status.setStatusMessage("Book Data Inserted Successfully!!!");
		entity.setStatus(status);
		entity.setBooks(books);
		return entity;
	}

//	@GetMapping("/getAllBooks")
//	public List<Books> getAllBooks() {
//		return bookService.getAllBooks();
//
//	}

	@GetMapping("/getBooksByRestTemplate")  // get All Books Using Rest Template running on port 9696
	public String getAllBooks() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(header);
		return restTemplate.exchange(get_AllBooks_URL, HttpMethod.GET, entity, String.class).getBody();
	}

	@GetMapping("/getBookById/{bookId}") // get BookById Using Rest Template running on port 9696
	public String getBookById() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(header);
		return restTemplate.exchange(get_BooksById_URL, HttpMethod.GET, entity, String.class).getBody();
	}

	@PutMapping("/updateBook")
	public ResponseEntity updateBook(@RequestBody @Valid Books book) {
		bookService.updateBook(book);
		ResponseEntity entity = new ResponseEntity();
		Status status = new Status();
		status.setStatusCode(201);
		status.setStatusMessage("Book Updated Sucessfully!!!");
		entity.setStatus(status);
		entity.setBooks(book);
		return entity;
	}

	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
		ResponseEntity entity = new ResponseEntity();
		Status status = new Status();
		status.setStatusCode(201);
		status.setStatusMessage("Book Deleted Sucessfully!!!");
		entity.setStatus(status);
		return entity;
	}

	@GetMapping("/getBookByName/{bookName}")
	public List<Books> findByBookName(@PathVariable("bookName") String bookName) {
		return bookService.findByBookName(bookName);

	}

	@GetMapping("/getBookByAuthor/{author}")
	public List<Books> findByAuthor(@PathVariable("author") String author) {
		return bookService.findByAuthor(author);
	}

	@GetMapping("/getByPublication/{publication}")
	public List<Books> findByPublication(@PathVariable("publication") String publication) {
		return bookService.findByPublication(publication);
	}

	@GetMapping("getBookByCategory/{category}")
	public List<Books> findByCategory(@PathVariable("category") String category) {
		return bookService.findByCategory(category);
	}

}
