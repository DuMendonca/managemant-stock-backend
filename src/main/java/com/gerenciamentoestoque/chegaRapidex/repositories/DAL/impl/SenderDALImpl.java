package com.gerenciamentoestoque.chegaRapidex.repositories.DAL.impl;

import com.gerenciamentoestoque.chegaRapidex.entities.Sender;
import com.gerenciamentoestoque.chegaRapidex.repositories.DAL.SenderDAL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SenderDALImpl implements SenderDAL
{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Sender> findAllSender()
	{
		return mongoTemplate.findAll(Sender.class);
	}

	@Override
	public Sender findSenderById(Long senderId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("senderId").in(senderId));
		return mongoTemplate.findOne(query, Sender.class);
	}
}
