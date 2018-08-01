package com.javaee.rodrigoandrades.projeto_final.domain;

import java.io.Serializable;

public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;

	private Acao acao;
	private Cliente vendedor;
	private Cliente comprador;
	private Double valor;
	
	public Acao getAcao() {
		return acao;
	}
	public void setAcao(Acao acao) {
		this.acao = acao;
	}
	public Cliente getVendedor() {
		return vendedor;
	}
	public void setVendedor(Cliente vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getComprador() {
		return comprador;
	}
	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}