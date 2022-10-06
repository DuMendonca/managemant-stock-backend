package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Pedidos")
public class Request implements Serializable
{
	private static final long serialVersionUID = 1L;

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
	private Float requestTotalValue;

	@ManyToOne
	@JoinColumn(name = "cod_destinatario")
	@JsonBackReference(value = "request-recipient")
	private Recipient recipient;

	@ManyToOne
	@JoinColumn(name = "cod_remetente")
	@JsonBackReference(value = "request-sender")
	private Sender sender;

	@ManyToOne
	@JoinColumn(name = "cod_status")
	@JsonBackReference(value = "request-status")
	private RequestStatus requestStatus;

	@OneToMany(mappedBy = "request")
	@JsonManagedReference(value = "requestHasProduct")
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

	public Float getRequestTotalValue()
	{
		return requestTotalValue;
	}

	public void setRequestTotalValue(Float requestTotalValue)
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
