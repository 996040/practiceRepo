package com.zensar.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zensar.entities.BaseResponse;
import com.zensar.entities.Details;
import com.zensar.status.Status;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// For Posting the Data Get the Validation
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> exception(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return errorMap;
	}

	// For get the value if no data available
	@ExceptionHandler(value = NoSuchElementException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse exception(NoSuchElementException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(500);
		status.setStatusMessage("The UserId Doesn't Exists");
		errorResponse.setStatus(status);
		return errorResponse;

	}

	// for delete data
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse exception(EmptyResultDataAccessException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(500);
		status.setStatusMessage("Details Does not Exists");
		errorResponse.setStatus(status);
		return errorResponse;

	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ErrorResponse supportException(HttpRequestMethodNotSupportedException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(405);
		status.setStatusMessage("Method Not Allowed Invalid Api");
		errorResponse.setStatus(status);
		return errorResponse;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorResponse NotReadbleException(HttpMessageNotReadableException excep) {
		ErrorResponse errorResponse = new ErrorResponse();
		Status status = new Status();
		status.setStatusCode(400);
		status.setStatusMessage("Message Not Readable Rewrite In proper Manner");
		errorResponse.setStatus(status);
		return errorResponse;
	}

//	BaseResponse baseResponse = new BaseResponse();
//	Details details = new Details();
//	Status status = new Status();
//	status.setStatusCode(400);
//	status.setStatusMessage("Bad Request Invalid Data Entered");
//	baseResponse.setStatus(status);

}
