package com.countryservice.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.exeption.CountryAppError;
import com.countryservice.exeption.CountryException;
import com.countryservice.response.GenericResponse;

@ControllerAdvice
@RestController
public class ExceptionHandller {

	@ExceptionHandler(value = CountryException.class)
	public GenericResponse handleIpayException(CountryException error) {

		StringWriter stack = new StringWriter();
		error.printStackTrace(new PrintWriter(stack));

		CountryAppError countryAppError = new CountryAppError();
		countryAppError.setErrorCode(error.getErrorCode());
		countryAppError.setErrorMessage(error.getErrorMessage());

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setResponseCode("999");
		genericResponse.setResponseObject(countryAppError);

		return genericResponse;

	}
}
