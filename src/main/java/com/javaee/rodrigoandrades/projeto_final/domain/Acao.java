package com.javaee.rodrigoandrades.projeto_final.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Acao {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}