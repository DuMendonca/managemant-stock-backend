package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Sender;
import com.gerenciamentoestoque.chegaRapidex.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sender")
public class SenderController
{
	@Autowired
	private SenderService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Sender> findSenderById(@PathVariable Long id){
		return service.findSenderById(id);
	}

	@GetMapping
	public ResponseEntity<Object> findAllSenders() {
		return service.findAllSenders();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteSenderById(@PathVariable Long id) {
		service.deleteSenderById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Sender> updateSender(@PathVariable Long id, @RequestBody Sender sender) {
		return service.updateSender(id, sender);
	}

	@PostMapping
	public Sender createSender(@RequestBody Sender sender) {
		return service.createSender(sender);
	}

	@DeleteMapping
	public ResponseEntity<Sender> deleteAllSenders() {
		return service.deleteAllSenders();
	}
}
