package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Pedidos")
public class Request
{
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pedido")
	private Long requestId;

	@Column(name = "peso_total")
	private Integer requestTotalWeight;

	@Column(name = "dt_pedido")
	private Date requestDate;

	@Column(name = "valor_pedido")
	private Long requestTotalValue;

	@ManyToOne
	private Recipient recipient;

	@ManyToOne
	private Sender sender;

	@ManyToOne
	private RequestStatus requestStatus;

	@OneToMany(mappedBy = "request")
	@JoinColumn(name = "cod_pedido", nullable = false)
	private List<ProductsInRequests> productsInRequestsList;

	// getters and  setters
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

	public Recipient getRecipient()
	{
		return recipient;
	}

	public void setRecipient(Recipient recipient)
	{
		this.recipient = recipient;
	}

	public Sender getSender()
	{
		return sender;
	}

	public void setSender(Sender sender)
	{
		this.sender = sender;
	}

	public RequestStatus getRequestStatus()
	{
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus)
	{
		this.requestStatus = requestStatus;
	}

	public List<ProductsInRequests> getProductsInRequestsList()
	{
		return productsInRequestsList;
	}

	public void setProductsInRequestsList(List<ProductsInRequests> productsInRequestsList)
	{
		this.productsInRequestsList = productsInRequestsList;
	}
}
