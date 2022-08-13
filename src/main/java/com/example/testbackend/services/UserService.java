package com.example.testbackend.services;

import com.example.testbackend.entity.User;
import com.example.testbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	/**
	 * save Service
	 *
	 * almacena un nuevo usuario
	 * @param user
	 * @return User
	 */
	public User save(User user){
		return userRepository.save(user);
	}
	/**
	 * findAll Service
	 *
	 * otiene a todos los usuarios en la base de datos
	 * @return User
	 */
	public List<User> findAll(){
		return userRepository.findAll();
	}
	/**
	 * delete Service
	 *
	 * elimina un usuario de la base de datos mediante su id
	 * @param id
	 */
	public void delete(Long id){
		Optional<User> optionalUser = userRepository.findById(id);
		optionalUser.ifPresent(value -> userRepository.deleteById(value.getId()));
	}
	/**
	 * findByEmail Service
	 *
	 * busca a todos los usuarios que contengan el email
	 * ingresado
	 * @param email
	 * @return User
	 */
	public List<User> findByEmail(String email){
		Optional<List<User>> optionalUser = userRepository.findByEmail(email);
		return optionalUser.orElse(Collections.emptyList());
	}

}
