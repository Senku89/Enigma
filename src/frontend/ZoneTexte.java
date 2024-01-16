package frontend;

import general.Init;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextArea;

public class ZoneTexte extends JTextArea{
	public int x, y;
	public ZoneTexte(String name, int x, int y, int width, int height){
		super(name);
		this.setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.setForeground(Color.BLACK);
		this.setBackground(Init.couleurfondzonetext);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		this.setFont(new Font("Helvetica", Font.BOLD, 15));
		this.setEditable(false);
	};
}