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

			String sql = "select personne.NOM_PERSONNE from personne inner join proprietaire on personne.ID_PERSONNE=proprietaire.NUM_PROPR";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Proprietaire proprio = new Proprietaire(null, null, null, 0, null);
				String s = new String(rs.getString("NOM_PERSONNE"));
				proprio.setNom(s);;
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

			String sql = "select club.NOM_CLUB from club";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Club club = new Club(null);
				String s = new String(rs.getString("NOM_CLUB"));
				club.setNomClub(s);
				clubList.add(club);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clubList;

	}
	public static int getNumClub(Club club){
		c = Connect.cConnect();
		String nomClub = club.getNomClub();
		int numSerie = 0;
		
		
		Statement stm;
		
		try {
			stm = c.createStatement();

			String sql = "select NUM_CLUB from club where NOM_CLUB ='"+nomClub+"'";
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			numSerie=rs.getInt("NUM_CLUB");
			
			rs.close();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numSerie;
	}
	
	
public static void newProprio(Proprietaire proprio, int numClub){
	 
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
	   stm.setInt(2, numClub);
	   stm.setString(3, proprio.getAdresse());
	   stm.setLong(4, proprio.getTelephone());
	   stm.executeUpdate();
	   
	   stm.close();
	   
	   
	  } catch (SQLException e) {
	   e.printStackTrace();
	   throw new RuntimeException();
	  } 
	  
	  
}
}
