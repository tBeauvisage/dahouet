package com.thomas.dahouet.model;

import com.thomas.dahouet.GUI.Navire;
import com.thomas.dahouet.GUI.NewProprio;
import com.thomas.dahouet.utils.Affichage;
import com.thomas.dahouet.utils.Controls;

public class Test_mail {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Affichage.afficheLicencie();
		Affichage.afficheProprio();
		Affichage.afficheCommissaire();
		Navire navire = new Navire();
		navire.setVisible(true);
		NewProprio prop = new NewProprio();
		prop.setVisible(true);
	}
	

		}
 

