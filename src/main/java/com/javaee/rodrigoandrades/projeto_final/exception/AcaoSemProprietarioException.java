package com.javaee.rodrigoandrades.projeto_final.exception;

public class AcaoSemProprietarioException extends Exception{
	private static final long serialVersionUID = 1L;

	public AcaoSemProprietarioException() {
		super("Ação não possui um proprietário");
	}
}
