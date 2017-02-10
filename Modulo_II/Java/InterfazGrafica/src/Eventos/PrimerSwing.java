package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrimerSwing {
	
	private static void mostrarVentana() {
		JFrame frame = new JFrame("Primer ventana");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello world");
		frame.getContentPane().add(label);
		frame.setSize(300, 300);
		JButton boton = new JButton("Haz click");
		frame.getContentPane().add(boton);
		frame.setVisible(true);
		boton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				JButton boton=(JButton) ae.getSource();
				boton.setText("he cambiado");
			}
		});
	}
	
	public static void main(String[] args) {
		mostrarVentana();
	}
}