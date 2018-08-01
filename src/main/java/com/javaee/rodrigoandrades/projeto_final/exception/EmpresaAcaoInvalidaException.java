package com.javaee.rodrigoandrades.projeto_final.exception;

public class EmpresaAcaoInvalidaException extends Exception{
	private static final long serialVersionUID = 1L;

	public EmpresaAcaoInvalidaException() {
		super("Ação e empresa divergente");
	}
}
