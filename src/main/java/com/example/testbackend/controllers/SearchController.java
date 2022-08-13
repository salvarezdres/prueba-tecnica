package com.example.testbackend.controllers;

import com.example.testbackend.domain.SearchRequest;
import com.example.testbackend.domain.SearchResponse;
import com.example.testbackend.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/search")
@RestController
public class SearchController {
	@Autowired
	private SearchService searchService;
	/**
	 * Search Controler
	 *
	 * recibe mediante el protocolo http post
	 * la cadena 1-9 la cual procesa y genera
	 * el formato de respuesta indicado
	 *
	 * @param searchRequest para efectos de esta prueba recibe 1-9
	 * @return SearchResponse
	 */
	@PostMapping(value = "/by-rut", produces = "application/json;charset=UTF-8")
	public SearchResponse searchProcess( @RequestBody SearchRequest searchRequest)  {
		return searchService.getSearchResult(searchRequest.getParam());

	}

}
