package com.faminto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.faminto.util.validator.CheckNotWeekWinner;

@Entity
public class Voto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Votacao votacao;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	@CheckNotWeekWinner
	private Restaurante restaurante;

	public Voto() {
	}
	
	public Voto(Integer id, Votacao votacao, Usuario usuario, Restaurante restaurante) {
		this.id = id;
		this.votacao = votacao;
		this.usuario = usuario;
		this.restaurante = restaurante;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Votacao getVotacao() {
		return votacao;
	}

	public void setVotacao(Votacao votacao) {
		this.votacao = votacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Voto voto = (Voto) obj;
		
		if (id == null) {
			if (voto.id != null) {
				return false;
			}
		} else if (!id.equals(voto.id)) {
			return false;
		}
		
		return true;
	}
}
