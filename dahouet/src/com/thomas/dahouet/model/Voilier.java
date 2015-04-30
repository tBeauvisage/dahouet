package com.thomas.dahouet.model;

public class Voilier {
	
protected String nom;
protected double coef;
protected String serie;
protected String classe;



public Voilier(String nom, double coef, String serie, String classe) {
	super();
	this.nom = nom;
	this.coef = coef;
	this.serie = serie;
	this.classe = classe;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public double getCoef() {
	return coef;
}



public void setCoef(double coef) {
	this.coef = coef;
}



public String getSerie() {
	return serie;
}



public void setSerie(String serie) {
	this.serie = serie;
}



public String getClasse() {
	return classe;
}



public void setClasse(String classe) {
	this.classe = classe;
}



}
