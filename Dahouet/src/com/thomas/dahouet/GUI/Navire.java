package com.thomas.dahouet.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.thomas.dahouet.GUI.ImagePanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import java.awt.Image;
import java.awt.Toolkit;

public class Navire extends JFrame {

	private JPanel contentPane;

	
	public Navire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 578);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		ImagePanel imagePanel = new ImagePanel(Toolkit.getDefaultToolkit().getImage(Navire.class.getResource("/ressources/assurance-voilier.jpg")));

		getContentPane().add(imagePanel, "cell 0 0,grow");
		imagePanel.setLayout(new MigLayout("", "[114px][][][][][][][]", "[20px][][]"));
	}

}
