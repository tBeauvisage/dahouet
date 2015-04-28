package com.thomas.dahouet.GUI;

import com.thomas.dahouet.GUI.ImagePanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class Navire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	
	public Navire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 578);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		ImagePanel imagePanel = new ImagePanel(Toolkit.getDefaultToolkit().getImage(Navire.class.getResource("/ressources/assurance-voilier.jpg")));

		getContentPane().add(imagePanel, "cell 0 0,grow");
		imagePanel.setLayout(new MigLayout("", "[114px][][][][][][][][grow][][][][grow][][][][][][][][][][][grow]", "[20px][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNomVoilier = new JLabel("Nom Voilier");
		lblNomVoilier.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNomVoilier, "cell 0 1");
		
		JComboBox comboBox = new JComboBox();
		imagePanel.add(comboBox, "cell 8 1 11 1,growx");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut, "cell 9 2 1 2");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_1, "cell 9 4");
		
		JLabel lblNewLabel = new JLabel("Nom Propri\u00E9taire");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel, "cell 0 5 3 1");
		
		JComboBox comboBox_1 = new JComboBox();
		imagePanel.add(comboBox_1, "cell 8 5 11 1,growx");
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_2, "cell 9 6");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_3, "cell 9 7");
		
		JLabel lblNewLabel_1 = new JLabel("S\u00E9rie");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_1, "cell 0 8");
		
		JComboBox comboBox_2 = new JComboBox();
		imagePanel.add(comboBox_2, "cell 8 8 11 1,growx");
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_4, "cell 9 9");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		imagePanel.add(verticalStrut_5, "cell 9 10");
		
		JLabel lblNewLabel_2 = new JLabel("Classe");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		imagePanel.add(lblNewLabel_2, "cell 0 11");
		
		JComboBox comboBox_3 = new JComboBox();
		imagePanel.add(comboBox_3, "cell 8 11 11 1,growx");
		
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
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		imagePanel.add(btnNewButton, "cell 6 20");
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		imagePanel.add(btnNewButton_1, "cell 13 20");
	}

}
