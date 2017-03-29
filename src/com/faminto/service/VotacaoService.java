package com.faminto.service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.faminto.dao.VotacaoDao;
import com.faminto.model.Restaurante;
import com.faminto.model.Votacao;
import com.faminto.model.Voto;
import com.faminto.util.date.DateUtils;

@ManagedBean
@ApplicationScoped
public class VotacaoService implements Serializable {
	
	private static final long serialVersionUID = 8331502170988451085L;
	
	private VotacaoDao votacaoDao;
	private UsuarioService usuarioService;
	private VotoService votoService;
	
	public VotacaoService() {
		votacaoDao = new VotacaoDao();
		usuarioService = new UsuarioService();
		votoService = new VotoService();
	}
	
	public void create(Votacao votacao) {
		votacao.setId(getNextId());
		votacao.setData(DateUtils.getDateWithTime(votacao.getData(), Votacao.DEFAULT_TIME));
		votacaoDao.insert(votacao);
	}
	
	public void update(Votacao votacao) {
		votacao.setData(DateUtils.getDateWithTime(votacao.getData(), Votacao.DEFAULT_TIME));
		votacaoDao.update(votacao);
	}
	
	public void delete(List<Votacao> votacoes) {
		for (Votacao votacao : votacoes) {
			votacaoDao.delete(votacao);
		}
	}
	
	public Votacao mount() {
		Votacao votacao = new Votacao();
		votacao.setData(DateUtils.getDateWithTime(new Date(), Votacao.DEFAULT_TIME));
		votacao.setRealizador(usuarioService.getUsuarioLogado());
		
		return votacao;
	}
	
	public List<Votacao> findAll() {
		return votacaoDao.select();
	}
	
	public List<Votacao> findByIntervalo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		List<Votacao> votacoesByDate = new ArrayList<Votacao>();
		List<Votacao> votacoes = findAll();
		
		for (Votacao votacao : votacoes) {
			LocalDateTime dataVotacao = LocalDateTime.ofInstant(votacao.getData().toInstant(), ZoneId.of("America/Sao_Paulo"));
			
			if (dataVotacao.isAfter(dataInicial) && dataVotacao.isBefore(dataFinal)) {
				votacoesByDate.add(votacao);
			}
		}
		
		return votacoesByDate;
	}
	
	public List<Map.Entry<Restaurante, Long>> getResultado(Votacao votacao) {
		List<Voto> votos = votoService.find(votacao);
		
		Map<Restaurante, Long> votosGrouped = votos.stream().collect(
			Collectors.groupingBy(Voto::getRestaurante, Collectors.counting())
		);
		
		return (ArrayList<Map.Entry<Restaurante, Long>>) votosGrouped.entrySet().stream().sorted(
			new Comparator<Map.Entry<Restaurante, Long>>() {
				@Override
				public int compare(Entry<Restaurante, Long> e1, Entry<Restaurante, Long> e2) {
					return e2.getValue().compareTo(e1.getValue());
				}
			}).collect(Collectors.toList());
	}
	
	public List<Restaurante> getRestaurantesVencedoresSemana() {

		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		
		LocalDateTime dataAtual = LocalDateTime.now();
		LocalDateTime dataPrimeiroDiaSemana = (dataAtual.with(WeekFields.of(Locale.ROOT).dayOfWeek(), 1));
		
		List<Votacao> votacoes = findByIntervalo(dataPrimeiroDiaSemana, dataAtual);
		
		for (Votacao votacao : votacoes) {
			List<Map.Entry<Restaurante, Long>> resultado = getResultado(votacao);
			
			if (!resultado.isEmpty()) {
				restaurantes.add(resultado.get(0).getKey());
			}
		}
		
		return restaurantes;
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
	
	public boolean isVotacaoAberta(Votacao votacao) {
		return votacao.getData().after(new Date());
	}
}
