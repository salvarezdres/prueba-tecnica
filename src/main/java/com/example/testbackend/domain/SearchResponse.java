package com.example.testbackend.domain;

public class SearchResponse {
	private String responseCode;
	private String description;
	private long elapsedTime;

	private SearchResult result;

	public SearchResult getResult() {
		return result;
	}

	public void setResult(SearchResult result) {
		this.result = result;
	}

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

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
}
