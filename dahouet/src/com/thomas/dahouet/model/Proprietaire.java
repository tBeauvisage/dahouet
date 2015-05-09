package com.thomas.dahouet.model;

public class Proprietaire extends Personne  {

	public Proprietaire(String nom, String mail, String prenom) {
		super(nom, mail, prenom);
		// TODO Auto-generated constructor stub
	}

	private long telephone;
	private String adresse;
	
	
	public Proprietaire(String nom, String mail, String prenom, long telephone, String adresse) {
		super(nom, mail, prenom);
		this.telephone = telephone;
		this.adresse = adresse;
	}


	public long getTelephone() {
		return telephone;
	}


	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Proprietaire "+ nom +" "+prenom+" :\n\n-telephone = " + telephone + "\n-adresse=" + adresse + "\n-mail=" + mail ;
	}
	
	
	
	

}
