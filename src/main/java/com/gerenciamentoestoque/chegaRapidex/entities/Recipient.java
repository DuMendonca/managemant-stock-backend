package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import javax.persistence.*;

@Entity(name = "Destinatario")
public class Recipient
{
	@Column(name = "cod_destinatario")
	private Long recipientId;

	@Column(name = "nome_destinatario")
	private String recipientName;

	@Column(name = "dt_nasc")
	private Date recipientBirthDate;

	@Column(name = "cpf")
	private Integer cpf;

	@Column(name = "rg")
	private Integer rg;

	@Column(name = "cod_endereco")
	private Integer addressId;

	@Id
	@GeneratedValue
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

	public Integer getCpf()
	{
		return cpf;
	}

	public void setCpf(Integer cpf)
	{
		this.cpf = cpf;
	}

	public Integer getRg()
	{
		return rg;
	}

	public void setRg(Integer rg)
	{
		this.rg = rg;
	}

	public Integer getAddressId()
	{
		return addressId;
	}

	public void setAddressId(Integer addressId)
	{
		this.addressId = addressId;
	}
}
