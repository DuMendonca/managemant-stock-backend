package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import com.gerenciamentoestoque.chegaRapidex.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class ProductService
{
	@Autowired
	private ProductRepository repository;

	public ResponseEntity<Product> findProductById(@PathVariable Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public List<Product> findAllProducts() {
		return repository.findAll();
	}

	public void deleteProductById(@PathVariable Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			ResponseEntity.ok().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Product> updateProduct(@PathVariable Long id, Product Product) {
		repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Product> createProduct(Product Product) {
		repository.saveAndFlush(Product);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Product> deleteAllProducts() {
		if (!repository.findAll().isEmpty())
		{
			repository.deleteAll();
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.noContent().build();
	}
}
