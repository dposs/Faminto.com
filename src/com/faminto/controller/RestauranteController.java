package com.faminto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.faminto.model.Restaurante;
import com.faminto.service.RestauranteService;

@ManagedBean
@ViewScoped
public class RestauranteController implements Serializable {

	private static final long serialVersionUID = -8025092099653550485L;

	private List<Restaurante> restaurantes;
	
	@ManagedProperty("#{restauranteService}")
	private RestauranteService restauranteService;
	
	@PostConstruct
	public void init() {
		restaurantes = restauranteService.getAll();
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestauranteService(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}
}
