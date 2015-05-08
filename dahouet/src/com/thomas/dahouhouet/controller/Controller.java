package com.thomas.dahouhouet.controller;

import java.util.ArrayList;

import com.thomas.dahouet.DAO.voilierDAO;
import com.thomas.dahouet.model.Classe;
import com.thomas.dahouet.model.Serie;

public class Controller {
	
	
	public ArrayList<Serie> serieInit(){
		ArrayList<Serie> listSerie = new ArrayList<Serie>();
		listSerie=voilierDAO.getSerie();
		return listSerie;
	}
	
	public ArrayList<Classe> classeInit(Serie serie){
		ArrayList<Classe> listClasse = new ArrayList<Classe>();
		listClasse=voilierDAO.getClasse(serie);
		return listClasse;
	}
	

}
