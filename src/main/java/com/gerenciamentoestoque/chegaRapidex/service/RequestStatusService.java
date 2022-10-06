package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.RequestStatus;
import com.gerenciamentoestoque.chegaRapidex.repositories.RequestStatusRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RequestStatusService
{
	@Autowired
	private RequestStatusRepository repository;

	public ResponseEntity<RequestStatus> findRequestStatusById(Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<List<RequestStatus>> findAllRequestStatus() {
		List<RequestStatus> requestStatuses = repository.findAll();
		if (requestStatuses.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(requestStatuses);
	}

	public ResponseEntity<Object> deleteRequestStatusById(Long id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<RequestStatus> updateRequestStatus(Long id, RequestStatus requestStatus) {
		return repository.findById(id)
			.map(response -> {
				response.setDescriptionStatus(requestStatus.getDescriptionStatus());
				RequestStatus requestStatusUpdated = repository.saveAndFlush(response);
				return ResponseEntity.ok().body(requestStatusUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public RequestStatus createRequestStatus(RequestStatus requestStatus) {
		return repository.saveAndFlush(requestStatus);
	}

	public ResponseEntity<RequestStatus> deleteAllRequestStatus() {
		List<RequestStatus> requestStatuses = repository.findAll();
		if (requestStatuses.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
