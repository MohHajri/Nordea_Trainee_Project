package com.countryservice.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCapitalResponse {

	private boolean error;
	private String msg;
	private CountryCapitalDataResponse data;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public CountryCapitalDataResponse getData() {
		return data;
	}
	public void setData(CountryCapitalDataResponse data) {
		this.data = data;
	}
}
