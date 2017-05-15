package controller;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Yang_founction_fenetre {
	
	public static void setBasicStyleForFenetre(JPanel c){
		c.setLayout(null);
		c.setBackground(Color.lightGray);
		c.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

}