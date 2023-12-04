package com.gerenciamentoestoque.chegaRapidex.repositories.impl;

import com.gerenciamentoestoque.chegaRapidex.entities.User;
import com.gerenciamentoestoque.chegaRapidex.repositories.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


public class UserRepositoryCustomImpl implements UserRepositoryCustom
{
//	@Autowired
//	private MongoTemplate mongoTemplate;
//
//	@Override
//	public User findUserByUsername(String username)
//	{
//		Query queryUsername = Query.query(Criteria.where("username").gt(username));
//		return mongoTemplate.findOne(queryUsername, User.class);
//	}
}
