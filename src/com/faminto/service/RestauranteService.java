package com.faminto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.faminto.dao.RestauranteDao;
import com.faminto.model.Restaurante;

@ManagedBean
@ApplicationScoped
public class RestauranteService implements Serializable {

	private static final long serialVersionUID = 9075414646670976304L;
	
	@ManagedProperty("#{restauranteDao}")
	private RestauranteDao restauranteDao;
	
	public void create(Restaurante restaurante) {
		restaurante.setId(getNextId());
		restauranteDao.insert(restaurante);
	}
	
	public void update(Restaurante restaurante) {
		restauranteDao.update(restaurante);
	}
	
	public void delete(List<Restaurante> restaurantes) {
		for (Restaurante restaurante : restaurantes) {
			restauranteDao.delete(restaurante);
		}
	}
	
	public List<Restaurante> findAll() {
		return restauranteDao.select();
	}
	
	public Restaurante find(Integer id) {
		return restauranteDao.select(id);
	}
	
	public void setRestauranteDao(RestauranteDao restauranteDao) {
		this.restauranteDao = restauranteDao;
	}
	
	private int getNextId() {
		List<Restaurante> restaurantes = findAll();
		
		if (restaurantes.isEmpty()) {
			return 1;
		}
		
		List<Restaurante> restaurantesSorted = new ArrayList<Restaurante>(restaurantes);
		
		Collections.sort(restaurantesSorted, new Comparator<Restaurante>() {
			@Override
			public int compare(Restaurante r1, Restaurante r2) {
				return r1.getId().compareTo(r2.getId());
			}
		});
		
		return restaurantesSorted.get(restaurantesSorted.size() - 1).getId() + 1;
	}
}
