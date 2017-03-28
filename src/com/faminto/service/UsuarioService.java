package com.faminto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.faminto.dao.UsuarioDao;
import com.faminto.model.Usuario;

@ManagedBean
@ApplicationScoped
public class UsuarioService implements Serializable {
	
	private static final long serialVersionUID = 8331502170988451085L;

	private Usuario usuarioLogado;
	
	@ManagedProperty("#{usuarioDao}")
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void init() {
		usuarioLogado = usuarioDao.select("admin");
	}
	
	public void create(Usuario usuario) {
		usuario.setId(getNextId());
		usuarioDao.insert(usuario);
	}
	
	public void update(Usuario usuario) {
		usuarioDao.update(usuario);
	}
	
	public void delete(List<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			usuarioDao.delete(usuario);
		}
	}
	
	public List<Usuario> findAll() {
		return usuarioDao.select();
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	private int getNextId() {
		List<Usuario> usuarios = findAll();
		
		if (usuarios.isEmpty()) {
			return 1;
		}
		
		List<Usuario> usuariosSorted = new ArrayList<Usuario>(usuarios);
		
		Collections.sort(usuariosSorted, new Comparator<Usuario>() {
			@Override
			public int compare(Usuario r1, Usuario r2) {
				return r1.getId().compareTo(r2.getId());
			}
		});
		
		return usuariosSorted.get(usuariosSorted.size() - 1).getId() + 1;
	}
}