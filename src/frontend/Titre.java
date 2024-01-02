package frontend;

import general.Init;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class Titre extends JTextArea{
	
	public int x, y;

	public Titre(String name, int x, int y, int width, int height){
		super(name);
		this.setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setFont(new Font("Helvetica", Font.BOLD, 30));
	}
}