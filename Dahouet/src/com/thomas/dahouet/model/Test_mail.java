package com.thomas.dahouet.model;

import com.thomas.dahouet.utils.Controls;

public class Test_mail {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personne test = new Personne("toto", "totogmail.com", "lolo");
		String mail = test.getMail();
		String message = Controls.ctMail(mail);
		System.out.println(message);
	}
	

		}
 

