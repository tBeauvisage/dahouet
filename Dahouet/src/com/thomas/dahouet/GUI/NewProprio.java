package com.thomas.dahouet.GUI;

import java.awt.Toolkit;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class NewProprio extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public NewProprio() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 578);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		ImagePanel imagePanel = new ImagePanel(Toolkit.getDefaultToolkit().getImage(NavireFrml.class.getResource("/ressources/assurance-voilier.jpg")));

		getContentPane().add(imagePanel, "cell 0 0,grow");
		imagePanel.setLayout(new MigLayout("", "[114px][][][][][][grow][][grow][][][][grow][][][][][][][][][][grow]", "[20px][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		imagePanel.add(textField, "cell 6 0 6 1,growx");
		textField.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut, "cell 6 1");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_1, "cell 6 2");
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_2, "cell 6 3");
		
		JLabel lblNewLabel_1 = new JLabel("Adresse");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_1, "cell 0 4");
		
		textField_1 = new JTextField();
		imagePanel.add(textField_1, "cell 6 4 6 1,growx");
		textField_1.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_3, "cell 6 5");
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_4, "cell 6 6");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_5, "cell 6 7");
		
		JLabel lblNewLabel_2 = new JLabel("Telephone");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_2, "cell 0 8");
		
		textField_2 = new JTextField();
		imagePanel.add(textField_2, "cell 6 8 6 1,growx");
		textField_2.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_6, "cell 6 9");
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_7, "cell 6 10");
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_8, "cell 6 11");
		
		JLabel lblNewLabel_3 = new JLabel("Club");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_3, "cell 0 12");
		
		JComboBox comboBox = new JComboBox();
		imagePanel.add(comboBox, "cell 6 12 6 1,growx");
		
		Component verticalStrut_13 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_13, "cell 7 13");
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_9, "cell 7 14");
		
		Component verticalStrut_10 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_10, "cell 7 15");
		
		Component verticalStrut_11 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_11, "cell 7 16");
		
		Component verticalStrut_12 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_12, "cell 7 17");
		
		Component verticalStrut_14 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_14, "cell 7 18");
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		imagePanel.add(btnNewButton, "cell 5 20");
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		imagePanel.add(btnNewButton_1, "cell 12 20");
	}
}
