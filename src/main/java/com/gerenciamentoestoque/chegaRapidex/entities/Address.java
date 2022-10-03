package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Endereco")
public class Address
{
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_endereco")
	private Long addressId;

	@Column(name = "cidade")
	private String city;

	@Column(name = "rua")
	private String road;

	@Column(name = "numero")
	private Integer number;

	@OneToMany(mappedBy = "address")
	@JoinColumn(name = "cod_endereco", nullable = false)
	private List<Sender> senderList;

	@OneToMany(mappedBy = "address")
	@JoinColumn(name = "cod_endereco", nullable = false)
	private List<Recipient> recipientList;

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

	public List<Sender> getSenderList()
	{
		return senderList;
	}

	public void setSenderList(List<Sender> senderList)
	{
		this.senderList = senderList;
	}

	public List<Recipient> getRecipientList()
	{
		return recipientList;
	}

	public void setRecipientList(List<Recipient> recipientList)
	{
		this.recipientList = recipientList;
	}
}
