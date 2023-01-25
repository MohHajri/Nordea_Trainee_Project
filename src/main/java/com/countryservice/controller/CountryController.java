package com.countryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.response.Country;
import com.countryservice.response.CountryDetailResponse;
import com.countryservice.response.CountryDetailsResponse;
import com.countryservice.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	CountryService countryService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Country> getAllCountries() {

		List<CountryDetailResponse> countryResponse = countryService.getAllCountries();

		Country country = new Country();
		country.setCountries(countryResponse);

		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<CountryDetailsResponse> getAllCountrByName(@PathVariable("name") String name) {

		CountryDetailsResponse countryResponse = countryService.findCountryDetailsByName(name);
		return new ResponseEntity<CountryDetailsResponse>(countryResponse, HttpStatus.OK);
	}
}
