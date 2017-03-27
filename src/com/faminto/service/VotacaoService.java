package com.faminto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.faminto.dao.VotacaoDao;
import com.faminto.model.Votacao;

@ManagedBean
@ApplicationScoped
public class VotacaoService implements Serializable {
	
	private static final long serialVersionUID = 8331502170988451085L;
	
	@ManagedProperty("#{votacaoDao}")
	private VotacaoDao votacaoDao;
	
	public void create(Votacao votacao) {
		votacao.setId(getNextId());
		votacaoDao.insert(votacao);
	}
	
	public void update(Votacao votacao) {
		votacaoDao.update(votacao);
	}
	
	public void delete(List<Votacao> votacoes) {
		for (Votacao votacao : votacoes) {
			votacaoDao.delete(votacao);
		}
	}
	
	public List<Votacao> findAll() {
		return votacaoDao.select();
	}
	
	public void setVotacaoDao(VotacaoDao votacaoDao) {
		this.votacaoDao = votacaoDao;
	}
	
	private int getNextId() {
		List<Votacao> votacoes = findAll();
		
		if (votacoes.isEmpty()) {
			return 1;
		}
		
		List<Votacao> votacoesSorted = new ArrayList<Votacao>(votacoes);
		
		Collections.sort(votacoesSorted, new Comparator<Votacao>() {
			@Override
			public int compare(Votacao r1, Votacao r2) {
				return r1.getId().compareTo(r2.getId());
			}
		});
		
		return votacoesSorted.get(votacoesSorted.size() - 1).getId() + 1;
	}
}
