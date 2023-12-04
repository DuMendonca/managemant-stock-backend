package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Order;
import com.gerenciamentoestoque.chegaRapidex.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	private OrderService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Order> findOrderById(@PathVariable Long id){
		return service.findOrderById(id);
	}

	@GetMapping
	public ResponseEntity<Object> findAllOrders() {
		return service.findAllOrders();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteOrderById(@PathVariable Long id) {
		service.deleteOrderById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
		return service.updateOrder(id, order);
	}

	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return service.createOrder(order);
	}

	@DeleteMapping
	public ResponseEntity<Order> deleteAllOrders() {
		return service.deleteAllOrders();
	}
}
