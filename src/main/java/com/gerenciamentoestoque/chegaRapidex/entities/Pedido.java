package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Pedido
{
	@Column(name = "cod_pedido")
	private Long codPedido;

	@Column(name = "peso_total")
	private Integer pesoTotalPedido;

	@Column(name = "dt_pedido")
	private Date dataPedido;

	@Column(name = "valor_pedido")
	private Long valorTotalPedido;

	public Pedido()
	{

	}

	@Id
	@GeneratedValue
	public Long getCodPedido()
	{
		return codPedido;
	}

	public void setCodPedido(Long codPedido)
	{
		this.codPedido = codPedido;
	}

	public Integer getPesoTotalPedido()
	{
		return pesoTotalPedido;
	}

	public void setPesoTotalPedido(Integer pesoTotalPedido)
	{
		this.pesoTotalPedido = pesoTotalPedido;
	}

	public Date getDataPedido()
	{
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido)
	{
		this.dataPedido = dataPedido;
	}

	public Long getValorTotalPedido()
	{
		return valorTotalPedido;
	}

	public void setValorTotalPedido(Long valorTotalPedido)
	{
		this.valorTotalPedido = valorTotalPedido;
	}
}
