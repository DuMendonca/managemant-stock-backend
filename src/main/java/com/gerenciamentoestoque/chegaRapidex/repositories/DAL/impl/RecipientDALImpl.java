package com.gerenciamentoestoque.chegaRapidex.repositories.DAL.impl;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import com.gerenciamentoestoque.chegaRapidex.entities.Recipient;
import com.gerenciamentoestoque.chegaRapidex.repositories.DAL.RecipientDAL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RecipientDALImpl implements RecipientDAL
{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Recipient> findAllRecipient()
	{
		return mongoTemplate.findAll(Recipient.class);
	}

	@Override
	public Recipient findRecipientById(Long recipientId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("recipientId").in(recipientId));
		return mongoTemplate.findOne(query, Recipient.class);
	}
}
