package com.gerenciamentoestoque.chegaRapidex.repositories;

import com.gerenciamentoestoque.chegaRapidex.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
