package com.faminto.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Votacao implements Comparable<Votacao> {

	public static final LocalTime DEFAULT_TIME;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	private Usuario realizador;

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