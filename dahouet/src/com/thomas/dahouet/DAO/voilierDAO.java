package com.thomas.dahouet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.thomas.dahouet.model.Classe;
import com.thomas.dahouet.model.Proprietaire;
import com.thomas.dahouet.model.Serie;
import com.thomas.dahouet.model.Voilier;

public class voilierDAO {
	private static Connection c;

	public static ArrayList<Serie> getSerie() {

		c = Connect.cConnect();

		ArrayList<Serie> serieList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select NOM_SERIE from serie";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Serie serie = new Serie(null);
				String s = new String(rs.getString("NOM_SERIE"));
				serie.setNomSerie(s);
				serieList.add(serie);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return serieList;

	}

	public static ArrayList<Classe> getClasse(Serie serie) {
		c = Connect.cConnect();
		String nomSerie = serie.getNomSerie();
		int numSerie = 0;
		ArrayList<Classe> classeList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select NUM_SERIE from serie where NOM_SERIE ='" + nomSerie + "'";
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			numSerie = rs.getInt("NUM_SERIE");

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stm = c.createStatement();

			String sql = "select classe.NOM_CLASSE from classe INNER join serie on serie.NUM_SERIE = classe.NUM_SERIE where serie.NUM_SERIE ='"
					+ numSerie + "'";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Classe classe = new Classe(nomSerie, null);
				String s = new String(rs.getString("NOM_CLASSE"));
				classe.setNomClasse(s);
				classeList.add(classe);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return classeList;
	}

	

	public static int getNumClasse(Classe classe) {
		c = Connect.cConnect();
		String nomClasse = classe.getNomClasse();
		int numClasse = 0;
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select NUM_CLASSE from classe where NOM_CLASSE ='" + nomClasse + "'";
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			numClasse = rs.getInt("NUM_CLASSE");

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numClasse;
	}
	public static void newVoilier(Voilier voilier,int numClasse, int numProprio){
		 
		Connection c = Connect.cConnect();
		
		 PreparedStatement stm;
		  try {
		   stm = c.prepareStatement("insert into voilier(NUM_CLASSE,NUM_PROPR,NOM_VOILE,COEFF) VALUES(?,?,?,?)");
		   stm.setInt(1, numClasse);
		   stm.setInt(2, numProprio);
		   stm.setString(3, voilier.getNom());
		   stm.setDouble(4, voilier.getCoef());
		   stm.executeUpdate();
		   stm.close();
		   
		   
		  } catch (SQLException e) {
		   e.printStackTrace();
		   throw new RuntimeException();
		  } 
		  
		  
	}
}
