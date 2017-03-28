package com.faminto.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Usuario implements Serializable {

	private static final long serialVersionUID = -131871017284830121L;
	
	private Integer id;
	private String nome;
	private String login;
	private String senha;

	public Usuario() {
	}
	
	public Usuario(Integer id, String nome, String login, String senha) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
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
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Usuario usuario = (Usuario) obj;
		
		if (id == null) {
			if (usuario.id != null) {
				return false;
			}
		} else if (!id.equals(usuario.id)) {
			return false;
		}
		
		return true;
	}
}
