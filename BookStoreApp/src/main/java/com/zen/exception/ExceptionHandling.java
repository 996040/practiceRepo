package com.zen.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.UnexpectedTypeException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zen.dto.Status;

@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> exception(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return errorMap;
	}

	@ExceptionHandler(value = NoSuchElementException.class)
	public ErrorResponse exception(NoSuchElementException exception) {
		ErrorResponse response = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(500);
		status.setStatusMessage("No Book Available for the Given Id");
		response.setStatus(status);
		return response;
	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ErrorResponse error(HttpRequestMethodNotSupportedException error) {
		ErrorResponse response = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(405);
		status.setStatusMessage("Method Not Allowed Invalid Api");
		response.setStatus(status);
		return response;
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ErrorResponse exception(EmptyResultDataAccessException exception) {
		ErrorResponse response = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(500);
		status.setStatusMessage("Already the Id is not Available");
		response.setStatus(status);
		return response;
	}

	@ExceptionHandler(NullPointerException.class)
	public ErrorResponse exception(NullPointerException exception) {
		ErrorResponse response = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(500);
//		status.setStatusMessage("No Book Available In Book Inventory with the Give Id");
		status.setStatusMessage("No Book Available In Book Inventory with the Given Id");
		response.setStatus(status);
		return response;
	}

	@ExceptionHandler(UnexpectedTypeException.class)
	public ErrorResponse exception(UnexpectedTypeException exception) {
		ErrorResponse response = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(500);
		status.setStatusMessage("BookId Must Not Be Null OR Empty");
		response.setStatus(status);
		return response;
	}


}
