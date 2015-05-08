package com.thomas.dahouet.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thomas.dahouet.model.Serie;

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
	
	public static ArrayList<String> getClasse(String serie){
		c = Connect.cConnect();

		ArrayList<String> serieClasse = new ArrayList<>();
		// test avec select
		Statement stm;
		
		
			try {
				stm=c.createStatement();
				String sql = "select distinct classe from voilier where serie='"+serie+"'";
				ResultSet rs = stm.executeQuery(sql);

				while (rs.next()) {
					String c = new String(rs.getString("CLASSE"));

					serieClasse.add(c);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return serieClasse;
	}
}
