package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document ("recipient")
public class Recipient
{
	// attributes
	@Id
	private Long recipientId;

	private String recipientName;

	private Date recipientBirthDate;

	private String cpf;

	private String rg;

	private Address addressRecipient;

	// getters and setters
	public Long getRecipientId()
	{
		return recipientId;
	}

	public void setRecipientId(Long recipientId)
	{
		this.recipientId = recipientId;
	}

	public String getRecipientName()
	{
		return recipientName;
	}

	public void setRecipientName(String recipientName)
	{
		this.recipientName = recipientName;
	}

	public Date getRecipientBirthDate()
	{
		return recipientBirthDate;
	}

	public void setRecipientBirthDate(Date recipientBirthDate)
	{
		this.recipientBirthDate = recipientBirthDate;
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

	public Address getAddressRecipient()
	{
		return addressRecipient;
	}

	public void setAddressRecipient(Address addressRecipient)
	{
		this.addressRecipient = addressRecipient;
	}
}
