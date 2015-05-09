package com.thomas.dahouet.GUI;

import java.awt.Toolkit;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;

import com.thomas.dahouet.model.Club;
import com.thomas.dahouet.model.Proprietaire;
import com.thomas.dahouhouet.controller.Controller;

public class NewProprio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JComboBox<String> comboBox;

	public NewProprio() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 578);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		Controller control = new Controller();
		ImagePanel imagePanel = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(NavireFrml.class.getResource("/ressources/assurance-voilier.jpg")));

		getContentPane().add(imagePanel, "cell 0 0,grow");
		imagePanel.setLayout(new MigLayout("", "[114px][][][][][][grow][grow][grow][][grow][grow][grow][][][grow][][][][][][][][][][grow]", "[20px][][][][][][][][][][][][][][][][][][][][]"));

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_8, "cell 8 1");

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_9, "cell 8 2");

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblPrenom, "cell 0 3");

		textField_3 = new JTextField();
		imagePanel.add(textField_3, "cell 6 3 9 1,growx");
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((!textField.getText().equals("")) && (!textField_1.getText().equals("")) && (!textField_2.getText().equals(""))&& (!textField_3.getText().equals(""))) {
					btnNewButton.setEnabled(true);
				} else {
					btnNewButton.setEnabled(false);
				}

			}
		});

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_4, "cell 8 4");

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_3, "cell 8 5");

		JLabel lblNewLabel_1 = new JLabel("Adresse");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_1, "cell 0 6");

		textField_1 = new JTextField();
		imagePanel.add(textField_1, "cell 6 6 9 1,growx");
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((!textField.getText().equals("")) && (!textField_1.getText().equals("")) && (!textField_2.getText().equals(""))
						&& (!textField_3.getText().equals(""))&& (!textField_4.getText().equals(""))) {
					btnNewButton.setEnabled(true);
				} else {
					btnNewButton.setEnabled(false);
				}

			}
		});

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_7, "cell 8 7");

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_6, "cell 8 8");

		JLabel lblNewLabel_2 = new JLabel("Telephone");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_2, "cell 0 9");

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		imagePanel.add(textField_2, "cell 6 9 9 1,growx");
		textField_2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((!textField.getText().equals("")) && (!textField_1.getText().equals("")) && (!textField_2.getText().equals(""))
						&& (!textField_3.getText().equals(""))&& (!textField_4.getText().equals(""))) {
					btnNewButton.setEnabled(true);
				} else {
					btnNewButton.setEnabled(false);
				}

			}
		});

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_2, "cell 8 10");

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_1, "cell 8 11");

		JLabel lblNewLabel_3 = new JLabel("Club");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_3, "cell 0 12");

		comboBox = new JComboBox<String>();
		imagePanel.add(comboBox, "cell 6 12 9 1,growx");
		ArrayList<Club> listClub = control.clubInit();

		for (Club club : listClub) {
			String nomClub = club.getNomClub();
			comboBox.addItem(nomClub);
		}

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_10, "cell 8 13");

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_11, "cell 8 14");
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblMail, "cell 0 15");
		
		textField_4 = new JTextField();
		imagePanel.add(textField_4, "cell 6 15 9 1,growx");
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {if ((!textField.getText().equals("")) && (!textField_1.getText().equals("")) && (!textField_2.getText().equals(""))
					&& (!textField_3.getText().equals(""))&& (!textField_4.getText().equals(""))) {
				btnNewButton.setEnabled(true);
			} else {
				btnNewButton.setEnabled(false);
			}

		}
	});

		Component verticalStrut_14 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_14, "cell 8 16");

		Component verticalStrut = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut, "cell 8 17");

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_5, "cell 8 18");

		btnNewButton = new JButton("Ok");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		imagePanel.add(btnNewButton, "cell 5 20");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Proprietaire proprio = new Proprietaire(textField.getText(), textField_4.getText(), textField_3.getText(), Long.parseLong(textField_2.getText()), textField_1.getText());
				String nomClub = (String) comboBox.getSelectedItem();
				Club club = new Club(nomClub);
			control.createProprio(proprio,club);
				

			}
		});

		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel, "cell 0 0");

		textField = new JTextField();
		imagePanel.add(textField, "cell 6 0 9 1,growx");
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((!textField.getText().equals("")) && (!textField_1.getText().equals("")) && (!textField_2.getText().equals(""))
						&& (!textField_3.getText().equals(""))&& (!textField_4.getText().equals(""))) {
					btnNewButton.setEnabled(true);
				} else {
					btnNewButton.setEnabled(false);
				}

			}
		});
		

		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		imagePanel.add(btnNewButton_1, "cell 15 20");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				control.initNavireFrml();
				dispose();

			}
		});

	}

}
