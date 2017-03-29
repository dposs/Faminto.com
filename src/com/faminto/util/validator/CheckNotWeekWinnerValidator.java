package com.faminto.util.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.faminto.model.Restaurante;
import com.faminto.service.VotacaoService;

public class CheckNotWeekWinnerValidator implements ConstraintValidator<CheckNotWeekWinner, Restaurante> {
	
	List<Restaurante> restaurantesVencedoresSemana;
	
	private VotacaoService votacaoService;
	
    @Override
    public void initialize(CheckNotWeekWinner annotation) {
    	votacaoService = new VotacaoService();
    	restaurantesVencedoresSemana = votacaoService.getRestaurantesVencedoresSemana();
    }

    @Override
    public boolean isValid(Restaurante restaurante, ConstraintValidatorContext constraintContext) {
        if (restaurante == null) {
            return false;
        }

        return !restaurantesVencedoresSemana.contains(restaurante);
    }
    
    public void setVotacaoService(VotacaoService votacaoService) {
		this.votacaoService = votacaoService;
	}
}