package com.faminto.controller;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import com.faminto.model.Restaurante;
import com.faminto.service.RestauranteService;

public class RestauranteController {

	private List<Restaurante> restaurantes;
	
	@ManagedProperty("#{RestauranteService}")
	private RestauranteService restauranteService;
	
	@PostContruct
	public void init() {
		restaurantes
	}
}
