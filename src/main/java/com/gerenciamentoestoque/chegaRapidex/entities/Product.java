package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.*;

@Entity(name = "Produtos")
public class Product
{
	@Column(name = "cod_prod")
	private Long productId;

	@Column(name = "nome_prod")
	private String productName;

	@Column(name = "peso_prod")
	private Integer productWeight;

	@Column(name = "valor_prod")
	private Long productValue;

	@Id
	@GeneratedValue
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
}
