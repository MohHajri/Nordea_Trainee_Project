package com.countryservice.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryResponse {

	private boolean error;
	private String msg;
	private List<CountryDataResponse> data;
	
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
	public List<CountryDataResponse> getData() {
		return data;
	}
	public void setData(List<CountryDataResponse> data) {
		this.data = data;
	}
}
