package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Sender;
import com.gerenciamentoestoque.chegaRapidex.repositories.SenderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class SenderService
{
	@Autowired
	private SenderRepository repository;

	public ResponseEntity<Sender> findSenderById(@PathVariable Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public List<Sender> findAllSenders() {
		return repository.findAll();
	}

	public void deleteSenderById(@PathVariable Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			ResponseEntity.ok().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Sender> updateSender(@PathVariable Long id, Sender sender) {
		repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Sender> createSender(Sender sender) {
		repository.saveAndFlush(sender);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Sender> deleteAllSenders() {
		if (!repository.findAll().isEmpty())
		{
			repository.deleteAll();
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.noContent().build();
	}
}
