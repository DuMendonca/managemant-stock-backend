package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Recipient;
import com.gerenciamentoestoque.chegaRapidex.repositories.RecipientRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RecipientService
{
	@Autowired
	private RecipientRepository repository;

	public ResponseEntity<Recipient> findRecipientById(Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Object> findAllRecipients() {
		List<Recipient> recipients = repository.findAll();
		if (recipients.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(recipients);
	}

	public ResponseEntity<Object> deleteRecipientById(Long id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Recipient> updateRecipient(Long id, Recipient recipient) {
		return repository.findById(id)
			.map(response -> {
				response.setRecipientName(recipient.getRecipientName());
				response.setRecipientBirthDate(recipient.getRecipientBirthDate());
				response.setCpf(recipient.getCpf());
				response.setRg(recipient.getRg());
				response.setAddressRecipient(recipient.getAddressRecipient());
				Recipient recipientUpdated = repository.save(response);
				return ResponseEntity.ok().body(recipientUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public Recipient createRecipient(Recipient recipient) {
		return repository.save(recipient);
	}

	public ResponseEntity<Recipient> deleteAllRecipients() {
		List<Recipient> recipients = repository.findAll();
		if (recipients.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
