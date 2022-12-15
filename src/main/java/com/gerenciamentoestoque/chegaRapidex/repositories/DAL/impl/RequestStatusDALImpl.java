package com.gerenciamentoestoque.chegaRapidex.repositories.DAL.impl;

import com.gerenciamentoestoque.chegaRapidex.entities.RequestStatus;
import com.gerenciamentoestoque.chegaRapidex.repositories.DAL.RequestStatusDAL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RequestStatusDALImpl implements RequestStatusDAL
{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<RequestStatus> findAllRequestStatus()
	{
		return mongoTemplate.findAll(RequestStatus.class);
	}

	@Override
	public RequestStatus findRequestStatusById(Long requestStatusId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("requestStatusId").in(requestStatusId));
		return mongoTemplate.findOne(query, RequestStatus.class);
	}
}
