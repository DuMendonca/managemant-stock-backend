package com.gerenciamentoestoque.chegaRapidex.repositories;

import com.gerenciamentoestoque.chegaRapidex.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {}