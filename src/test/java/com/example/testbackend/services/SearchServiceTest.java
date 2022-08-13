package com.example.testbackend.services;


import com.example.testbackend.domain.ApiMockarooItem;
import com.example.testbackend.domain.ApiMockarooResponse;
import com.example.testbackend.domain.ApiMockarooResult;
import com.example.testbackend.settings.GlobalSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class SearchServiceTest {
	@InjectMocks
	private SearchService searchService;
	@Mock
	private GlobalSettings globalSettings;
	@Mock
	private RestTemplate restTemplate ;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void getSearchResult(){
		String param = "1-9";
		ApiMockarooResponse apiMockarooResponse = new ApiMockarooResponse();
		apiMockarooResponse.setResponseCode("200");
		apiMockarooResponse.setDescription("OK");
		ApiMockarooResult apiMockarooResult = new ApiMockarooResult();
		List<ApiMockarooItem> apiMockarooItem = new ArrayList<>();
		apiMockarooItem.add(new ApiMockarooItem());
		apiMockarooResult.setItems(apiMockarooItem);
		apiMockarooResponse.setResult(apiMockarooResult);
		ResponseEntity<ApiMockarooResponse> response = new ResponseEntity<>(apiMockarooResponse, HttpStatus.OK);
		when(globalSettings.getApiExternaIonix()).thenReturn("https://my.api.mockaroo.com/test-tecnico/");
		when(restTemplate.exchange(
				ArgumentMatchers.anyString(),
				ArgumentMatchers.any(HttpMethod.class),
				ArgumentMatchers.any(),
				ArgumentMatchers.<Class<ApiMockarooResponse>>any()
		)).thenReturn(response);
		assertThat(searchService.getSearchResult(param)).isNotNull();

	}

}
