package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Address;
import com.gerenciamentoestoque.chegaRapidex.repositories.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService
{
	@Autowired
	private AddressRepository repository;

	public ResponseEntity<Address> findAddressById(String id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<List<Address>> findAllAddresses() {
		List<Address> addresses = repository.findAll();
		if (addresses.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(addresses);
	}

	public ResponseEntity<Object> deleteAddressById(String id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Address> updateAddress(String id, Address address) {
		return repository.findById(id)
			.map(response -> {
				response.setCity(address.getCity());
				response.setNumber(address.getNumber());
				response.setRoad(address.getRoad());
				Address addressUpdated = repository.save(response);
				return ResponseEntity.ok().body(addressUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public Address createAddress(Address address) {
		return repository.save(address);
	}

	public ResponseEntity<Address> deleteAllAddresses() {
		List<Address> addresses = repository.findAll();
		if (addresses.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
