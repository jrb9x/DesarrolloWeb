package PruebasFrame;

import java.awt.Image;

import javax.swing.*;

public class PruebasFrame {
	
	public static void main(String[] args) {
		
		String Filename = "appWeb.jpg";
		
		JFrame frame = new JFrame("Mi Primer Frame Modificado");
		Image image = (new ImageIcon(Filename)).getImage();
		frame.setIconImage(image);
		frame.setResizable(false);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
