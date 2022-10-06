package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.ProductsRequests;
import com.gerenciamentoestoque.chegaRapidex.entities.ProductsRequestsId;
import com.gerenciamentoestoque.chegaRapidex.service.ProductsRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/productsRequests")
public class ProductsRequestsController
{
	@Autowired
	private ProductsRequestsService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<ProductsRequests> findProductsRequestsById(@PathVariable ProductsRequestsId id){
		return service.findProductsRequestsById(id);
	}

	@GetMapping
	public ResponseEntity<Object> findAllProductsRequests() {
		return service.findAllProductsRequestss();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteProductsRequestsById(@PathVariable ProductsRequestsId id) {
		service.deleteProductsRequestsById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<ProductsRequests> updateProductsRequests(@PathVariable ProductsRequestsId id, @RequestBody ProductsRequests productsRequests) {
		return service.updateProductsRequests(id, productsRequests);
	}

	@PostMapping
	public ProductsRequests createProductsRequests(@RequestBody ProductsRequests productsRequests) {
		return service.createProductsRequests(productsRequests);
	}

	@DeleteMapping
	public ResponseEntity<ProductsRequests> deleteAllProductsRequests() {
		return service.deleteAllProductsRequests();
	}
}
