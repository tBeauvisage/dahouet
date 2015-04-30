package com.thomas.dahouet.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	public ImagePanel(Image image){
	this.image = image;
	

	}
@Override
protected void paintComponent(Graphics g){
super.paintComponent(g);
g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
}
	
}
