package com.example.testbackend.services;

import com.example.testbackend.entity.User;
import com.example.testbackend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserService userService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void save() {
		User user = new User();
		when(userRepository.save(user)).thenReturn(user);
		assertThat(userService.save(user)).isNotNull();
	}
	@Test
	void findAll() {
		List<User> users = Collections.emptyList();
		when(userRepository.findAll()).thenReturn(users);
		assertThat(userService.findAll()).isNotNull();
	}
	@Test
	void delete() {
		User user  = new User();
		user.setId(3L);
		Optional<User> optionalUser = Optional.of(user);
		when(userRepository.findById(anyLong())).thenReturn(optionalUser);
		userService.delete(3L);

		verify(userRepository).deleteById(anyLong());
	}

	@Test
	void findByEmail() {
		List<User> users = Collections.emptyList();
		when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(users));
		assertThat(userService.findByEmail("email")).isNotNull();
	}
}
