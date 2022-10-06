package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Produtos")
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	@GeneratedValue
	@Column(name = "cod_prod")
	private Long productId;

	@Column(name = "nm_prod")
	private String productName;

	@Column(name = "peso_prod")
	private Integer productWeight;

	@Column(name = "valor_prod")
	private Float productValue;

	@OneToMany(mappedBy = "productId")
	@JsonManagedReference(value = "productInRequest")
	private List<ProductsRequests> productsInRequestsList;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "productsList")
	private List<Request> requestsList = new ArrayList<>();

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

	public List<ProductsRequests> getProductsInRequestsList()
	{
		return productsInRequestsList;
	}

	public void setProductsInRequestsList(List<ProductsRequests> productsInRequestsList)
	{
		this.productsInRequestsList = productsInRequestsList;
	}
}
