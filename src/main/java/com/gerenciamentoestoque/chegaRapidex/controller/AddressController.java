package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Address;
import com.gerenciamentoestoque.chegaRapidex.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController
{
	@Autowired
	private AddressService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Address> findAddressById(@PathVariable String id){
		return service.findAddressById(id);
	}

	@GetMapping
	public ResponseEntity<List<Address>> findAllAddresses() {
		return service.findAllAddresses();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteAddressById(@PathVariable String id) {
		service.deleteAddressById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Address> updateAddress(@PathVariable String id, @RequestBody Address address) {
		return service.updateAddress(id, address);
	}

	@PostMapping
	public Address createAddress(@RequestBody Address address) {
		return service.createAddress(address);
	}

	@DeleteMapping
	public ResponseEntity<Address> deleteAllAddress() {
		return service.deleteAllAddresses();
	}
}
