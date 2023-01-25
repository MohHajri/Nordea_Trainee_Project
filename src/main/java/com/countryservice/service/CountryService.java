package com.countryservice.service;

import java.util.List;

import com.countryservice.response.CountryDetailResponse;
import com.countryservice.response.CountryDetailsResponse;

public interface CountryService {

	public List<CountryDetailResponse> getAllCountries();

	public String getCountryFlagByName(String iso2);

	public CountryDetailsResponse findCountryDetailsByName(String countryName);
}
