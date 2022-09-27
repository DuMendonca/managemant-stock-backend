package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Produto
{
	@Column(name = "cod_prod")
	private Long codProduto;

	@Column(name = "nome_prod")
	private String nomeProduto;

	@Column(name = "peso_prod")
	private Integer pesoProduto;

	@Column(name = "valor_prod")
	private Long valorProduto;

	public Produto()
	{

	}

	@Id
	@GeneratedValue
	public Long getCodProduto()
	{
		return codProduto;
	}

	public void setCodProduto(Long codProduto)
	{
		this.codProduto = codProduto;
	}

	public String getNomeProduto()
	{
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto)
	{
		this.nomeProduto = nomeProduto;
	}

	public Integer getPesoProduto()
	{
		return pesoProduto;
	}

	public void setPesoProduto(Integer pesoProduto)
	{
		this.pesoProduto = pesoProduto;
	}

	public Long getValorProduto()
	{
		return valorProduto;
	}

	public void setValorProduto(Long valorProduto)
	{
		this.valorProduto = valorProduto;
	}
}
