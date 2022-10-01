package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Request;
import com.gerenciamentoestoque.chegaRapidex.repositories.RequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RequestService
{
	@Autowired
	private RequestRepository repository;

	public ResponseEntity<Request> findRequestById(@PathVariable Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public List<Request> findAllRequests() {
		return repository.findAll();
	}

	public void deleteRequestById(@PathVariable Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			ResponseEntity.ok().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Request> updateRequest(@PathVariable Long id, Request request) {
		repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Request> createRequest(Request request) {
		repository.saveAndFlush(request);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Request> deleteAllRequests() {
		if (!repository.findAll().isEmpty())
		{
			repository.deleteAll();
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.noContent().build();
	}
}
