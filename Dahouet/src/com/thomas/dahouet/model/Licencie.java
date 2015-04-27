package com.thomas.dahouet.model;

import java.util.Date;

public class Licencie extends Personne {

	public Licencie(String nom, String mail, String prenom) {
		super(nom, mail, prenom);
		// TODO Auto-generated constructor stub
	}
	 private int numeroLicence;
	 private double pointsFFV;
	 private Date dateNaissance;
	 private int anneeLicence;
	 
	 
	public Licencie(String nom, String mail, String prenom, int numeroLicence, double pointsFFV, Date dateNaissance, int anneeLicence) {
		super(nom, mail, prenom);
		this.numeroLicence = numeroLicence;
		this.pointsFFV = pointsFFV;
		this.dateNaissance = dateNaissance;
		this.anneeLicence = anneeLicence;
	}


	public int getNumeroLicence() {
		return numeroLicence;
	}


	public void setNumeroLicence(int numeroLicence) {
		this.numeroLicence = numeroLicence;
	}


	public double getPointsFFV() {
		return pointsFFV;
	}


	public void setPointsFFV(double pointsFFV) {
		this.pointsFFV = pointsFFV;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public int getAnneeLicence() {
		return anneeLicence;
	}


	public void setAnneeLicence(int anneeLicence) {
		this.anneeLicence = anneeLicence;
	}
	 
	 

}
