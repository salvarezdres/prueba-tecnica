package com.example.testbackend.controllers;

import com.example.testbackend.domain.UserRequest;
import com.example.testbackend.entity.User;
import com.example.testbackend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void createUser(){
		UserRequest userRequest = new UserRequest();
		User user = new User();
		when(userService.save(any())).thenReturn(user);
		assertThat(userController.createUser(userRequest)).isEqualTo(user);

	}
	@Test
	public void getUsers(){
		List<User> userList = Collections.emptyList();
		when(userService.findAll()).thenReturn(userList);
		assertThat(userController.getUsers()).isNotNull();
	}
	@Test
	public void findByEmail(){
		List<User> userList = Collections.emptyList();
		when(userService.findByEmail(anyString())).thenReturn(userList);
		assertThat(userController.findByEmail("email")).isNotNull();
	}
	@Test
	public void delete(){
		userController.delete(3L);
		verify(userService).delete(3L);
	}

}
