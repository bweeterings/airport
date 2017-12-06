package com.airport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 404 exception
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No result")
public class NotFoundException extends RuntimeException{
}