package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Pedidos_Produtos")
public class ProductsInRequests implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	@ManyToOne
	@JoinColumn(name = "cod_prod", referencedColumnName = "cod_prod")
	@JsonBackReference(value = "productInRequest")
	private Product product;

	@Id
	@ManyToOne
	@JoinColumn(name = "cod_pedido", referencedColumnName = "cod_pedido")
	@JsonBackReference(value = "requestHasProduct")
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
}
