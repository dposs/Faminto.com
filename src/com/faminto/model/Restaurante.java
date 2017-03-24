package com.faminto.model;

import java.io.Serializable;

public class Restaurante implements Serializable {

	private static final long serialVersionUID = -5653590408117641620L;
	
	private String nome;

	public Restaurante(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
