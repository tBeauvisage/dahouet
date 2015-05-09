package com.thomas.dahouhouet.controller;

import java.util.ArrayList;

import com.thomas.dahouet.DAO.proprioDAO;
import com.thomas.dahouet.DAO.voilierDAO;
import com.thomas.dahouet.GUI.NavireFrml;
import com.thomas.dahouet.GUI.NewProprio;
import com.thomas.dahouet.model.Classe;
import com.thomas.dahouet.model.Proprietaire;
import com.thomas.dahouet.model.Serie;

public class Controller {
	
	
	public void initNavireFrml(){
		NavireFrml frame1 = new NavireFrml();
		frame1.setVisible(true);
	}
	public void initNewProprio(){
		NewProprio frame2 = new NewProprio();
		frame2.setVisible(true);
	}
	
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
	
	public ArrayList<Proprietaire> proprioInit(){
		ArrayList<Proprietaire> listProprio = new ArrayList<Proprietaire>();
		listProprio=proprioDAO.getProprio();
		return listProprio;
}
}
