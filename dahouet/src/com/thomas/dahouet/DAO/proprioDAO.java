package com.thomas.dahouet.DAO;

import java.sql.Connection;
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
				Proprietaire proprio = new Proprietaire(null, null, null, null, null);
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
}
