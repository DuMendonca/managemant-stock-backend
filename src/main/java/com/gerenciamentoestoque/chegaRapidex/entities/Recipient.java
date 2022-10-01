package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Recipient
{
	@Column(name = "cod_destinatario")
	private Long codDestinatario;

	public Recipient()
	{

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCodDestinatario()
	{
		return codDestinatario;
	}

	public void setCodDestinatario(Long codDestinatario)
	{
		this.codDestinatario = codDestinatario;
	}
}
