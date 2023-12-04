package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.OrderStatus;
import com.gerenciamentoestoque.chegaRapidex.repositories.OrderStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService
{
	@Autowired
	private OrderStatusRepository repository;

	public ResponseEntity<OrderStatus> findOrderStatusById(String id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<List<OrderStatus>> findAllOrderStatus() {
		List<OrderStatus> OrderStatuses = repository.findAll();
		if (OrderStatuses.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(OrderStatuses);
	}

	public ResponseEntity<Object> deleteOrderStatusById(String id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<OrderStatus> updateOrderStatus(String id, OrderStatus OrderStatus) {
		return repository.findById(id)
			.map(response -> {
				response.setDescriptionStatus(OrderStatus.getDescriptionStatus());
				OrderStatus OrderStatusUpdated = repository.save(response);
				return ResponseEntity.ok().body(OrderStatusUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public OrderStatus createOrderStatus(OrderStatus OrderStatus) {
		return repository.save(OrderStatus);
	}

	public ResponseEntity<OrderStatus> deleteAllOrderStatus() {
		List<OrderStatus> OrderStatuses = repository.findAll();
		if (OrderStatuses.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
