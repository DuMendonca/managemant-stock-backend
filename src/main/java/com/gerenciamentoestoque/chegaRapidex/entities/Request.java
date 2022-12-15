package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Request implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	private Long requestId;

	private Integer requestTotalWeight;

	private Date requestDate;

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

	@OneToMany
	@JoinColumn(name = "productId")
	@JsonManagedReference(value = "request-product")
	private List<Product> products;

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

	public List<Product> getProducts()
	{
		return products;
	}

	public void setProducts(List<Product> products)
	{
		this.products = products;
	}
}
