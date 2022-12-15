package com.gerenciamentoestoque.chegaRapidex.repositories.DAL;

import com.gerenciamentoestoque.chegaRapidex.entities.Sender;
import java.util.List;

public interface SenderDAL
{
	List<Sender> findAllSender();

	Sender findSenderById(Long senderId);
}
