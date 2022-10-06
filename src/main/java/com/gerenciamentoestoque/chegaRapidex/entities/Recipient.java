package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Destinatario")
public class Recipient implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	@GeneratedValue
	@Column(name = "cod_destinatario")
	private Long recipientId;

	@Column(name = "nm_destinatario")
	private String recipientName;

	@Column(name = "dt_nasc")
	private Date recipientBirthDate;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_endereco", referencedColumnName = "cod_end")
	@JsonBackReference(value = "address-recipient")
	private Address addressRecipient;

	@OneToMany(mappedBy = "recipient")
	@JsonManagedReference(value = "request-recipient")
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

	public List<Request> getRequestList()
	{
		return requestList;
	}

	public void setRequestList(List<Request> requestList)
	{
		this.requestList = requestList;
	}
}
