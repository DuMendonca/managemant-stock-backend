package com.gerenciamentoestoque.chegaRapidex.repositories.DAL.impl;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import com.gerenciamentoestoque.chegaRapidex.repositories.DAL.ProductDAL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDALImpl implements ProductDAL
{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Product> findAllProduct()
	{
		return mongoTemplate.findAll(Product.class);
	}

	@Override
	public Product findProductById(Long productId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").in(productId));
		return mongoTemplate.findOne(query, Product.class);
	}

	@Override
	public void updateProductById(Product newProduct, Long productId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").in(productId));

		Update updateQuery = new Update();
		updateQuery.set("productName", newProduct.getProductName());
		updateQuery.set("productWeight", newProduct.getProductWeight());
		updateQuery.set("productValue", newProduct.getProductValue());

		mongoTemplate.updateFirst(query, updateQuery, Product.class);
	}

	@Override
	public void deleteProductById(Long productId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").in(productId));

		mongoTemplate.remove(query, Product.class);
	}
}
