package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("sender")
public class Sender
{
	// attributes
	@Id
	private Long senderId;

	private String senderName;

	private Date senderBirthDate;

	private String cpf;

	private String rg;

	private Address addressSender;

	// getters and setters
	public Long getSenderId()
	{
		return senderId;
	}

	public void setSenderId(Long senderId)
	{
		this.senderId = senderId;
	}

	public String getSenderName()
	{
		return senderName;
	}

	public void setSenderName(String senderName)
	{
		this.senderName = senderName;
	}

	public Date getSenderBirthDate()
	{
		return senderBirthDate;
	}

	public void setSenderBirthDate(Date senderBirthDate)
	{
		this.senderBirthDate = senderBirthDate;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	public Address getAddressSender()
	{
		return addressSender;
	}

	public void setAddressSender(Address addressSender)
	{
		this.addressSender = addressSender;
	}
}
