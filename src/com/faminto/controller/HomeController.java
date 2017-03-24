package com.faminto.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HomeController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String page;

	public String getPage() {
		return page;
	}
	
	public void setPage(String page) {
		this.page = page;
	}
}