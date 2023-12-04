package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.OrderStatus;
import com.gerenciamentoestoque.chegaRapidex.service.OrderStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController
{
	@Autowired
	private OrderStatusService service;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<OrderStatus> findOrderStatusById(@PathVariable String id){
		return service.findOrderStatusById(id);
	}

	@GetMapping
	public ResponseEntity<List<OrderStatus>> findAllOrderStatus() {
		return service.findAllOrderStatus();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deleteOrderStatusById(@PathVariable String id) {
		service.deleteOrderStatusById(id);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable String id, @RequestBody OrderStatus OrderStatus) {
		return service.updateOrderStatus(id, OrderStatus);
	}

	@PostMapping
	public OrderStatus createOrderStatus(@RequestBody OrderStatus OrderStatus) {
		return service.createOrderStatus(OrderStatus);
	}

	@DeleteMapping
	public ResponseEntity<OrderStatus> deleteAllOrderStatus() {
		return service.deleteAllOrderStatus();
	}

}
