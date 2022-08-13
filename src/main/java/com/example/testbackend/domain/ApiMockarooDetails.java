package com.example.testbackend.domain;

import java.io.Serializable;

public class ApiMockarooDetails implements Serializable {

	private static final long serialVersionUID = 3623327076892278617L;
	private String email;
	private String phoneNumber;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ApiMockarooDetails() {
	}

	public static final class ApiMockarooDetailsBuilder {
		private String email;
		private String phoneNumber;

		public ApiMockarooDetailsBuilder() {
		}

		public static ApiMockarooDetailsBuilder anApiMockarooDetails() {
			return new ApiMockarooDetailsBuilder();
		}

		public ApiMockarooDetailsBuilder email(String email) {
			this.email = email;
			return this;
		}

		public ApiMockarooDetailsBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public ApiMockarooDetails build() {
			ApiMockarooDetails apiMockarooDetails = new ApiMockarooDetails();
			apiMockarooDetails.setEmail(email);
			apiMockarooDetails.setPhoneNumber(phoneNumber);
			return apiMockarooDetails;
		}
	}
}
