package com.faminto.service;

import java.util.ArrayList;
import java.util.List;

import com.faminto.model.Restaurante;

public class RestauranteService {

	private static List<Restaurante> restaurantes;
	
	static {
		restaurantes.add(new Restaurante("Dom Filipo"));
		restaurantes.add(new Restaurante("Trattoria do Sabor"));
		restaurantes.add(new Restaurante("Botafogo"));
		restaurantes.add(new Restaurante("Sério Pizzas"));
		restaurantes.add(new Restaurante("Mackenzie"));
		restaurantes.add(new Restaurante("Vanguarda"));
		restaurantes.add(new Restaurante("Domenico"));
		restaurantes.add(new Restaurante("Fino Sabor"));
		restaurantes.add(new Restaurante("Canta Maria"));
	}
	
	public void create(Restaurante restaurante) {
		restaurantes.add(restaurante);
	}
	
	public List<Restaurante> getAll() {
		return restaurantes;
	}
}
