package com.gerenciamentoestoque.chegaRapidex.repositories;

import com.gerenciamentoestoque.chegaRapidex.entities.ProductsRequests;
import com.gerenciamentoestoque.chegaRapidex.entities.ProductsRequestsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRequestsRepository extends JpaRepository<ProductsRequests, ProductsRequestsId> {}

