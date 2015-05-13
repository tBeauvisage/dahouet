package com.thomas.dahouet.model;

public class Personne {
	protected int idPersonne;
	protected String nom;
	protected String mail;
	protected String prenom;

	
	

	public Personne(int idPersonne, String nom, String mail, String prenom) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.mail = mail;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}



}		
