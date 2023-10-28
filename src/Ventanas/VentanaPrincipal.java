package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {
	protected JFrame ventanaPrincipal;
	protected JButton iniciarSesion, registrarse;
	protected JLabel labelLogo;

	public VentanaPrincipal() {
		iniciarSesion = new JButton("Iniciar Sesion");
		registrarse = new JButton("Registrarse");
		ventanaPrincipal = this;

		/*
		 * Con absolute layout no se anade el segundo bottonn de momento ponemos un flow
		 * layout para que sea funcional iniciarSesion.setBounds(825, 200, 122, 38);
		 * registrarse.setBounds(825, 110, 122, 38);
		 */

		iniciarSesion.addActionListener((e) -> {
			setVisible(false);
			new VentanaIniciarSesion(ventanaPrincipal);
		});
		registrarse.addActionListener((e) -> {

		});

		labelLogo = new JLabel(new ImageIcon("deustocinelogo.png"));
		
		add(iniciarSesion);
		add(registrarse);
		setVisible(true);
		setTitle("DeustoCine");
		add(labelLogo, BorderLayout.SOUTH);
		pack();
		setBounds(100, 100, 1200, 800);
		setLayout(new FlowLayout()); // En el futuro lo pondremos null y lo pondremos manualmente
		setLocationRelativeTo(null);
		setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);

	}

}
