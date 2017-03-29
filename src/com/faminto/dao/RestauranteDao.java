package com.faminto.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.faminto.model.Restaurante;

/**
 * Classe DAO FAKE.
 * Mantem valores em memoria.
 */
public class RestauranteDao implements Serializable {
	
	private static final long serialVersionUID = -5482752818133399600L;
	
	private static List<Restaurante> restaurantes;
	
	static {
		restaurantes = new ArrayList<Restaurante>();
		restaurantes.add(new Restaurante(1, "Dom Filipo"));
		restaurantes.add(new Restaurante(2, "Trattoria do Sabor"));
		restaurantes.add(new Restaurante(3, "Botafogo"));
		restaurantes.add(new Restaurante(4, "Sérgio Pizzas"));
		restaurantes.add(new Restaurante(5, "Sappore"));
		restaurantes.add(new Restaurante(6, "Vanguarda"));
		restaurantes.add(new Restaurante(7, "Domenico"));
		restaurantes.add(new Restaurante(8, "Fino Sabor"));
		restaurantes.add(new Restaurante(9, "Canta Maria"));
		restaurantes.add(new Restaurante(10, "Casa DiPaolo"));
		restaurantes.add(new Restaurante(11, "Andrea"));
		restaurantes.add(new Restaurante(12, "Churrascaria Imperador"));
		restaurantes.add(new Restaurante(13, "Famiglia Gelain"));
		restaurantes.add(new Restaurante(14, "Château Lacave"));
		restaurantes.add(new Restaurante(15, "Don Claudino"));
		restaurantes.add(new Restaurante(16, "Puerto del Toro"));
		restaurantes.add(new Restaurante(17, "Galeteria Alvorada"));
		restaurantes.add(new Restaurante(18, "Zanuzi"));
		restaurantes.add(new Restaurante(19, "Arcanjo Fondue"));
		restaurantes.add(new Restaurante(20, "Talharim"));
		restaurantes.add(new Restaurante(21, "Hamburgueria Juventus"));
		restaurantes.add(new Restaurante(22, "Granpiacer"));
		restaurantes.add(new Restaurante(23, "Hamburgueria Jaime Rocha"));
	}
	
	public void insert(Restaurante restaurante) {
		restaurantes.add(restaurante);
	}
	
	public void update(Restaurante restaurante) {
		int index = restaurantes.indexOf(restaurante);
		if (index == -1) {
			return;
		}
		restaurantes.set(index, restaurante);
	}
	
	public void delete(Restaurante restaurante) {
		restaurantes.remove(restaurante);
	}
	
	public List<Restaurante> select() {
		return restaurantes;
	}
	
	public Restaurante select(Integer id) {
		for (Restaurante restaurante : restaurantes) {
			if (restaurante.getId().equals(id)) {
				return restaurante;
			}
		}
		return null;
	}
}
