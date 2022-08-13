package com.example.testbackend.domain;

import java.util.List;

public class ApiMockarooResult {
	private List<ApiMockarooItem> apiMockarooItems;

	public List<ApiMockarooItem> getItems() {
		return apiMockarooItems;
	}

	public void setItems(List<ApiMockarooItem> apiMockarooItems) {
		this.apiMockarooItems = apiMockarooItems;
	}
}
