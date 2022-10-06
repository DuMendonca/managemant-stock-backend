package com.gerenciamentoestoque.chegaRapidex.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Status_Pedido")
public class RequestStatus implements Serializable
{
	private static final long serialVersionUID = 1L;

	// attributes
	@Id
	@GeneratedValue
	@Column(name = "cod_status")
	private Long requestStatusId;

	@Column(name = "descricao")
	private String descriptionStatus;

	@OneToMany(mappedBy = "requestStatus")
	@JsonManagedReference(value = "request-status")
	private List<Request> requestList;

	// getters and setters
	public Long getRequestStatusId()
	{
		return requestStatusId;
	}

	public void setRequestStatusId(Long requestStatusId)
	{
		this.requestStatusId = requestStatusId;
	}

	public String getDescriptionStatus()
	{
		return descriptionStatus;
	}

	public void setDescriptionStatus(String descriptionStatus)
	{
		this.descriptionStatus = descriptionStatus;
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
