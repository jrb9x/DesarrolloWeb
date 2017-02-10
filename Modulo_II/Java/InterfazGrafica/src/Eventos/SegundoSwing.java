package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SegundoSwing implements ActionListener{

	@SuppressWarnings("unused")
	private static int numero_clicks = 0;
	
	private static void mostrarVentana() {
		JFrame frame = new JFrame("Nuestra primera ventana");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton boton = new JButton("Comienza a dar click!");
		frame.getContentPane().add(boton);
		frame.setVisible(true);
		//boton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		JButton boton=(JButton) ae.getSource();
		boton.setText("he cambiado");
	}
	
	public static void main(String[] args) {
		mostrarVentana();
	}
}
