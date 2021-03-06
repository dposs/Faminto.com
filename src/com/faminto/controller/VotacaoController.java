package com.faminto.controller;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.faminto.enums.ActionEnum;
import com.faminto.model.Restaurante;
import com.faminto.model.Usuario;
import com.faminto.model.Votacao;
import com.faminto.model.Voto;
import com.faminto.service.RestauranteService;
import com.faminto.service.UsuarioService;
import com.faminto.service.VotacaoService;
import com.faminto.service.VotoService;

@ManagedBean
@ViewScoped
public class VotacaoController implements Serializable {

	private static final long serialVersionUID = -8025092099653550485L;

	private ActionEnum action;
	
	private Votacao votacao;
	private Voto voto;
	
	private List<Votacao> votacoes;
	private List<Votacao> selectedVotacoes;
	
	private List<Restaurante> restaurantes;
	
	@ManagedProperty("#{votacaoService}")
	private VotacaoService votacaoService;
	
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	
	@ManagedProperty("#{restauranteService}")
	private RestauranteService restauranteService;
	
	@ManagedProperty("#{votoService}")
	private VotoService votoService;
	
	@PostConstruct
	public void init() {
		votacao = new Votacao();
		voto = new Voto();
		
		votacoes = votacaoService.findAll();
		restaurantes = restauranteService.findAll();
		
		selectedVotacoes = new ArrayList<Votacao>();
	}

	public ActionEnum getAction() {
		return action;
	}

	public void setAction(ActionEnum action) {
		this.action = action;
	}
	
	public Votacao getVotacao() {
		return votacao;
	}
	
	public void setVotacao(Votacao votacao) {
		this.votacao = votacao;
	}
	
	public void mountVotacao() {
		votacao = votacaoService.mount();
	}
	
	public void saveVotacao() {
		switch (getVotacaoAction()) {
		case CREATE:
			votacaoService.create(votacao);
			Collections.sort(votacoes);
			break;
		case UPDATE:
			votacaoService.update(votacao);
			Collections.sort(votacoes);
			break;
		default:
			throw new InvalidParameterException();
		}
	}
	
	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}
	
	public void setVoto() {
		Usuario usuarioLogado = usuarioService.getUsuarioLogado();
		voto = votoService.find(votacao, usuarioLogado);
		
		if (voto == null) {
			voto = votoService.mount(votacao, usuarioLogado);
		}
	}
	
	public void saveVoto() {
		switch (getVotoAction()) {
		case CREATE:
			votoService.create(voto);
			break;
		case UPDATE:
			votoService.update(voto);
			break;
		default:
			throw new InvalidParameterException();
		}
	}
	
	public List<Map.Entry<Restaurante, Long>> getResultado() {
		return votacaoService.getResultado(votacao);
	}
	
	public List<Votacao> getVotacoes() {
		return votacoes;
	}
	
	public void setVotacoes(List<Votacao> votacoes) {
		this.votacoes = votacoes;
	}

	public List<Votacao> getSelectedVotacoes() {
		return selectedVotacoes;
	}
	
	public boolean isVotacaoAberta(Votacao votacao) {
		return votacaoService.isVotacaoAberta(votacao);
	}

	public void setSelectedVotacoes(List<Votacao> selectedVotacoes) {
		this.selectedVotacoes = selectedVotacoes;
	}
	
	public void deleteSelectedVotacoes() {
		votacaoService.delete(selectedVotacoes);
		selectedVotacoes = new ArrayList<Votacao>();
	}
	
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public boolean isExcluirEnabled() {
		return selectedVotacoes.size() > 0;
	}
	
	public ActionEnum getVotacaoAction() {
		return votacao.getId() == null ? ActionEnum.CREATE : ActionEnum.UPDATE;
	}
	
	public ActionEnum getVotoAction() {
		return voto.getId() == null ? ActionEnum.CREATE : ActionEnum.UPDATE;
	}
	
	public void setVotacaoService(VotacaoService votacaoService) {
		this.votacaoService = votacaoService;
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public void setRestauranteService(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}

	public void setVotoService(VotoService votoService) {
		this.votoService = votoService;
	}
}