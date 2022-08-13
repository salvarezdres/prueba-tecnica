package com.example.testbackend.domain;

public class ApiMockarooResponse {
	private String responseCode;
	private String description;
	private ApiMockarooResult apiMockarooResult;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ApiMockarooResult getResult() {
		return apiMockarooResult;
	}

	public void setResult(ApiMockarooResult apiMockarooResult) {
		this.apiMockarooResult = apiMockarooResult;
	}

	public ApiMockarooResponse() {
	//
	}
}
