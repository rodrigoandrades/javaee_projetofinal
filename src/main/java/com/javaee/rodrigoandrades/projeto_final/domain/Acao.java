package com.javaee.rodrigoandrades.projeto_final.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Acao {
	public Acao() {}
	
	public Acao(Empresa empresa, Double valorInicial, Double valorAtual, Date dataCompra, Date dataEmissao) {
		this.valorInicial = valorInicial;
		this.valorAtual= valorAtual;
		this.dataCompra = dataCompra;
		this.dataEmissao = dataEmissao;
		this.empresa = empresa;
	}
	
	@Id
	@GeneratedValue
	@Column(nullable=false, unique=true)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable=false)
	private Empresa empresa;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable=true)
	private Cliente cliente;
	
	private Double valorInicial;
	private Double valorAtual;
	private Date dataCompra;
	private Date dataEmissao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(Double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
}