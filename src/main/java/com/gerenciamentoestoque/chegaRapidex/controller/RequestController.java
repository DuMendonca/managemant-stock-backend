package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Request;
import com.gerenciamentoestoque.chegaRapidex.service.RequestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class RequestController
{
	@Autowired
	private RequestService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Request> findRequestById(@PathVariable Long id){
		return service.findRequestById(id);
	}

	@GetMapping
	public List<Request> findAllRequests() {
		return service.findAllRequests();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteRequestById(@PathVariable Long id) {
		service.deleteRequestById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Request> updateRequest(@PathVariable Long id, Request request) {
		return service.updateRequest(id, request);
	}

	@PostMapping
	public ResponseEntity<Request> createRequest(Request request) {
		return service.createRequest(request);
	}

	@DeleteMapping
	public ResponseEntity<Request> deleteAllRequests() {
		return service.deleteAllRequests();
	}
}
