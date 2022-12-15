package com.gerenciamentoestoque.chegaRapidex.repositories.DAL.impl;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import com.gerenciamentoestoque.chegaRapidex.entities.Request;
import com.gerenciamentoestoque.chegaRapidex.repositories.DAL.RequestDAL;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDALImpl implements RequestDAL
{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Request> findAllRequest()
	{
		return mongoTemplate.findAll(Request.class);
	}

	@Override
	public Request findRequestById(Long requestId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("requestId").in(requestId));
		return mongoTemplate.findOne(query, Request.class);
	}

	@Override
	public void updateRequestById(Request request, Long requestId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("requestId").in(requestId));

		Update updateQuery = new Update();
		updateQuery.set("requestTotalWeight", request.getRequestTotalValue());
		updateQuery.set("requestDate", request.getRequestDate());
		updateQuery.set("requestTotalValue", request.getRequestTotalValue());
		updateQuery.set("recipient", request.getRecipient());
		updateQuery.set("sender", request.getSender());
		updateQuery.set("requestStatus", request.getRequestStatus());
		updateQuery.set("requestDate", new Date());

		mongoTemplate.updateFirst(query, updateQuery, Request.class);
	}

	@Override
	public void deleteRequestById(Long requestId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("requestId").in(requestId));

		mongoTemplate.remove(query, Request.class);
	}
}
