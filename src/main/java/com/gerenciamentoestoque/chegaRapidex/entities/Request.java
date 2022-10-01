package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Request
{
	@Column(name = "cod_pedido")
	private Long codPedido;

	@Column(name = "peso_total")
	private Integer pesoTotalPedido;

	@Column(name = "dt_pedido")
	private Date dataPedido;

	@Column(name = "valor_pedido")
	private Long valorTotalPedido;

	public Request()
	{

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
