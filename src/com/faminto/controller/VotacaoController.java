package com.faminto.controller;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.faminto.enums.ActionEnum;
import com.faminto.model.Votacao;
import com.faminto.service.UsuarioService;
import com.faminto.service.VotacaoService;

@ManagedBean
@ViewScoped
public class VotacaoController implements Serializable {

	private static final long serialVersionUID = -8025092099653550485L;

	private ActionEnum action;
	
	private Votacao votacao;
	private List<Votacao> votacoes;
	
	private List<Votacao> selectedVotacoes;
	
	@ManagedProperty("#{votacaoService}")
	private VotacaoService votacaoService;
	
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		votacao = new Votacao();
		votacoes = votacaoService.findAll();
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
		votacao = new Votacao();
		votacao.setData(new Date());
		votacao.setRealizador(usuarioService.getUsuarioLogado());
	}
	
	public void saveVotacao() {
		switch (action) {
		case CREATE:
			votacaoService.create(votacao);
			break;
		case UPDATE:
			votacaoService.update(votacao);
			break;
		default:
			throw new InvalidParameterException();
		}
	}
	
	public void deleteSelectedVotacoes() {
		votacaoService.delete(selectedVotacoes);
		selectedVotacoes = new ArrayList<Votacao>();
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

	public void setSelectedVotacoes(List<Votacao> selectedVotacoes) {
		this.selectedVotacoes = selectedVotacoes;
	}

	public boolean isExcluirEnabled() {
		return selectedVotacoes.size() > 0;
	}
	
	public void setVotacaoService(VotacaoService votacaoService) {
		this.votacaoService = votacaoService;
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
