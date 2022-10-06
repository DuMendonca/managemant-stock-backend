package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import com.gerenciamentoestoque.chegaRapidex.repositories.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService
{
	@Autowired
	private ProductRepository repository;

	public ResponseEntity<Product> findProductById(Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<List<Product>> findAllProducts() {
		List<Product> products = repository.findAll();
		if (products.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(products);
	}

	public ResponseEntity<Object> deleteProductById(Long id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Product> updateProduct(Long id, Product product) {
		return repository.findById(id)
			.map(response -> {
				response.setProductName(product.getProductName());
				response.setProductValue(product.getProductValue());
				response.setProductWeight(product.getProductWeight());
				Product productUpdated = repository.save(response);
				return ResponseEntity.ok().body(productUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public Product createProduct(Product product) {
		return repository.save(product);
	}

	public ResponseEntity<Product> deleteAllProducts() {
		List<Product> products = repository.findAll();
		if (products.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
