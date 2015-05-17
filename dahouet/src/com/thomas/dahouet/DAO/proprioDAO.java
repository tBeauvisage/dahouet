package com.thomas.dahouet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.thomas.dahouet.model.Club;
import com.thomas.dahouet.model.Proprietaire;

public class proprioDAO {
	private static Connection c;

	public static ArrayList<Proprietaire> getProprio() {

		c = Connect.cConnect();

		ArrayList<Proprietaire> proprioList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select * from personne inner join proprietaire on personne.ID_PERSONNE=proprietaire.NUM_PROPR";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				int id =rs.getInt("ID_PERSONNE");
				String nom = new String(rs.getString("NOM_PERSONNE"));
				String prenom = new String(rs.getString("PRENOM_PERS"));
				String mail = new String(rs.getString("MAIL"));
				long tel = rs.getLong("TEL_PROPR");
				String adresse = rs.getString("ADRESSE_PROPR");
				Proprietaire proprio = new Proprietaire(id,nom, mail, prenom, tel, adresse);
				
				
			proprioList.add(proprio);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return proprioList;

	}
	
	public static ArrayList<Club> getClub() {

		c = Connect.cConnect();

		ArrayList<Club> clubList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select * from club";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				
				int id = rs.getInt("NUM_CLUB");
				String nom = new String(rs.getString("NOM_CLUB"));
				Club club = new Club(id,nom);
				clubList.add(club);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clubList;

	}
	
	
	
public static void newProprio(Proprietaire proprio, Club club){
	 
	Connection c = Connect.cConnect();
	int numProprio = 0;
	 PreparedStatement stm;
	  try {
	   stm = c.prepareStatement("insert into personne(NOM_PERSONNE,PRENOM_PERS,MAIL) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
	   stm.setString(1, proprio.getNom());
	   stm.setString(2, proprio.getPrenom());
	   stm.setString(3, proprio.getMail());
	   stm.executeUpdate();
	   
	   ResultSet rs = stm.getGeneratedKeys();
	   rs.next();
	   numProprio = rs.getInt(1);
	   stm = c.prepareStatement("insert into proprietaire(NUM_PROPR,NUM_CLUB,ADRESSE_PROPR,TEL_PROPR) VALUES(?,?,?,?)");
	   stm.setInt(1, numProprio);
	   stm.setInt(2, club.getIdClub());
	   stm.setString(3, proprio.getAdresse());
	   stm.setLong(4, proprio.getTelephone());
	   stm.executeUpdate();
	   
	   stm.close();
	   
	   
	  } catch (SQLException e) {
	   e.printStackTrace();
	   throw new RuntimeException();
	  } 
	  
	  
}
public static int getNumProprio(Proprietaire proprio) {
	c = Connect.cConnect();
	String nomProprio = proprio.getNom();
	int numproprio = 0;
	Statement stm;

	try {
		stm = c.createStatement();

		String sql = "select ID_PERSONNE from personne where NOM_PERSONNE ='" + nomProprio + "'";
		ResultSet rs = stm.executeQuery(sql);
		rs.next();
		numproprio = rs.getInt("ID_PERSONNE");

		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return numproprio;
}
}
