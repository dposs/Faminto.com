package com.faminto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.faminto.dao.VotoDao;
import com.faminto.model.Voto;

@ManagedBean
@ApplicationScoped
public class VotoService implements Serializable {
	
	private static final long serialVersionUID = 8331502170988451085L;
	
	@ManagedProperty("#{votoDao}")
	private VotoDao votoDao;
	
	public void create(Voto voto) {
		voto.setId(getNextId());
		votoDao.insert(voto);
	}
	
	public void update(Voto voto) {
		votoDao.update(voto);
	}
	
	public void delete(List<Voto> votos) {
		for (Voto voto : votos) {
			votoDao.delete(voto);
		}
	}
	
	public List<Voto> findAll() {
		return votoDao.select();
	}
	
	public void setVotoDao(VotoDao votoDao) {
		this.votoDao = votoDao;
	}
	
	private int getNextId() {
		List<Voto> votos = findAll();
		
		if (votos.isEmpty()) {
			return 1;
		}
		
		List<Voto> votosSorted = new ArrayList<Voto>(votos);
		
		Collections.sort(votosSorted, new Comparator<Voto>() {
			@Override
			public int compare(Voto r1, Voto r2) {
				return r1.getId().compareTo(r2.getId());
			}
		});
		
		return votosSorted.get(votosSorted.size() - 1).getId() + 1;
	}
}
