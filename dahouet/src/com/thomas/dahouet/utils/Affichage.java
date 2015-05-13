package com.thomas.dahouet.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.thomas.dahouet.model.Commissaire;
import com.thomas.dahouet.model.Licencie;
import com.thomas.dahouet.model.Proprietaire;


public class Affichage {

	public static void afficheLicencie() {

		SimpleDateFormat datnais = new SimpleDateFormat("yyyy/mm/dd");
		  String birthday="1987/01/13";
		  
		  
		  Licencie test=null;
		  try {
		   test = new Licencie(1,"Kirigaya", "Kirito@aincrad.net", "Kazuto", 1580, 230.8, datnais.parse(birthday), 2015);
		  } catch (ParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }

		String affichage = test.toString();
		System.out.println(affichage+"\n");

	}
	
	public static void afficheProprio(){
		
		Proprietaire test2 = new Proprietaire(2,"Shirogane", "naoto-chan@laposte.net", "Naoto", 33321510669L, "22, rue Junes Inaba");
		String affichage2 = test2.toString();
		System.out.println(affichage2+"\n");
	}
	
	
	public static void afficheCommissaire(){
		Commissaire test3 = new Commissaire(3,"Strife", "Cloud@midgard.net", "Cloud", "Nibelheim");
		String affichage3 = test3.toString();
		System.out.println(affichage3+"\n");
			
	}

}
