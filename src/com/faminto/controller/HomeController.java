package com.faminto.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.faminto.enums.PageEnum;
import com.faminto.model.Usuario;
import com.faminto.service.UsuarioService;

@ManagedBean
@SessionScoped
public class HomeController implements Serializable {

	private static final long serialVersionUID = 1254161308660165158L;
	
	private PageEnum page;
	
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		page = PageEnum.RESTAURANTES;
	}
	
	public PageEnum getPage() {
		return page;
	}
	
	public void setPage(PageEnum page) {
		this.page = page;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioService.getUsuarioLogado();
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}