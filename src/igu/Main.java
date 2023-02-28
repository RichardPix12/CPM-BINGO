package igu;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import logica.play.Bingo;
import logica.play.Clientes;
import logica.play.Premios;
import logica.play.Tickets;


public class Main {

	/**
	 * Metodo main que lanza la aplicacion
	 */
	public static void main(String[] args) {
		Bingo bingo = new Bingo();
		Tickets tickets = new Tickets();
		Premios premios = new Premios();
		Clientes clientes = new Clientes();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(bingo, tickets, premios, clientes);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
