package com.thomas.dahouet.model;

public class Commissaire extends Personne {

	
	protected String comite;

	
	

	public Commissaire(int idPersonne, String nom, String mail, String prenom, String comite) {
		super(idPersonne, nom, mail, prenom);
		this.comite = comite;
	}

	public String getComite() {
		return comite;
	}

	public void setComite(String comite) {
		this.comite = comite;
	}

	@Override
	public String toString() {
		return "Commissaire "+nom+" "+prenom+ " :\n\n-comite=" + comite + "\n-mail=" + mail;
	}
	
	

}
