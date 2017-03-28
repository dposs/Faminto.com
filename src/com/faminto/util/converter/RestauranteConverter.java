package com.faminto.util.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.faminto.model.Restaurante;
import com.faminto.service.RestauranteService;

@ManagedBean
@RequestScoped
public class RestauranteConverter implements Converter {

    @ManagedProperty("#{restauranteService}")
    private RestauranteService restauranteService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Restaurante) || ((Restaurante) value).getId() == null) {
            return null;
        }

        return String.valueOf(((Restaurante) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+")) {
            return null;
        }

        Restaurante restaurante = restauranteService.find(Integer.valueOf(value));

        if (restaurante == null) {
            throw new ConverterException(new FacesMessage("Restaurante nao reconhecido. Id: " + value));
        }

        return restaurante;
    }
    
    public void setRestauranteService(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}
}