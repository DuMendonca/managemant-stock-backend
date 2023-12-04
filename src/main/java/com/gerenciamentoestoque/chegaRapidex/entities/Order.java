package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order
{
	// attributes
	@Id
	private Long orderId;

	private Integer orderTotalWeight;

	private Date orderDate;

	private Float orderTotalValue;

	private Recipient recipient;

	private Sender sender;

	private OrderStatus orderStatus;

	private List<Product> products;

	// getters and  setters
	public Long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(Long OrderId)
	{
		this.orderId = OrderId;
	}

	public Integer getOrderTotalWeight()
	{
		return orderTotalWeight;
	}

	public void setOrderTotalWeight(Integer OrderTotalWeight)
	{
		this.orderTotalWeight = OrderTotalWeight;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(Date OrderDate)
	{
		this.orderDate = OrderDate;
	}

	public Float getOrderTotalValue()
	{
		return orderTotalValue;
	}

	public void setOrderTotalValue(Float OrderTotalValue)
	{
		this.orderTotalValue = OrderTotalValue;
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

	public OrderStatus getOrderStatus()
	{
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus OrderStatus)
	{
		this.orderStatus = OrderStatus;
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
