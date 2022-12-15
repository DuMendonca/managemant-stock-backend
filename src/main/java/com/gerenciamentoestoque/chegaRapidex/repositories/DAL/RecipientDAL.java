package com.gerenciamentoestoque.chegaRapidex.repositories.DAL;

import com.gerenciamentoestoque.chegaRapidex.entities.Recipient;
import java.util.List;

public interface RecipientDAL
{
	List<Recipient> findAllRecipient();

	Recipient findRecipientById(Long recipientId);
}
