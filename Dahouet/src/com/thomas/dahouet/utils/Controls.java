package com.thomas.dahouet.utils;

public class Controls {
	public static String ctMail(String email) {

//		String testDot = null;
//		String testAdr = null;
//		String testDomaine = null;
//		String testTld = null;
		
		
		String result = "mail conforme";

//		if (email.contains("@")) {
//
//		} else {
//	     result = "votre adresse doit contenir un @";
//		}
//		if (result!=null){
//			return result;
//		}
//		testDot = email.substring(email.indexOf("@"));
//		if (testDot.contains(".")) {
//
//		} else {
//			result = "votre adresse doit contenir un point aprés le @";
//		}
//		if (result!=null){
//			return result;
//			}
//		testAdr = email.substring(0, email.indexOf("@"));
//		if (testAdr.length() >= 2 ) {
//		} else {
//			result = "votre adresse doit contenir au moins deux caractères avant le @";
//		}
//		if (result!=null){
//			return result;}
//		testDomaine = email.substring(email.indexOf("@"), email.lastIndexOf("."));
//		if (testDomaine.length() >= 2) {
//
//		} else {
//			result = "votre adresse doit contenir au moins deux caractères entre le @ et le point";
//		}
//		testTld = email.substring(email.lastIndexOf("."));
//		if (testTld.length() >= 3) {
//
//		} else {
//			result = "votre adresse doit contenir au moins deux caractères aprés le point";
//		}
		if (email.matches("^[a-zA-Z0-9._-]{2,}+@[a-zA-Z0-9._-]{2,}\\.[a-z]{2,4}$"));
		   
		   else
		   { result="Adresse mail invalide"; }
		return result;

	}
	
}
