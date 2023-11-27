package gui;

import java.util.logging.Logger;

import javax.swing.JFrame;

import main.MainCine;

public class VentanaMetodoDePago extends JFrame{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	
	public VentanaMetodoDePago() {
		
		
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Metodo De Pago");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
