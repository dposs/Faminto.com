package com.faminto.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.faminto.model.Voto;

/**
 * Classe DAO FAKE.
 * Mantem valores em memoria.
 */
@ManagedBean
@ApplicationScoped
public class VotoDao implements Serializable {
	
	private static final long serialVersionUID = 4683793228369922502L;
	
	private static List<Voto> votos;
	
	static {
		VotacaoDao votacaoDao = new VotacaoDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		RestauranteDao restauranteDao = new RestauranteDao();
		
		votos = new ArrayList<Voto>();
		votos.add(new Voto(1, votacaoDao.select().get(0), usuarioDao.select().get(0), restauranteDao.select().get(5)));
		votos.add(new Voto(1, votacaoDao.select().get(0), usuarioDao.select().get(1), restauranteDao.select().get(5)));
		votos.add(new Voto(1, votacaoDao.select().get(1), usuarioDao.select().get(0), restauranteDao.select().get(8)));
		votos.add(new Voto(1, votacaoDao.select().get(1), usuarioDao.select().get(1), restauranteDao.select().get(9)));
	}
	
	public void insert(Voto voto) {
		votos.add(voto);
	}
	
	public void update(Voto voto) {
		int index = votos.indexOf(voto);
		if (index == -1) {
			return;
		}
		votos.set(index, voto);
	}
	
	public void delete(Voto voto) {
		votos.remove(voto);
	}
	
	public List<Voto> select() {
		return votos;
	}
}
