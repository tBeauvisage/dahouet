package com.thomas.dahouet.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.thomas.dahouet.GUI.ImagePanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Navire extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public Navire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 578);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		ImagePanel imagePanel = new ImagePanel(Toolkit.getDefaultToolkit().getImage(Navire.class.getResource("/ressources/assurance-voilier.jpg")));

		getContentPane().add(imagePanel, "cell 0 0,grow");
		imagePanel.setLayout(new MigLayout("", "[114px][][][][][][][][grow][][][][grow][][][][][][][][][][grow]", "[20px][][][][][][][][][][][][][]"));
		
		JLabel lblNomVoilier = new JLabel("Nom Voilier");
		lblNomVoilier.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNomVoilier, "cell 0 1");
		
		JComboBox comboBox = new JComboBox();
		imagePanel.add(comboBox, "cell 8 1 10 1,growx");
		
		JLabel lblNewLabel = new JLabel("Nom Propri\u00E9taire");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel, "cell 0 4 3 1");
		
		JComboBox comboBox_1 = new JComboBox();
		imagePanel.add(comboBox_1, "cell 8 4 10 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("S\u00E9rie");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_1, "cell 0 7");
		
		JComboBox comboBox_2 = new JComboBox();
		imagePanel.add(comboBox_2, "cell 8 7 10 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Classe");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_2, "cell 0 10");
		
		JComboBox comboBox_3 = new JComboBox();
		imagePanel.add(comboBox_3, "cell 8 10 10 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Coefficient");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_3, "cell 0 13");
		
		textField = new JTextField();
		imagePanel.add(textField, "cell 8 13 2 1,growx");
		textField.setColumns(10);
	}

}
