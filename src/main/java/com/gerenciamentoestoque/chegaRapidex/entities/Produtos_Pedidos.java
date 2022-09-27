package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Produtos_Pedidos
{
	private Long id;

	@Column(name = "cod_pedido")
	private Long codPedido;

	@Column(name = "cod_produto")
	private Long codProduto;

	@Column(name = "qtd_produtos")
	private Integer quantidadeProdutos;

	public Produtos_Pedidos()
	{

	}

	@Id
	@GeneratedValue
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getCodPedido()
	{
		return codPedido;
	}

	public void setCodPedido(Long codPedido)
	{
		this.codPedido = codPedido;
	}

	public Long getCodProduto()
	{
		return codProduto;
	}

	public void setCodProduto(Long codProduto)
	{
		this.codProduto = codProduto;
	}

	public Integer getQuantidadeProdutos()
	{
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Integer quantidadeProdutos)
	{
		this.quantidadeProdutos = quantidadeProdutos;
	}
}
