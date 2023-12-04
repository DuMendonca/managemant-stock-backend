package com.gerenciamentoestoque.chegaRapidex.service;

import com.gerenciamentoestoque.chegaRapidex.entities.Order;
import com.gerenciamentoestoque.chegaRapidex.repositories.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
	@Autowired
	private OrderRepository repository;

	public ResponseEntity<Order> findOrderById(Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Object> findAllOrders() {
		List<Order> orders = repository.findAll();
		if (orders.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(orders);
	}

	public ResponseEntity<Object> deleteOrderById(Long id) {
		return repository.findById(id)
			.map(response -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Order> updateOrder(Long id, Order order) {
		return repository.findById(id)
			.map(response -> {
				response.setOrderDate(order.getOrderDate());
				response.setOrderTotalValue(order.getOrderTotalValue());
				response.setOrderTotalWeight(order.getOrderTotalWeight());
				Order orderUpdated = repository.save(response);
				return ResponseEntity.ok().body(orderUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}

	public Order createOrder(Order order) {
		return repository.save(order);
	}

	public ResponseEntity<Order> deleteAllOrders() {
		List<Order> orders = repository.findAll();
		if (orders.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
