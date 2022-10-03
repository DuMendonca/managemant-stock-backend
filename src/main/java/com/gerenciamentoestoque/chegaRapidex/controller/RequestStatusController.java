package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.RequestStatus;
import com.gerenciamentoestoque.chegaRapidex.service.RequestStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requestStatus")
public class RequestStatusController
{
	@Autowired
	private RequestStatusService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<RequestStatus> findRequestStatusById(@PathVariable Long id){
		return service.findRequestStatusById(id);
	}

	@GetMapping
	public ResponseEntity<List<RequestStatus>> findAllRequestStatus() {
		return service.findAllRequestStatus();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteRequestStatusById(@PathVariable Long id) {
		service.deleteRequestStatusById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<RequestStatus> updateRequestStatus(@PathVariable Long id, @RequestBody RequestStatus requestStatus) {
		return service.updateRequestStatus(id, requestStatus);
	}

	@PostMapping
	public RequestStatus createRequestStatus(@RequestBody RequestStatus requestStatus) {
		return service.createRequestStatus(requestStatus);
	}

	@DeleteMapping
	public ResponseEntity<RequestStatus> deleteAllRequestStatus() {
		return service.deleteAllRequestStatus();
	}

}
