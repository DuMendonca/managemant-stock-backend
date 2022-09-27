package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Destinatario
{
	@Column(name = "cod_destinatario")
	private Long codDestinatario;

	public Destinatario()
	{

	}

	@Id
	@GeneratedValue
	public Long getCodDestinatario()
	{
		return codDestinatario;
	}

	public void setCodDestinatario(Long codDestinatario)
	{
		this.codDestinatario = codDestinatario;
	}
}
