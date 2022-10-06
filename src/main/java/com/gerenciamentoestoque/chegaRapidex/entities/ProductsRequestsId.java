package com.gerenciamentoestoque.chegaRapidex.entities;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProductsRequestsId implements Serializable
{
	private Request requestId;
	private Product productId;

	public ProductsRequestsId()
	{
	}

	public ProductsRequestsId(Request requestId, Product productId)
	{
		this.requestId = requestId;
		this.productId = productId;
	}

	public Request getRequestId()
	{
		return requestId;
	}

	public void setRequestId(Request requestId)
	{
		this.requestId = requestId;
	}

	public Product getProductId()
	{
		return productId;
	}

	public void setProductId(Product productId)
	{
		this.productId = productId;
	}
}
