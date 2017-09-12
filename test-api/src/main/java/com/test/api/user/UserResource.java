package com.test.api.user;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.status.StatusResource;
import com.test.model.api.response.StatusReponse;
import com.test.model.api.user.User;
import com.test.service.api.user.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserResource {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(StatusResource.class);
	
	@Autowired
	private UserService userService;

	/**
	 * Recebe todos os parâmetros obrigatórios para criar um novo usuário.
	 */
	@PostMapping
	public ResponseEntity<StatusReponse> insertUser(@Valid @RequestBody User user) {
		LOGGER.debug("Post a new user.");
		userService.saveUser(user);
		return ResponseEntity.ok().body(new StatusReponse());
	}

	/**
	 * Lista todos os usuários.
	 */
	@GetMapping
	public ResponseEntity<List<User>> getListOfAllUsers() {
		LOGGER.debug("Request all users.");
		return ResponseEntity.ok().body(userService.findAllUsers());
	}

	/**
	 * Recupera um usuário por id.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		LOGGER.debug("Request a specific user by id.");
		return ResponseEntity.ok().body(userService.findUser(id));
	}
	
	/**
	 * Remove um usuário por id.
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<StatusReponse> deleteUser(@PathVariable("id") long id) {
		LOGGER.debug("Delete a specific user by id.");
		userService.deleteUser(id);
		return ResponseEntity.ok().body(new StatusReponse());
	}
	
	/**
	 * Edita um usuário por id com todos os campos obrigatórios e que devem ser editados.
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<StatusReponse> updateUser(@PathVariable("id") long id, @Valid @RequestBody User user) {
		LOGGER.debug("Update a specific user.");
		userService.updateUser(id, user);
		return ResponseEntity.ok().body(new StatusReponse());
	}
	
}
