package com.thomas.dahouet.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import net.miginfocom.swing.MigLayout;

public class Navire extends JFrame {

	private JPanel contentPane;

	
	public Navire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px]", "[251px]"));
		
		ImagePanel imagePanel = new ImagePanel((Image) null);
		contentPane.add(imagePanel, "cell 0 0,grow");
	}

}
