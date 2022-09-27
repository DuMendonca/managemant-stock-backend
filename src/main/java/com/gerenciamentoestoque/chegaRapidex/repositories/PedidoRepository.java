package com.gerenciamentoestoque.chegaRapidex.repositories;

import com.gerenciamentoestoque.chegaRapidex.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}

