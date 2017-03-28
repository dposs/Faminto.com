package com.faminto.controller;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.faminto.enums.ActionEnum;
import com.faminto.model.Usuario;
import com.faminto.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -8025092099653550485L;

	private ActionEnum action;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	private List<Usuario> selectedUsuarios;
	
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		usuarios = usuarioService.findAll();
		selectedUsuarios = new ArrayList<Usuario>();
	}

	public ActionEnum getAction() {
		return action;
	}

	public void setAction(ActionEnum action) {
		this.action = action;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void mountUsuario() {
		usuario = new Usuario();
	}
	
	public void saveUsuario() {
		switch (action) {
		case CREATE:
			usuarioService.create(usuario);
			break;
		case UPDATE:
			usuarioService.update(usuario);
			break;
		default:
			throw new InvalidParameterException();
		}
	}
	
	public void deleteSelectedUsuarios() {
		usuarioService.delete(selectedUsuarios);
		selectedUsuarios = new ArrayList<Usuario>();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getSelectedUsuarios() {
		return selectedUsuarios;
	}

	public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
		this.selectedUsuarios = selectedUsuarios;
	}

	public boolean isExcluirEnabled() {
		return selectedUsuarios.size() > 0;
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}