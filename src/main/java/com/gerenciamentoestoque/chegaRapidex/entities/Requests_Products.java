package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Pedidos_Produtos")
public class Requests_Products
{
	@Column(name = "cod_pedido")
	private Long productId;

	@Column(name = "cod_pedido")
	private Long requestId;

	@Column(name = "qtd_prod")
	private Integer quantityProduct;

	@Id
	public Long getProductId()
	{
		return productId;
	}

	public void setProductId(Long productId)
	{
		this.productId = productId;
	}

	@Id
	public Long getRequestId()
	{
		return requestId;
	}

	public void setRequestId(Long requestId)
	{
		this.requestId = requestId;
	}

	public Integer getQuantityProduct()
	{
		return quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct)
	{
		this.quantityProduct = quantityProduct;
	}
}
