package gui;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaPrincipalTesting {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

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
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 963, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setActionCommand("");
		btnNewButton.addActionListener((e) -> {
			frame.setVisible(false);
			
		});
		btnNewButton.setBounds(815, 24, 122, 46);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addActionListener((e) -> {

		});
		btnNewButton_1.setBounds(815, 91, 122, 38);
		frame.getContentPane().add(btnNewButton_1);
	}
}
