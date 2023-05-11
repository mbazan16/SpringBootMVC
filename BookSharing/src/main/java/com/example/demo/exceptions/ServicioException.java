package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class ServicioException extends Exception {

	final String codigo;
	
	public ServicioException(String codigo, Exception e) {
		super(e.getMessage());
		this.codigo=codigo;
	}

	public ServicioException(String codigo) {
		this.codigo=codigo;
	}

}
