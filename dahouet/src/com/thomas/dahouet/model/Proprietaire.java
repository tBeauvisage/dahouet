package com.thomas.dahouet.model;

public class Proprietaire extends Personne  {

	
	

	protected long telephone;
	protected String adresse;
	
	
	

	public Proprietaire(int idPersonne, String nom, String mail, String prenom, long telephone, String adresse) {
		super(idPersonne, nom, mail, prenom);
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


	
	public String affiche() {
		return "Proprietaire "+ nom +" "+prenom+" :\n\n-telephone = " + telephone + "\n-adresse=" + adresse + "\n-mail=" + mail ;
	}


	@Override
	public String toString() {
		return idPersonne + " : "+ nom + " " + prenom;
	}
	
	
	
	
	

}
