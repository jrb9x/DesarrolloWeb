package PruebasFrame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Componentes {
	
public static void main(String[] args) {
		
		String Filename = "appWeb.jpg";
		JButton jbtOK = new JButton("OK");
		
		JFrame frame = new JFrame("Mi Primer Frame Modificado");
		Image image = (new ImageIcon(Filename)).getImage();
		frame.setIconImage(image);
		frame.setResizable(false);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		System.out.println(jbtOK instanceof JButton);
		System.out.println(jbtOK instanceof AbstractButton);
		System.out.println(jbtOK instanceof JComponent);
		System.out.println(jbtOK instanceof Container);
		System.out.println(jbtOK instanceof Component);
		System.out.println(jbtOK instanceof Object);
	}
	
}
