package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product")
public class Product
{
	// attributes
	@Id
	private Long productId;

	private String productName;

	private Integer productWeight;

	private Float productValue;

	private List<Order> orders;

	// getters and setters
	public Long getProductId()
	{
		return productId;
	}

	public void setProductId(Long productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public Integer getProductWeight()
	{
		return productWeight;
	}

	public void setProductWeight(Integer productWeight)
	{
		this.productWeight = productWeight;
	}

	public Float getProductValue()
	{
		return productValue;
	}

	public void setProductValue(Float productValue)
	{
		this.productValue = productValue;
	}

	public List<Order> getRequests()
	{
		return orders;
	}

	public void setRequests(List<Order> orders)
	{
		this.orders = orders;
	}
}
