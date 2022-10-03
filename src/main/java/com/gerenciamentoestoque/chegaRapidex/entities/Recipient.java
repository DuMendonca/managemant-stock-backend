package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Destinatario")
public class Recipient
{
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne
	private Address address;

	@OneToMany(mappedBy = "recipient")
	@JoinColumn(name = "cod_destinatario", nullable = false)
	private List<Request> requestList;

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

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public List<Request> getRequestList()
	{
		return requestList;
	}

	public void setRequestList(List<Request> requestList)
	{
		this.requestList = requestList;
	}
}
