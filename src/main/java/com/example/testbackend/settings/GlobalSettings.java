package com.example.testbackend.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration

public class GlobalSettings {
	@Value("${api.externa.ionix}")
	public String apiExternaIonix;
	@Value("${api.user}")
	public String apiUser;
	@Value("${api.pass}")
	public String apiPass;

	public String getApiExternaIonix() {
		return apiExternaIonix;
	}

	public void setApiExternaIonix(String apiExternaIonix) {
		this.apiExternaIonix = apiExternaIonix;
	}
}
