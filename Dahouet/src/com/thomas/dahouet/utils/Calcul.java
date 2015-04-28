package com.thomas.dahouet.utils;

import java.util.Date;

import org.joda.time.Period;

import com.thomas.dahouet.model.Licencie;

public class Calcul {
	public static int calculAge(Date dateNaissance) {
	     Date currentDate = new Date();
	   if (dateNaissance.before(currentDate)) {
	   
	    Period age = new Period(dateNaissance.getTime(), currentDate.getTime());
	    return age.getYears();
	   } else {
	    return 0;
	   }
	  }
	
	public static String calculPoints(double pts,int currentAnnee,Licencie calcul) {
		   
		  String result=null;
		  int yearLicence=(currentAnnee-calcul.getAnneeLicence());
		  if(yearLicence==0){
		  double FFV=calcul.getPointsFFV();
		  double r=new Double(FFV+pts);
		  result=String.valueOf(r);
		  }else
		  result="Licence expirée, MAJ impossible";
		  
		  
		  
		  return result;

		 }
}
