package com.airport.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 404 exceptions
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No result")
public class NotFoundException extends RuntimeException{
}