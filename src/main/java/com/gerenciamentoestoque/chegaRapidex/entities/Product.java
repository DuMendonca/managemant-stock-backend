package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Produtos")
public class Product
{
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_prod")
	private Long productId;

	@Column(name = "nome_prod")
	private String productName;

	@Column(name = "peso_prod")
	private Integer productWeight;

	@Column(name = "valor_prod")
	private Long productValue;

	@OneToMany(mappedBy = "product")
	@JoinColumn(name = "cod_prod", nullable = false)
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

	public Long getProductValue()
	{
		return productValue;
	}

	public void setProductValue(Long productValue)
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
