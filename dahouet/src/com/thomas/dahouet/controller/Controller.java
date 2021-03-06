package com.thomas.dahouet.controller;

import java.util.ArrayList;

import com.thomas.dahouet.DAO.proprioDAO;
import com.thomas.dahouet.DAO.voilierDAO;
import com.thomas.dahouet.GUI.Confirmation;
import com.thomas.dahouet.GUI.NavireFrml;
import com.thomas.dahouet.GUI.NewProprio;
import com.thomas.dahouet.model.Classe;
import com.thomas.dahouet.model.Club;
import com.thomas.dahouet.model.Proprietaire;
import com.thomas.dahouet.model.Serie;
import com.thomas.dahouet.model.Voilier;

public class Controller {
	
	
	public void initNavireFrml(){
		NavireFrml frame1 = new NavireFrml();
		frame1.setVisible(true);
	}
	public void initNewProprio(){
		NewProprio frame2 = new NewProprio();
		frame2.setVisible(true);
	}
	public void confirmInit(){
		Confirmation frame3 = new Confirmation();
		frame3.setVisible(true);
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
	public ArrayList<Club> clubInit(){
		ArrayList<Club> listClub = new ArrayList<Club>();
		listClub=proprioDAO.getClub();
		return listClub;
	}
	public void createProprio(Proprietaire proprio, Club club){
		
		proprioDAO.newProprio(proprio, club);
	}
	public void createVoilier (Voilier voilier,Classe classe, Proprietaire proprio){
		
		
		voilierDAO.newVoilier(voilier, classe, proprio);
		
	}
}
