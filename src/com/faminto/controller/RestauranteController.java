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
import com.faminto.model.Restaurante;
import com.faminto.service.RestauranteService;

@ManagedBean
@ViewScoped
public class RestauranteController implements Serializable {

	private static final long serialVersionUID = -8025092099653550485L;

	private ActionEnum action;
	
	private Restaurante restaurante;
	private List<Restaurante> restaurantes;
	
	private List<Restaurante> selectedRestaurantes;
	
	@ManagedProperty("#{restauranteService}")
	private RestauranteService restauranteService;
	
	@PostConstruct
	public void init() {
		restaurante = new Restaurante();
		restaurantes = restauranteService.findAll();
		selectedRestaurantes = new ArrayList<Restaurante>();
	}

	public ActionEnum getAction() {
		return action;
	}

	public void setAction(ActionEnum action) {
		this.action = action;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}
	
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	public void mountRestaurante() {
		restaurante = new Restaurante();
	}
	
	public void saveRestaurante() {
		switch (action) {
		case CREATE:
			restauranteService.create(restaurante);
			break;
		case UPDATE:
			restauranteService.update(restaurante);
			break;
		default:
			throw new InvalidParameterException();
		}
	}
	
	public void deleteSelectedRestaurantes() {
		restauranteService.delete(selectedRestaurantes);
		selectedRestaurantes = new ArrayList<Restaurante>();
	}
	
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}
	
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public List<Restaurante> getSelectedRestaurantes() {
		return selectedRestaurantes;
	}

	public void setSelectedRestaurantes(List<Restaurante> selectedRestaurantes) {
		this.selectedRestaurantes = selectedRestaurantes;
	}

	public boolean isExcluirEnabled() {
		return selectedRestaurantes.size() > 0;
	}
	
	public void setRestauranteService(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}
}