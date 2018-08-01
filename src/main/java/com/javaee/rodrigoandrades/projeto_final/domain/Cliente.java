package com.javaee.rodrigoandrades.projeto_final.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "cliente", targetEntity = Acao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Acao> acoes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}