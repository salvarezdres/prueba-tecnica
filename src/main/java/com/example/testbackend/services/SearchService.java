package com.example.testbackend.services;

import com.example.testbackend.domain.ApiMockarooItem;
import com.example.testbackend.domain.ApiMockarooResponse;
import com.example.testbackend.domain.ApiMockarooResult;
import com.example.testbackend.domain.SearchResponse;
import com.example.testbackend.domain.SearchResult;
import com.example.testbackend.settings.GlobalSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class SearchService {
	@Autowired
	private GlobalSettings globalSettings;
	@Autowired
	private RestTemplate restTemplate;
	private static final String HEADER_MOCKAROO_API_KEY = "X-API-Key";
	private static final String ENCRYPT_KEY_DES = "ionix123456";
	/**
	 * getSearchResult Service

	 *
	 * @param rut recibe el rut, luego lo envie a encriptar en DES
	 *  para posteriormente utilizarlo como key en la peticion a apimockaroo
	 *  se cuenta el tiempo de ejecucion del servicio y se amlacena en la variable  durationProcessInMillis
	 *            para posteriormente introducirlo en el SearchResponse junto con la descripcion, codigo de respuesta y
	 *            cantidad de items obtenidos de la api mockaroo
	 * @return SearchResponse
	 */
	public SearchResponse getSearchResult(String rut) {
		SearchResponse searchResponse = new SearchResponse();
		Instant initProcess = Instant.now();
		String rutEncodeDes = encodeDes(rut);
		if (rutEncodeDes.equals("")) return null;
		ApiMockarooResponse apiMockarooResponse = getApiMockarooResponse(rutEncodeDes);
		Instant endProcess = Instant.now();
		long durationProcessInMillis = Duration.between(initProcess, endProcess).toMillis();
		searchResponse.setDescription(apiMockarooResponse.getDescription());
		searchResponse.setResponseCode(apiMockarooResponse.getResponseCode());
		searchResponse.setElapsedTime(durationProcessInMillis);
		SearchResult searchResult = new SearchResult();
		searchResult.setRegisterCount(apiMockarooResponse.getResult().getItems().size());
		searchResponse.setResult(searchResult);
		return searchResponse;
	}
	/**
	 * encodeDes Service
	 *
	 * @param param recibe el rut, lo encripta en DES y luego en BASE64
	 * @return base64ParamEncode retorna el rut encriptado
	 */
	private String encodeDes(String param) {

		byte[] encryptedRut;
		String base64ParamEncode = "";
		try {
			DESKeySpec keySpec = new DESKeySpec(ENCRYPT_KEY_DES.getBytes(StandardCharsets.UTF_8.toString()));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			byte[] cleartext = param.getBytes(StandardCharsets.UTF_8.toString());
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, keyFactory.generateSecret(keySpec));
			encryptedRut = cipher.doFinal(cleartext);
			byte[] encoded = Base64Utils.encode(encryptedRut);
			base64ParamEncode = new String(encoded);

		} catch (Exception e) {
			log.error("Error al intentar encriptar el mensaje");
		}
		return base64ParamEncode;
	}
	/**
	 * getApiMockarooResponse Service

	 *
	 * @param param recibe el rut el rut encriptado
	 *              lo utiliza para obtener la informacion del servicio mockaroo
	 * @return apiMockarooResponse retorna la respuesta del servicio mockaroo
	 */
	private ApiMockarooResponse getApiMockarooResponse(String param) {

		HttpHeaders header = new HttpHeaders();
		header.set(HEADER_MOCKAROO_API_KEY, "f2f719e0");
		HttpEntity<String> request = new HttpEntity<>(header);
		String uriApiMockarooBuilder = globalSettings.getApiExternaIonix().concat(param);
		ResponseEntity<ApiMockarooResponse> responseEntity = null;
		try {
			 responseEntity = restTemplate.exchange(
					uriApiMockarooBuilder,
					HttpMethod.GET,
					request,
					ApiMockarooResponse.class
			);
		}catch (Exception e){
			log.error("Error en la peticion a Mockaroo",e.getMessage());
			ApiMockarooResponse apiMockarooResponse = new ApiMockarooResponse();
			apiMockarooResponse.setResponseCode("204");
			apiMockarooResponse.setDescription("NOK");
			ApiMockarooResult apiMockarooResult = new ApiMockarooResult();
			List<ApiMockarooItem> apiMockarooItem = new ArrayList<>();
			apiMockarooResult.setItems(apiMockarooItem);
			apiMockarooResponse.setResult(apiMockarooResult);
			responseEntity = new ResponseEntity<>(apiMockarooResponse, HttpStatus.NO_CONTENT);
		}

		return responseEntity.getBody();

	}


}
