package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.User;
import com.gerenciamentoestoque.chegaRapidex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<User> findUserById(@PathVariable Long id){
		return service.findUserById(id);
	}

	@GetMapping
	public ResponseEntity<Object> findAllUsers() {
		return service.findAllUsers();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteUserById(@PathVariable Long id) {
		service.deleteUserById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@DeleteMapping
	public ResponseEntity<User> deleteAllUsers() {
		return service.deleteAllUsers();
	}

//	@GetMapping(path = {"/{username}/{password}"})
//	public boolean validateUserLogin(@PathVariable String username, @PathVariable String password) {
//		return service.validateLogin(username, password);
//	}
}
