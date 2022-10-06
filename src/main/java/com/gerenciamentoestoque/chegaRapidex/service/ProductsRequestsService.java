package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.ProductsRequests;
import com.gerenciamentoestoque.chegaRapidex.entities.ProductsRequestsId;
import com.gerenciamentoestoque.chegaRapidex.repositories.ProductsRequestsRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductsRequestsService
{
	@Autowired
	private ProductsRequestsRepository repository;

	public ResponseEntity<ProductsRequests> findProductsRequestsById (ProductsRequestsId id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Object> findAllProductsRequestss() {
		List<ProductsRequests> productsRequests = repository.findAll();
		if (productsRequests.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(productsRequests);
	}

	public ResponseEntity<Object> deleteProductsRequestsById(ProductsRequestsId id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<ProductsRequests> updateProductsRequests(ProductsRequestsId id, ProductsRequests productsRequests) {
		return repository.findById(id)
			.map(response -> {
				response.setProductId(productsRequests.getProductId());
				response.setRequestId(productsRequests.getRequestId());
				response.setQuantityProduct(productsRequests.getQuantityProduct());
				ProductsRequests productsRequestsUpdated = repository.save(response);
				return ResponseEntity.ok().body(productsRequestsUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public ProductsRequests createProductsRequests(ProductsRequests productsRequests) {
		return repository.save(productsRequests);
	}

	public ResponseEntity<ProductsRequests> deleteAllProductsRequests() {
		List<ProductsRequests> productsRequests = repository.findAll();
		if (productsRequests.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
