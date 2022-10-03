package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Sender;
import com.gerenciamentoestoque.chegaRapidex.repositories.SenderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SenderService
{
	@Autowired
	private SenderRepository repository;

	public ResponseEntity<Sender> findSenderById(Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Object> findAllSenders() {
		List<Sender> senders = repository.findAll();
		if (senders.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(senders);
	}

	public ResponseEntity<Object> deleteSenderById(Long id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Sender> updateSender(Long id, Sender sender) {
		return repository.findById(id)
			.map(response -> {
				response.setSenderName(sender.getSenderName());
				response.setCpf(sender.getCpf());
				response.setRg(sender.getRg());
				response.setSenderBirthDate(sender.getSenderBirthDate());
				response.setAddress(sender.getAddress());
				Sender senderUpdated = repository.save(response);
				return ResponseEntity.ok().body(senderUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public Sender createSender(Sender sender) {
		return repository.save(sender);
	}

	public ResponseEntity<Sender> deleteAllSenders() {
		List<Sender> senders = repository.findAll();
		if (senders.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
