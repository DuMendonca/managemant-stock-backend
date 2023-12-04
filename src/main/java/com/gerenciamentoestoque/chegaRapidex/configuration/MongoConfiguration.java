package com.gerenciamentoestoque.chegaRapidex.configuration;

import com.gerenciamentoestoque.chegaRapidex.repositories.*;
import com.gerenciamentoestoque.chegaRapidex.repositories.impl.UserRepositoryCustomImpl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class MongoConfiguration
{
	@Bean
	MongoClient mongoClient()
	{
		return MongoClients.create("mongodb://root:root@localhost:27017");
	}

	@Bean
	MongoOperations mongoTemplate(MongoClient mongoClient)
	{
		return new MongoTemplate(mongoClient, "management-stock");
	}
}
