package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Sender;
import com.gerenciamentoestoque.chegaRapidex.service.SenderService;
import java.util.List;
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
	public List<Sender> findAllSenders() {
		return service.findAllSenders();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteSenderById(@PathVariable Long id) {
		service.deleteSenderById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Sender> updateSender(@PathVariable Long id, Sender sender) {
		return service.updateSender(id, sender);
	}

	@PostMapping
	public ResponseEntity<Sender> createSender(Sender sender) {
		return service.createSender(sender);
	}

	@DeleteMapping
	public ResponseEntity<Sender> deleteAllSenders() {
		return service.deleteAllSenders();
	}
}
