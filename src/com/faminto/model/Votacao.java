package com.faminto.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Votacao implements Serializable, Comparable<Votacao> {

	private static final long serialVersionUID = 1046918674287759585L;
	
	public static final LocalTime DEFAULT_TIME;
	
	private Integer id;
	private Date data;
	private Usuario realizador;
	private List<Voto> votos;

	static {
		DEFAULT_TIME = LocalTime.of(12, 0, 0);
	}
	
	public Votacao() {
	}
	
	public Votacao(Integer id, Date data, Usuario realizador) {
		this.id = id;
		this.data = data;
		this.realizador = realizador;
	}
	
	public Votacao(Integer id, Date data, Usuario realizador, List<Voto> votos) {
		this.id = id;
		this.data = data;
		this.realizador = realizador;
		this.votos = votos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Usuario getRealizador() {
		return realizador;
	}

	public void setRealizador(Usuario realizador) {
		this.realizador = realizador;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Votacao votacao = (Votacao) obj;
		
		if (id == null) {
			if (votacao.id != null) {
				return false;
			}
		} else if (!id.equals(votacao.id)) {
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(Votacao votacao) {
		return data.compareTo(votacao.getData()) * -1;
	}
}