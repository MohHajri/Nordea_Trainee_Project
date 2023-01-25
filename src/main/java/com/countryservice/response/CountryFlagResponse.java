package com.countryservice.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryFlagResponse {

	private boolean error;
	private String msg;
	private CountryFlagDataResponse data;
	
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
	public CountryFlagDataResponse getData() {
		return data;
	}
	public void setData(CountryFlagDataResponse data) {
		this.data = data;
	}
}
