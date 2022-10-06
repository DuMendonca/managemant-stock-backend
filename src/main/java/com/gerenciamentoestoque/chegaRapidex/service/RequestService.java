package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Request;
import com.gerenciamentoestoque.chegaRapidex.repositories.RequestRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RequestService
{
	@Autowired
	private RequestRepository repository;

	public ResponseEntity<Request> findRequestById(Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Object> findAllRequests() {
		List<Request> requests = repository.findAll();
		if (requests.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(requests);
	}

	public ResponseEntity<Object> deleteRequestById(Long id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Request> updateRequest(Long id, Request request) {
		return repository.findById(id)
			.map(response -> {
				response.setRequestDate(request.getRequestDate());
				response.setRequestTotalValue(request.getRequestTotalValue());
				response.setRequestTotalWeight(request.getRequestTotalWeight());
				Request requestUpdated = repository.save(response);
				return ResponseEntity.ok().body(requestUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public Request createRequest(Request request) {
		return repository.save(request);
	}

	public ResponseEntity<Request> deleteAllRequests() {
		List<Request> requests = repository.findAll();
		if (requests.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
