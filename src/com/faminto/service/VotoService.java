package com.faminto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.faminto.dao.VotoDao;
import com.faminto.model.Usuario;
import com.faminto.model.Votacao;
import com.faminto.model.Voto;

@ManagedBean
@ApplicationScoped
public class VotoService implements Serializable {
	
	private static final long serialVersionUID = 8331502170988451085L;
	
	private static Validator validator;
	
	@PostConstruct
    public static void initValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
	@ManagedProperty("#{votoDao}")
	private VotoDao votoDao;
	
	public void create(Voto voto) {
		//validate(voto);
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
	
	public void validate(Voto voto) {
		Set<ConstraintViolation<Voto>> constraintViolations = validator.validate(voto);
		
		if (!constraintViolations.isEmpty()) {
			throw new IllegalArgumentException(constraintViolations.iterator().next().getMessage());
		}
	}
	
	public Voto mount(Votacao votacao, Usuario usuario) {
		Voto voto = new Voto();
		voto.setVotacao(votacao);
		voto.setUsuario(usuario);
		
		return voto;
	}
	
	public List<Voto> findAll() {
		return votoDao.select();
	}
	
	public List<Voto> find(Votacao votacao) {
		List<Voto> votosVotacao = new ArrayList<Voto>();
		List<Voto> votos = findAll();
		
		for (Voto voto : votos) {
			if (voto.getVotacao().equals(votacao)) {
				votosVotacao.add(voto);
			}
		}
		
		return votosVotacao;
	}
	
	public Voto find(Votacao votacao, Usuario usuario) {
		List<Voto> votos = findAll();
		for (Voto voto : votos) {
			if (voto.getVotacao().equals(votacao) && voto.getUsuario().equals(usuario)) {
				return voto;
			}
		}
		return null;
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
