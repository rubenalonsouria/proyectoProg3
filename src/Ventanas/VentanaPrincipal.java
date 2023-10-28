package Ventanas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	protected JFrame ventanaPrincipal;
	protected JButton iniciarSesion, registrarse;

	public VentanaPrincipal() {
		iniciarSesion = new JButton("Iniciar Sesion");
		registrarse = new JButton("Registrarse");
		ventanaPrincipal = this;

		/*
		 * Con absolute layout no se anade el segundo bottonn de momento ponemos un flow
		 * layot para qeu sea funcional iniciarSesion.setBounds(825, 200, 122, 38);
		 * registrarse.setBounds(825, 110, 122, 38);
		 */

		iniciarSesion.addActionListener((e) -> {
			setVisible(false);
			new VentanaIniciarSesion(ventanaPrincipal);
		});
		registrarse.addActionListener((e) -> {

		});

		add(iniciarSesion);
		add(registrarse);
		setVisible(true);
		setBounds(100, 100, 1200, 800);
		setLayout(new FlowLayout()); // En el futuro lo pondremos null y lo pondremos manualmente
		setLocationRelativeTo(null);
		setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);

	}

}
