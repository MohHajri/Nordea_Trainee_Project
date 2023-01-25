package com.countryservice.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDetailsResponse {

	private String name;
	private String countryCode;
	private String capital;
	private String flagFileUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getFlagFileUrl() {
		return flagFileUrl;
	}

	public void setFlagFileUrl(String flagFileUrl) {
		this.flagFileUrl = flagFileUrl;
	}
}
