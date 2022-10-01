package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Entity
public class Sender
{
	@Column(name = "cod_remetente")
	private Long codRemetente;

	public Sender()
	{

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCodRemetente()
	{
		return codRemetente;
	}

	public void setCodRemetente(Long codRemetente)
	{
		this.codRemetente = codRemetente;
	}
}
