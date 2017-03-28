package com.faminto.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Restaurante implements Serializable {

	private static final long serialVersionUID = -5653590408117641620L;
	
	private Integer id;
	private String nome;

	public Restaurante() {
	}
	
	public Restaurante(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Restaurante restaurante = (Restaurante) obj;
		
		if (id == null) {
			if (restaurante.id != null) {
				return false;
			}
		} else if (!id.equals(restaurante.id)) {
			return false;
		}
		
		return true;
	}
}
