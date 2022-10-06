package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
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

	@OneToMany(mappedBy = "product")
	@JsonManagedReference(value = "productInRequest")
	private List<ProductsInRequests> productsInRequestsList;

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

	public List<ProductsInRequests> getProductsInRequestsList()
	{
		return productsInRequestsList;
	}

	public void setProductsInRequestsList(List<ProductsInRequests> productsInRequestsList)
	{
		this.productsInRequestsList = productsInRequestsList;
	}
}
