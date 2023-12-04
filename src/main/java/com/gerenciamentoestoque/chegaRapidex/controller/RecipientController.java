package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Recipient;
import com.gerenciamentoestoque.chegaRapidex.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipient")
public class RecipientController
{
	@Autowired
	private RecipientService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Recipient> findRecipientById(@PathVariable String id){
		return service.findRecipientById(id);
	}

	@GetMapping
	public ResponseEntity<Object> findAllRecipients() {
		return service.findAllRecipients();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteRecipientById(@PathVariable String id) {
		service.deleteRecipientById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Recipient> updateRecipient(@PathVariable String id, @RequestBody Recipient recipient) {
		return service.updateRecipient(id, recipient);
	}

	@PostMapping
	public Recipient createRecipient(@RequestBody Recipient recipient) {
		return service.createRecipient(recipient);
	}

	@DeleteMapping
	public ResponseEntity<Recipient> deleteAllRecipients() {
		return service.deleteAllRecipients();
	}
}
