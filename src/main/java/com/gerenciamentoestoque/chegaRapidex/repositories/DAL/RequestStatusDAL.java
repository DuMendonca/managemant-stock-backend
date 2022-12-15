package com.gerenciamentoestoque.chegaRapidex.repositories.DAL;

import com.gerenciamentoestoque.chegaRapidex.entities.RequestStatus;
import java.util.List;

public interface RequestStatusDAL
{
	List<RequestStatus> findAllRequestStatus();

	RequestStatus findRequestStatusById(Long requestId);
}
