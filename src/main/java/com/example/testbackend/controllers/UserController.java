package com.example.testbackend.controllers;


import com.example.testbackend.domain.UserRequest;
import com.example.testbackend.entity.User;
import com.example.testbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Creacion de usuarios
	 *
	 * @param user usuario
	 * @throws Exception en caso de error
	 * @return User
	 */

	@PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
	public User createUser(@RequestBody UserRequest user)  {

			return  userService.save(new User.Builder()
					.email(user.getEmail())
					.phone(user.getPhone())
					.userName(user.getUserName())
					.name(user.getName())
					.build());
	}

	/**
	 * Busqueda de todos usuarios
	 *
	 * @throws Exception en caso de error
	 * @return User retorna una lista de usuarios
	 */
	@GetMapping(value = "/all", produces = "application/json;charset=UTF-8")
	public List<User> getUsers() {
		return userService.findAll();
	}

	/**
	 * Elimina un usuario por id
	 * @param id identificador de Usuario
	 * @throws Exception en caso de error
	 */
	@DeleteMapping(value = "/delete/{id}", produces = "application/json;charset=UTF-8")
	public void delete(@PathVariable Long id) {
		  userService.delete(id);
	}

	/**
	 * Busca usuarios en base a su email
	 * @param email identificador de Usuario
	 * @return User retorna un usuario
	 * @throws Exception en caso de error
	 */
	@GetMapping(value = "find-by-email", produces = "application/json;charset=UTF-8")
	public List<User> findByEmail(@RequestParam String email){
		return userService.findByEmail(email);
	}
}
