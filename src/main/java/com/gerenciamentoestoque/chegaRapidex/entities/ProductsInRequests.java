package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.*;

@Entity
@Table(name = "Pedidos_Produtos")
public class ProductsInRequests
{
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedidos_produtos_id")
	private Long productsRequestsId;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Request request;

	@Column(name = "qtd_prod")
	private Integer quantityProduct;

	// getters and setters
	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public Request getRequest()
	{
		return request;
	}

	public void setRequest(Request request)
	{
		this.request = request;
	}

	public Integer getQuantityProduct()
	{
		return quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct)
	{
		this.quantityProduct = quantityProduct;
	}

	public Long getProductsRequestsId()
	{
		return productsRequestsId;
	}

	public void setProductsRequestsId(Long productsRequestsId)
	{
		this.productsRequestsId = productsRequestsId;
	}
}
