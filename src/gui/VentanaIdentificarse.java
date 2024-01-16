package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainCine;

public class VentanaIdentificarse extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JFrame ventanaIdentificacion, ventanaPricipal;
	protected JButton iniciarSesion, registrarse, volver;
	protected JLabel labelLogo;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());

	public VentanaIdentificarse(JFrame ventanaPricipal) {
		iniciarSesion = new JButton("Iniciar Sesion");
		registrarse = new JButton("Registrarse");
		volver = new JButton("Volver");
		ventanaIdentificacion = this;

		iniciarSesion.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN INICIAR SESIÓN");
			setVisible(false);
			new VentanaIniciarSesion(ventanaIdentificacion, ventanaPricipal);
		});
		registrarse.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN REGISTRARSE");
			setVisible(false);
			new VentanaRegistro(ventanaIdentificacion, ventanaPricipal);
		});
		volver.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN VOLVER");
			setVisible(false);
			ventanaPricipal.setVisible(true);
		});

		JPanel panelBotonesAcciones = new JPanel();
		JPanel panelLogo = new JPanel();

		ImageIcon icono = new ImageIcon("images/deustocinelogo2.png");
		Image imagen = icono.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
		labelLogo = new JLabel(new ImageIcon(imagen));

		add(panelBotonesAcciones, BorderLayout.NORTH);
		add(panelLogo, BorderLayout.CENTER);
		panelBotonesAcciones.add(registrarse);
		panelBotonesAcciones.add(iniciarSesion);
		panelBotonesAcciones.add(volver);
		panelLogo.add(labelLogo);

		setVisible(true);
		setTitle("DeustoCine");
		pack();
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(VentanaPricipalNueva.EXIT_ON_CLOSE);
		setResizable(false);

	}
}
