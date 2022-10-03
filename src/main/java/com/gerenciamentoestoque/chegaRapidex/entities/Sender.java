package com.gerenciamentoestoque.chegaRapidex.entities;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "Remetente")
public class Sender
{
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne
	private Address address;

	@OneToMany(mappedBy = "sender")
	@JoinColumn(name = "cod_remetente", nullable = false)
	private List<Request> requestList;

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
