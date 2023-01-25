package com.countryservice.enums;

public enum CountryError {

	COUNTRY_NOT_FOUND("001", "Country not found"),
	ERROR_OCCURED_WHILE_INVOKING_COUNTRY_SERVICES("002", "Error occurred while invoking the service."),
	DATA_NOT_FOUND("003", "Data not found.");
	
	private String statusCode;
	private String statusMessage;

	private CountryError(String statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
