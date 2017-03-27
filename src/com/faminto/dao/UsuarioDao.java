package com.faminto.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.faminto.model.Usuario;

/**
 * Classe DAO FAKE.
 * Mantem valores em memoria.
 */
@ManagedBean
@ApplicationScoped
public class UsuarioDao implements Serializable {
	
	private static final long serialVersionUID = 4683793228369922502L;
	
	private static List<Usuario> usuarios;
	
	static {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(1, "Alex", "alex", "alex"));
		usuarios.add(new Usuario(2, "John", "john", "john"));
	}
	
	public void insert(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void update(Usuario usuario) {
		int index = usuarios.indexOf(usuario);
		if (index == -1) {
			return;
		}
		usuarios.set(index, usuario);
	}
	
	public void delete(Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public List<Usuario> select() {
		return usuarios;
	}
}
