package com.faminto.enums;

public enum PageEnum {
	VOTACOES("Votações", "votacoes"),
	RESTAURANTES("Restaurantes", "restaurantes"),
	USUARIOS("Usuários", "usuarios");
	
	private String label;
	private String name;
	
	private PageEnum(String label, String name) {
		this.label = label;
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
