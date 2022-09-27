package com.gerenciamentoestoque.chegaRapidex.controller;

import com.gerenciamentoestoque.chegaRapidex.entities.Pedido;
import com.gerenciamentoestoque.chegaRapidex.repositories.PedidoRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController
{
	private PedidoRepository repository;

	public PedidoController(PedidoRepository repository)
	{
		this.repository = repository;
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		return repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<Pedido> findAllPedidos() {
		return repository.findAll();
	}

	@DeleteMapping(path = {"/{id}"})
	public void deletePedidoById(@PathVariable Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			ResponseEntity.ok().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, Pedido pedido) {
		repository.findById(id)
			.map(response -> ResponseEntity.ok().body(response))
			.orElse(ResponseEntity.notFound().build());
		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity<Pedido> createPedido(Pedido pedido) {
		repository.saveAndFlush(pedido);
		return ResponseEntity.ok().build();
	}
}
