package com.gerenciamentoestoque.chegaRapidex.repositories.DAL.impl;

import com.gerenciamentoestoque.chegaRapidex.entities.Address;
import com.gerenciamentoestoque.chegaRapidex.repositories.DAL.AddressDAL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDALImpl implements AddressDAL
{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Address> findAllAddress()
	{
		return mongoTemplate.findAll(Address.class);
	}

	@Override
	public Address findAddressById(Long addressId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("addressId").in(addressId));
		return mongoTemplate.findOne(query, Address.class);
	}
}
