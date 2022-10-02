package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import javax.persistence.*;

@Entity(name = "Pedidos")
public class Request
{
	@Column(name = "cod_pedido")
	private Long requestId;

	@Column(name = "peso_total")
	private Integer requestTotalWeight;

	@Column(name = "dt_pedido")
	private Date requestDate;

	@Column(name = "valor_pedido")
	private Long requestTotalValue;

	@Id
	@GeneratedValue
	public Long getRequestId()
	{
		return requestId;
	}

	public void setRequestId(Long requestId)
	{
		this.requestId = requestId;
	}

	public Integer getRequestTotalWeight()
	{
		return requestTotalWeight;
	}

	public void setRequestTotalWeight(Integer requestTotalWeight)
	{
		this.requestTotalWeight = requestTotalWeight;
	}

	public Date getRequestDate()
	{
		return requestDate;
	}

	public void setRequestDate(Date requestDate)
	{
		this.requestDate = requestDate;
	}

	public Long getRequestTotalValue()
	{
		return requestTotalValue;
	}

	public void setRequestTotalValue(Long requestTotalValue)
	{
		this.requestTotalValue = requestTotalValue;
	}
}
