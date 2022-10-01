package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import com.gerenciamentoestoque.chegaRapidex.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController
{
	@Autowired
	private ProductService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Product> findProductById(@PathVariable Long id){
		return service.findProductById(id);
	}

	@GetMapping
	public List<Product> findAllProducts() {
		return service.findAllProducts();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteProductById(@PathVariable Long id) {
		service.deleteProductById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, Product Product) {
		return service.updateProduct(id, Product);
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(Product Product) {
		return service.createProduct(Product);
	}

	@DeleteMapping
	public ResponseEntity<Product> deleteAllProducts() {
		return service.deleteAllProducts();
	}
}
