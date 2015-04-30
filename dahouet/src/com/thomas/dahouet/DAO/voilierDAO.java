package com.thomas.dahouet.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class voilierDAO {
	private static Connection c;

	public static ArrayList<String> getSerie() {

		c = Connect.cConnect();

		ArrayList<String> serieList = new ArrayList<>();
		// test avec select
		Statement stm;
		try {
			stm = c.createStatement();

			String sql = "select distinct serie from voilier";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				String s = new String(rs.getString("SERIE"));

				serieList.add(s);
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
