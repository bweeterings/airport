package com.airport.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 403 exception
 */
@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Not enough fuel")
public class NotEnoughFuelException extends RuntimeException{
}