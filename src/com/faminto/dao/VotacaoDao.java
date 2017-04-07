package com.faminto.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.faminto.model.Votacao;

/**
 * Classe DAO FAKE.
 * Mantem valores em memoria.
 */
public class VotacaoDao implements Serializable {
	
	private static final long serialVersionUID = 4683793228369922502L;
	
	private static List<Votacao> votacoes;
	
	static {
		UsuarioDao usuarioDao = new UsuarioDao();
		
		votacoes = new ArrayList<Votacao>();
		votacoes.add(new Votacao(1, Date.from(LocalDate.of(2017, 3, 25).atStartOfDay(ZoneId.systemDefault()).toInstant()), usuarioDao.select().get(1)));
		votacoes.add(new Votacao(2, Date.from(LocalDate.of(2017, 3, 26).atStartOfDay(ZoneId.systemDefault()).toInstant()), usuarioDao.select().get(2)));
		votacoes.add(new Votacao(3, Date.from(LocalDate.of(2017, 3, 27).atStartOfDay(ZoneId.systemDefault()).toInstant()), usuarioDao.select().get(2)));
	}
	
	public void insert(Votacao votacao) {
		votacoes.add(votacao);
	}
	
	public void update(Votacao votacao) {
		votacoes.set(votacoes.indexOf(votacao), votacao);
	}
	
	public void delete(Votacao votacao) {
		votacoes.remove(votacao);
	}
	
	public List<Votacao> select() {
		Collections.sort(votacoes);
		return votacoes;
	}
}
