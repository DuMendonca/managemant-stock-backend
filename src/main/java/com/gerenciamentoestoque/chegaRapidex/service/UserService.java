package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.User;
import com.gerenciamentoestoque.chegaRapidex.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	private UserRepository repository;

	public ResponseEntity<User> findUserById(Long id)
	{
		return repository.findById(id).map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Object> findAllUsers()
	{
		List<User> userList = repository.findAll();
		if (userList.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(userList);
	}

	public ResponseEntity<Object> deleteUserById(Long id)
	{
		return repository.findById(id).map(response -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<User> updateUser(Long id, User user)
	{
		return repository.findById(id).map(response -> {
			response.setFullname(user.getFullname());
			response.setUsername(user.getUsername());
			response.setPassword(user.getPassword());
			User userUpdated = repository.save(response);
			return ResponseEntity.ok().body(userUpdated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public User createUser(User user)
	{
		return repository.save(user);
	}

	public ResponseEntity<User> deleteAllUsers()
	{
		List<User> userList = repository.findAll();
		if (userList.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}

//	public boolean validateLogin(String username, String password)
//	{
//		User user = repository.findUserByUsername(username);
//		return password.equals(user.getPassword());
//	}
}
