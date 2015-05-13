package com.thomas.dahouet.GUI;

import com.thomas.dahouet.GUI.ImagePanel;
import com.thomas.dahouet.model.Classe;
import com.thomas.dahouet.model.Proprietaire;
import com.thomas.dahouet.model.Serie;
import com.thomas.dahouet.model.Voilier;
import com.thomas.dahouhouet.controller.Controller;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class NavireFrml extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<Proprietaire> comboBox_3;
	private JComboBox<Serie> comboBox_1;
	private JComboBox<Classe> comboBox_2;
	private JButton btnNewButton_2;
	private JButton btnNewButton;

	public NavireFrml() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 578);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		Controller control = new Controller();
		ImagePanel imagePanel = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(NavireFrml.class.getResource("/ressources/assurance-voilier.jpg")));

		getContentPane().add(imagePanel, "cell 0 0,grow");
		imagePanel.setLayout(new MigLayout("", "[114px][][][][][][][][grow][][][][grow][grow][][][][][][][][][][grow]",
				"[20px][][][][][][][][][][][][][][][][][][][][]"));

		JLabel lblNomVoilier = new JLabel("Nom Voilier");
		lblNomVoilier.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNomVoilier, "cell 0 1");

		textField_1 = new JTextField();
		imagePanel.add(textField_1, "cell 8 1 11 1,growx");
		textField_1.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut, "cell 9 2 1 2");

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_1, "cell 9 4");

		JLabel lblNewLabel = new JLabel("Nom Propri\u00E9taire");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel, "cell 0 5 3 1");

		comboBox_3 = new JComboBox<Proprietaire>();
		imagePanel.add(comboBox_3, "cell 8 5 11 1,growx");
		comboBox_3.removeAllItems();
		ArrayList<Proprietaire> listProprio = control.proprioInit();

		for (Proprietaire proprio : listProprio) {
			comboBox_3.addItem(proprio);
		}

			btnNewButton_2 = new JButton("Nouveau");
			btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
			imagePanel.add(btnNewButton_2, "cell 21 5");
			btnNewButton_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					control.initNewProprio();
					dispose();
					
				}
			});

			Component verticalStrut_2 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_2, "cell 9 6");

			Component verticalStrut_3 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_3, "cell 9 7");

			JLabel lblNewLabel_1 = new JLabel("S\u00E9rie");
			lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
			imagePanel.add(lblNewLabel_1, "cell 0 8");

			comboBox_1 = new JComboBox<Serie>();
			imagePanel.add(comboBox_1, "cell 8 8 11 1,growx");
			comboBox_1.removeAllItems();
			ArrayList<Serie> listSerie = control.serieInit();

			for (Serie serie : listSerie) {
				
				comboBox_1.addItem(serie);
			}
			comboBox_1.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					comboBox_2.removeAllItems();
					Serie serie = (Serie) comboBox_1.getSelectedItem();
					ArrayList<Classe> listClasse = control.classeInit(serie);
					for (Classe classe : listClasse) {
						

						comboBox_2.addItem(classe);

					}
				}
			});

			Component verticalStrut_4 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_4, "cell 9 9");

			Component verticalStrut_5 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_5, "cell 9 10");

			JLabel lblNewLabel_2 = new JLabel("Classe");
			lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
			imagePanel.add(lblNewLabel_2, "cell 0 11");

			comboBox_2 = new JComboBox<Classe>();
			imagePanel.add(comboBox_2, "cell 8 11 11 1,growx");
			comboBox_2.removeAllItems();
			Serie serie = (Serie) comboBox_1.getSelectedItem();
			ArrayList<Classe> listClasse = control.classeInit(serie);
			for (Classe classe : listClasse) {
				

				comboBox_2.addItem(classe);

			}

			Component verticalStrut_6 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_6, "cell 9 12");

			Component verticalStrut_7 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_7, "cell 9 13");

			JLabel lblNewLabel_3 = new JLabel("Coefficient");
			lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 13));
			imagePanel.add(lblNewLabel_3, "cell 0 14");

			textField = new JTextField();
			imagePanel.add(textField, "cell 8 14 2 1,growx");
			textField.setColumns(10);

			Component verticalStrut_8 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_8, "cell 8 15");

			Component verticalStrut_9 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_9, "cell 8 16");

			Component verticalStrut_10 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_10, "cell 8 17");

			Component verticalStrut_11 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_11, "cell 8 18");

			Component verticalStrut_12 = Box.createVerticalStrut(20);
			imagePanel.add(verticalStrut_12, "cell 8 19");

			btnNewButton = new JButton("OK");
			btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
			imagePanel.add(btnNewButton, "cell 6 20");
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				Voilier voilier = new Voilier(textField_1.getText(), Double.parseDouble(textField.getText()));
				Classe classe =(Classe) comboBox_2.getSelectedItem();
				Proprietaire proprio = (Proprietaire) comboBox_3.getSelectedItem();
				control.createVoilier(voilier, classe, proprio);
					
				}
			});
			

			JButton btnNewButton_1 = new JButton("Quitter");
			btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
			imagePanel.add(btnNewButton_1, "cell 13 20");
		}
	

	public String stringSerie() {
		return (String) this.comboBox_1.getSelectedItem();
	}
}

