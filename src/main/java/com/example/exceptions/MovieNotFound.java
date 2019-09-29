package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFound(String msg) {
		super(msg);
	}
}
