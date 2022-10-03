package com.gerenciamentoestoque.chegaRapidex.repositories;

import com.gerenciamentoestoque.chegaRapidex.entities.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStatusRepository extends JpaRepository<RequestStatus, Long> {}
