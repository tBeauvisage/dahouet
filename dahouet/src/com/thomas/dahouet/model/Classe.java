package com.thomas.dahouet.model;

public class Classe extends Serie {
	
	private String nomClasse;

	public Classe(String nomSerie, String nomClasse) {
		super(nomSerie);
		this.nomClasse = nomClasse;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	
	
	

}
