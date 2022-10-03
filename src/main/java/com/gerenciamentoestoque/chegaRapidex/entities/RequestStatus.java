package com.gerenciamentoestoque.chegaRapidex.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Status_Pedido")
public class RequestStatus
{
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_status")
	private Long requestStatusId;

	@Column(name = "descricao")
	private String descriptionStatus;

	@OneToMany(mappedBy = "requestStatus")
	@JoinColumn(name = "cod_status", nullable = false)
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
