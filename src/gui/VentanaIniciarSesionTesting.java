package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaIniciarSesionTesting {

	private JFrame ventanaInicioSesion,ventanaPricipal;
	private JTextField textField;
	private JTextField textField_1;
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public VentanaIniciarSesionTesting(JFrame ventanaAnterior) {
		ventanaInicioSesion = new JFrame();
		ventanaPricipal = ventanaAnterior;
		ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaInicioSesion.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Correo");
		ventanaInicioSesion.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		ventanaInicioSesion.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("contrasena");
		ventanaInicioSesion.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		ventanaInicioSesion.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("iniciar");
		ventanaInicioSesion.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		ventanaInicioSesion.getContentPane().add(btnNewButton_1);
		
//		btnNewButton_1.addActionListener(null);
		
		ventanaInicioSesion.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	

}
