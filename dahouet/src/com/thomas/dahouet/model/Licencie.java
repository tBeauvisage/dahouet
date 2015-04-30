package com.thomas.dahouet.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thomas.dahouet.utils.Calcul;

public class Licencie extends Personne {

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

	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("yyyy/mm/dd");

		return "Licencie " + nom + " " + prenom + ":\n\n" + "-numeroLicence = " + numeroLicence + "\n-pointsFFV = " + pointsFFV
				+ "\n-dateNaissance = " + format.format(dateNaissance) +"\n-âge= "+Calcul.calculAge(dateNaissance)+ "\n-anneeLicence=" + anneeLicence + "\n-mail = " + mail;
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
