package com.example.testbackend.controllers;

import com.example.testbackend.domain.SearchRequest;
import com.example.testbackend.domain.SearchResponse;
import com.example.testbackend.services.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


public class SearchControllerTest {

	@InjectMocks
	private SearchController searchController;
	@Mock
	private SearchService searchService;
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void searchProcess(){
		SearchResponse searchResponse = new SearchResponse();
		SearchRequest searchRequest = new SearchRequest();
		String param = "1-9";
		searchRequest.setParam(param);

		when(searchService.getSearchResult(param)).thenReturn(searchResponse);
		assertThat(searchController.searchProcess(searchRequest)).isNotNull();
	}

}
