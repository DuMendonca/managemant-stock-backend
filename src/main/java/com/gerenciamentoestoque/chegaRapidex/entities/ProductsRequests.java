package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Table(name = "Pedidos_Produtos")
@IdClass(ProductsRequestsId.class)
public class ProductsRequests implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	@ManyToOne
	@JoinColumn(name = "cod_prod", referencedColumnName = "cod_prod")
	@JsonBackReference(value = "productInRequest")
	private Product productId;

	@Id
	@ManyToOne
	@JoinColumn(name = "cod_pedido", referencedColumnName = "cod_pedido")
	@JsonBackReference(value = "requestHasProduct")
	private Request requestId;

	@Column(name = "qtd_prod")
	private Integer quantityProduct;

	// getters and setters
	public Product getProductId()
	{
		return productId;
	}

	public void setProductId(Product productId)
	{
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

	public Integer getQuantityProduct()
	{
		return quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct)
	{
		this.quantityProduct = quantityProduct;
	}
}
