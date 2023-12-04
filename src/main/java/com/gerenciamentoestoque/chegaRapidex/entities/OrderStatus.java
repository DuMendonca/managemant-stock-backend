package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("OrderStatus")
public class OrderStatus
{
	// attributes
	@Id
	private Long OrderStatusId;

	private String descriptionStatus;

	private List<Order> orderList;

	// getters and setters
	public Long getOrderStatusId()
	{
		return OrderStatusId;
	}

	public void setOrderStatusId(Long OrderStatusId)
	{
		this.OrderStatusId = OrderStatusId;
	}

	public String getDescriptionStatus()
	{
		return descriptionStatus;
	}

	public void setDescriptionStatus(String descriptionStatus)
	{
		this.descriptionStatus = descriptionStatus;
	}

	public List<Order> getOrderList()
	{
		return orderList;
	}

	public void setOrderList(List<Order> orderList)
	{
		this.orderList = orderList;
	}
}
