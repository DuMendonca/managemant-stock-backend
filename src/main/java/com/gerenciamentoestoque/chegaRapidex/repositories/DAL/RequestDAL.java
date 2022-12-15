package com.gerenciamentoestoque.chegaRapidex.repositories.DAL;

import com.gerenciamentoestoque.chegaRapidex.entities.Request;
import java.util.List;

public interface RequestDAL
{
	List<Request> findAllRequest();

	Request findRequestById(Long requestId);

	void updateRequestById(Request request, Long requestId);

	void deleteRequestById(Long requestId);
}