package com.javaee.rodrigoandrades.projeto_final.exception;

public class AcaoJaPossuiProprietarioException extends Exception{
	private static final long serialVersionUID = 1L;

	public AcaoJaPossuiProprietarioException() {
		super("Ação já possui proprietário");
	}
}
