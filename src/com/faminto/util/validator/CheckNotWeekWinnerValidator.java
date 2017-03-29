package com.faminto.util.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.faminto.model.Restaurante;
import com.faminto.model.Voto;
import com.faminto.service.VotacaoService;

public class CheckNotWeekWinnerValidator implements ConstraintValidator<CheckNotWeekWinner, Voto> {

	VotacaoService votacaoService;
	List<Restaurante> restaurantesVencedoresSemana;
	
    @Override
    public void initialize(CheckNotWeekWinner annotation) {
    	votacaoService = new VotacaoService();
    	restaurantesVencedoresSemana = votacaoService.getRestaurantesVencedoresSemana();
    }

    @Override
    public boolean isValid(Voto voto, ConstraintValidatorContext constraintContext) {
        if (voto == null ) {
            return true;
        }

        return !restaurantesVencedoresSemana.contains(voto.getRestaurante());
    }
}
