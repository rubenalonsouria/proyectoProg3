package gui;

import java.awt.FlowLayout;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.MainCine;

public class VentanaMetodoDePago extends JFrame{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	private JComboBox<String> comboOpciones;
	private JPanel panelPaypal, panelBizum, panelPagoEnCine, panelTarjeta;
	
	public VentanaMetodoDePago() {
		setLayout(new FlowLayout());
		//Combobox
		String[] metodosAceptados = {"Tarjeta", "Bizum","PayPal", "Pago en cine"};
		comboOpciones = new JComboBox<String>(metodosAceptados);
		add(comboOpciones);
		
		//Paneles metodo de Pago
		//PayPal
		panelPaypal = new JPanel();
		
		//Bizum
		panelBizum = new JPanel();
		
		//Pago en Cine
		panelPagoEnCine = new JPanel();
		
		//Tarjeta
		panelTarjeta = new JPanel();
		
		
		
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Metodo De Pago");
	}
	
	

}
