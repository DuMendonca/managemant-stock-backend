package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	private Long productId;

	private String productName;

	private Integer productWeight;

	private Float productValue;

	@OneToMany
	@JoinColumn(name = "requestId")
	@JsonManagedReference(value = "request-product")
	private List<Request> requests;

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

	public List<Request> getRequests()
	{
		return requests;
	}

	public void setRequests(List<Request> requests)
	{
		this.requests = requests;
	}
}
