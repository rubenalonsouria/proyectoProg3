package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaPrincipalTesting {

	private JFrame frmDeustocine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalTesting window = new VentanaPrincipalTesting();
					window.frmDeustocine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipalTesting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeustocine = new JFrame();
		frmDeustocine.setResizable(false);
		frmDeustocine.setTitle("DeustoCine");
		frmDeustocine.setBounds(100, 100, 974, 484);
		frmDeustocine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeustocine.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(138, 317, 89, 23);
		frmDeustocine.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(749, 317, 89, 23);
		frmDeustocine.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(271, 60, 352, 116);
		frmDeustocine.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
