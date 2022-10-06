package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "Remetente")
public class Sender implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	@GeneratedValue
	@Column(name = "cod_remetente")
	private Long senderId;

	@Column(name = "nm_remetente")
	private String senderName;

	@Column(name = "dt_nasc")
	private Date senderBirthDate;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_endereco", referencedColumnName = "cod_end")
	@JsonBackReference(value = "address-sender")
	private Address addressSender;

	@OneToMany(mappedBy = "sender")
	@JsonManagedReference(value = "request-sender")
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

	@JsonBackReference
	public Address getAddressSender()
	{
		return addressSender;
	}

	public void setAddressSender(Address addressSender)
	{
		this.addressSender = addressSender;
	}

	@JsonManagedReference
	public List<Request> getRequestList()
	{
		return requestList;
	}

	public void setRequestList(List<Request> requestList)
	{
		this.requestList = requestList;
	}
}
