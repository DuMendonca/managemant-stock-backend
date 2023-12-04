package com.gerenciamentoestoque.chegaRapidex.entities;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("adress")
public class Address
{
	// attributes
	@Id
	private Long addressId;

	private String city;

	private String road;

	private Integer number;

	// getters and setters
	public Long getAddressId()
	{
		return addressId;
	}

	public void setAddressId(Long addressId)
	{
		this.addressId = addressId;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getRoad()
	{
		return road;
	}

	public void setRoad(String road)
	{
		this.road = road;
	}

	public Integer getNumber()
	{
		return number;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}
}
