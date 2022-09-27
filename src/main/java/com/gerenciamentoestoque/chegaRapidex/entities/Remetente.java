package com.gerenciamentoestoque.chegaRapidex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Entity
public class Remetente
{
	@Column(name = "cod_remetente")
	private Long codRemetente;

	public Remetente()
	{

	}

	@Id
	@GeneratedValue
	public Long getCodRemetente()
	{
		return codRemetente;
	}

	public void setCodRemetente(Long codRemetente)
	{
		this.codRemetente = codRemetente;
	}
}
