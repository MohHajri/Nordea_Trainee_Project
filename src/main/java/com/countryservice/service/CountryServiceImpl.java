package com.countryservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.countryservice.enums.CountryError;
import com.countryservice.exeption.CountryException;
import com.countryservice.request.CountryCapitalRequest;
import com.countryservice.request.CountryFlagRequest;
import com.countryservice.response.CountryCapitalDataResponse;
import com.countryservice.response.CountryCapitalResponse;
import com.countryservice.response.CountryDataResponse;
import com.countryservice.response.CountryDetailResponse;
import com.countryservice.response.CountryDetailsResponse;
import com.countryservice.response.CountryFlagDataResponse;
import com.countryservice.response.CountryFlagResponse;
import com.countryservice.response.CountryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private Environment env;

	public static final okhttp3.MediaType JSON = okhttp3.MediaType.parse("application/json; charset=utf-8");
	public static final ObjectMapper map = new ObjectMapper();

	@Override
	public List<CountryDetailResponse> getAllCountries() {

		try {

			String url = env.getProperty("country.get.url");

			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<CountryResponse> responseEntity = null;

			responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, CountryResponse.class);

			CountryResponse countryResponse = responseEntity.getBody();

			if (countryResponse == null) {
				throw new CountryException(CountryError.ERROR_OCCURED_WHILE_INVOKING_COUNTRY_SERVICES);
			}

			List<CountryDataResponse> countries = countryResponse.getData();

			List<CountryDetailResponse> countryDetailResponses = new ArrayList<>();

			if (countries != null && !countries.isEmpty()) {

				for (CountryDataResponse countryDetailResponse : countries) {

					CountryDetailResponse detailResponse = new CountryDetailResponse();
					detailResponse.setCountryCode(countryDetailResponse.getIso2());
					detailResponse.setName(countryDetailResponse.getCountry());

					countryDetailResponses.add(detailResponse);
				}
			}

			return countryDetailResponses;

		} catch (Exception e) {

			e.printStackTrace();
			throw new CountryException(CountryError.ERROR_OCCURED_WHILE_INVOKING_COUNTRY_SERVICES);
		}

	}

	@Override
	public String getCountryFlagByName(String iso2) {

		try {

			String url = env.getProperty("country.get.flag");

			CountryFlagRequest countryFlagRequest = new CountryFlagRequest();
			countryFlagRequest.setIso2(iso2);

			OkHttpClient client = new OkHttpClient();
			String json = map.writeValueAsString(countryFlagRequest);
			RequestBody body = RequestBody.create(JSON, json);

			Request request = new Request.Builder().url(url).post(body).build();

			Response responseEntity = client.newCall(request).execute();

			int httpStatus = responseEntity.code();

			if (httpStatus != HttpStatus.OK.value()) {
				throw new CountryException(CountryError.ERROR_OCCURED_WHILE_INVOKING_COUNTRY_SERVICES);
			}

			CountryFlagResponse countryFlagResponse = map.readValue(responseEntity.body().string(),
					CountryFlagResponse.class);

			CountryFlagDataResponse flag = countryFlagResponse.getData();
			return flag.getFlag();

		} catch (Exception e) {

			e.printStackTrace();
			throw new CountryException(CountryError.ERROR_OCCURED_WHILE_INVOKING_COUNTRY_SERVICES);
		}
	}

	@Override
	public CountryDetailsResponse findCountryDetailsByName(String countryName) {

		try {

			String url = env.getProperty("country.get.capital");

			CountryCapitalRequest countryCapitalRequest = new CountryCapitalRequest();
			countryCapitalRequest.setCountry(countryName);

			OkHttpClient client = new OkHttpClient();
			String json = map.writeValueAsString(countryCapitalRequest);
			RequestBody body = RequestBody.create(JSON, json);

			Request request = new Request.Builder().url(url).post(body).build();

			Response responseEntity = client.newCall(request).execute();

			CountryCapitalResponse countryCapitalResponse = map.readValue(responseEntity.body().string(),
					CountryCapitalResponse.class);

			CountryCapitalDataResponse countryCapitalDataResponse = countryCapitalResponse.getData();

			String name = countryCapitalDataResponse.getName();
			String capital = countryCapitalDataResponse.getCapital();
			String iso2 = countryCapitalDataResponse.getIso2();
			String iso3 = countryCapitalDataResponse.getIso3();

			String flag = getCountryFlagByName(iso2);

			CountryDetailsResponse countryDetailsResponse = new CountryDetailsResponse();
			countryDetailsResponse.setCapital(capital);
			countryDetailsResponse.setCountryCode(iso3);
			countryDetailsResponse.setFlagFileUrl(flag);
			countryDetailsResponse.setName(name);

			return countryDetailsResponse;

		} catch (Exception e) {

			e.printStackTrace();
			throw new CountryException(CountryError.ERROR_OCCURED_WHILE_INVOKING_COUNTRY_SERVICES);
		}
	}
}
