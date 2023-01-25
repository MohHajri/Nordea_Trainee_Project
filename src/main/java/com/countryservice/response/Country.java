package com.countryservice.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

	private List<CountryDetailResponse> countries;

	public List<CountryDetailResponse> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryDetailResponse> countries) {
		this.countries = countries;
	}
}
