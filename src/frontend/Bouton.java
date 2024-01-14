package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

import general.Init;

import java.awt.Font;

public class Bouton extends JButton{
	
	public int x, y;

	public Bouton(String name, int x, int y, int width, int height){
		super(name);
		this.setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.setForeground(Init.couleurtextbouton);
		this.setBackground(Init.couleurfondbouton);
		this.setFont(new Font("Helvetica", Font.BOLD, 20));
	}

	public Bouton(String name, int x, int y, int width, int height, int fontsize){
		super(name);
		this.setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.setForeground(Init.couleurtextbouton);
		this.setBackground(Init.couleurfondbouton);
		this.setFont(new Font("Helvetica", Font.BOLD, fontsize));
	}
}