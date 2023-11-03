package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrincipalAdminTesting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel a;
	private JTextField txtMirarQueMas;
	private JTextField txtTerminarDeHacer;
	
/*
 * mirar que mas usos tiene el admin, o bien que sea la misma ventana qeu la del cliente y tenga permisos de editar
 */
	public VentanaPrincipalAdminTesting() {
		
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 418);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
			
		txtTerminarDeHacer = new JTextField();
		txtTerminarDeHacer.setText("Terminar de hacer y poner para que vea estadisticas");
		txtTerminarDeHacer.setColumns(30);
		txtMirarQueMas.setColumns(30);
		add(txtTerminarDeHacer);
		setVisible(true);
	}

}
