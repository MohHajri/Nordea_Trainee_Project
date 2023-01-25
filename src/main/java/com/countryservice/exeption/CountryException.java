package com.countryservice.exeption;

import com.countryservice.enums.CountryError;

public class CountryException extends RuntimeException{

	private String errorCode;
	private String errorMessage;
	
	public CountryException(CountryError countryError) {
		
		this.errorCode = countryError.getStatusCode();
		this.errorMessage = countryError.getStatusMessage();
	}
	
	public CountryException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
