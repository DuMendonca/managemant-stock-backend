package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Recipient;
import com.gerenciamentoestoque.chegaRapidex.repositories.RecipientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RecipientService
{
	@Autowired
	private RecipientRepository repository;

	public ResponseEntity<Recipient> findRecipientById(@PathVariable Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public List<Recipient> findAllRecipients() {
		return repository.findAll();
	}

	public void deleteRecipientById(@PathVariable Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			ResponseEntity.ok().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Recipient> updateRecipient(@PathVariable Long id, Recipient recipient) {
		repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Recipient> createRecipient(Recipient recipient) {
		repository.saveAndFlush(recipient);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Recipient> deleteAllRecipients() {
		if (!repository.findAll().isEmpty())
		{
			repository.deleteAll();
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.noContent().build();
	}
}
