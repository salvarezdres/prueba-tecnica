package com.example.testbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String userName;

	public User() {
		//Constructor
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(Long id, String name, String email, String phone, String userName) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
	}

	public static final class Builder {
		private Long id;
		private String name;
		private String email;
		private String phone;
		private String userName;

		public Builder() {
		}

		public static Builder anUser() {
			return new Builder();
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public User build() {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setUserName(userName);
			return user;
		}


	}
}
