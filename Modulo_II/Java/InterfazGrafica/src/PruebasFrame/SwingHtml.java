package PruebasFrame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingHtml {

public static void main(String[] args) {
		
		String Filename = "appWeb.jpg";
		String HTMLlabel = "<html>texto negro " +
				"<font color=#ff0000>" +
				"texto rojo</font></html>";
		
		JFrame frame = new JFrame("Mi Primer Frame Modificado");
		Image image = (new ImageIcon(Filename)).getImage();
		frame.setIconImage(image);
		frame.setResizable(false);
		frame.setSize(100, 100);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel(HTMLlabel);
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
