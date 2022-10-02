package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Endereco")
public class Address
{
	@Column(name = "cod_endereco")
	private Long addressId;

	@Column(name = "cidade")
	private String city;

	@Column(name = "rua")
	private String road;

	@Column(name = "numero")
	private Integer number;

	@Id
	@GeneratedValue
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
