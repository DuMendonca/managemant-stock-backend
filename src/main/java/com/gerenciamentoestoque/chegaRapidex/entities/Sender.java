package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import javax.persistence.*;


@Entity(name = "Remetente")
public class Sender
{
	@Column(name = "cod_remetente")
	private Long senderId;

	@Column(name = "nome_remetente")
	private String senderName;

	@Column(name = "dt_nasc")
	private Date senderBirthDate;

	@Column(name = "cpf")
	private Integer cpf;

	@Column(name = "rg")
	private Integer rg;

	@Column(name = "cod_endereco")
	private Integer addressId;

	@Id
	@GeneratedValue
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
