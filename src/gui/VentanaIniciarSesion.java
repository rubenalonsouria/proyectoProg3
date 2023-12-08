package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Usuario;
import main.MainCine;

public class VentanaIniciarSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	private static boolean sesionIniciada = false;
	private JTextField textField; // Poner el nobre de cada componente con el que es
	private JLabel lblNewLabel, lblNewLabel_1;
	private JPasswordField password;
	private JButton btnNewButton, btnNewButton_1;
	private JCheckBox recuerdameButton;
	private static Cliente clienteIniciado = null;
	private static Administrador administradorIniciado = null;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	private static boolean esAdmin;

	public static boolean isSesionIniciada() {
		return sesionIniciada;
	}

	public static void setSesionIniciada(boolean b) {
		sesionIniciada = b;
	}

	public static Cliente clienteIniciado() {
		return clienteIniciado;
	}

	public static void setclienteIniciado(Cliente c) {
		clienteIniciado = c;
	}

	public static Administrador administradorIniciado() {
		return administradorIniciado;
	}

	public static void setadministradorIniciado(Administrador a) {
		administradorIniciado = a;
	}

	public static boolean isEsAdmin() {
		return esAdmin;
	}

	public static void setEsAdmin(boolean esAdmin) {
		VentanaIniciarSesion.esAdmin = esAdmin;
	}

	public VentanaIniciarSesion(JFrame ventanaAnterior, JFrame ventanaPrincipal) {

		lblNewLabel = new JLabel("Correo Electrónico:");
		lblNewLabel_1 = new JLabel("Contraseña:");
		textField = new JTextField("");
		password = new JPasswordField("");
		btnNewButton = new JButton("Iniciar");
		btnNewButton_1 = new JButton("Volver");
		recuerdameButton = new JCheckBox("Recuerdame", false);

		// Para cancelar y volver a la ventana principal
		btnNewButton_1.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN VOLVER");
			setVisible(false);
			ventanaAnterior.setVisible(true);
		});
		// Para iniciar Sesion
		btnNewButton.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN INICIAR SESIÓN");
			String contrasenaField = password.getText();
			String correoField = textField.getText();

			if (!MainCine.getMapaUsuarios().containsKey(correoField)) {
				JOptionPane.showMessageDialog(null, "Primero registrate", "ERROR", JOptionPane.WARNING_MESSAGE);

			} else {

				if (contrasenaField.equals(MainCine.getMapaUsuarios().get(correoField)[0])) {

					// Comprobacion si es admin
					if (MainCine.getMapaUsuarios().get(correoField)[1].equals("false")) {
						JOptionPane.showMessageDialog(null, "Inicio Sesion correcto", null,
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						setEsAdmin(false);
						ventanaPrincipal.setVisible(true);
						sesionIniciada = true;
						administradorIniciado = null; // para qeu no haya errores
						for (Cliente c : MainCine.getListaClientes()) {
							if (c.getCorreo().equals(correoField)) {
								clienteIniciado = c;
								break;
							}
						}

					} else {
						/*
						 * opcion de con un panel panelAdmin = new JPanel(new GridLayout(1,2));
						 * botonAdminNo = new JButton("No"); botonAdminSi = new JButton("Si");
						 * panelAdmin.add(botonAdminNo); panelAdmin.add(botonAdminSi);
						 */

						Object t = "Se ha detectado que eres administrador" + "\n"
								+ "Quieres iniciar Sesion como admin?";
						int respuesta = JOptionPane.showConfirmDialog(null, t);

						if (respuesta == 0) {
							VentanaPricipalNueva.botonAdminSuperior.setVisible(true);
							setVisible(false);
							ventanaPrincipal.setVisible(true);
							setEsAdmin(true);
							sesionIniciada = true;
							clienteIniciado = null; // para qeu no haya errores
							for (Administrador a : MainCine.getListaAdministradores()) {
								if (a.getCorreo().equals(correoField)) {
									administradorIniciado = a;
									break;
								}
							}
						} else if (respuesta == 1) {
							password.setText("");
							textField.setText("");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Contrasena incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		// Ventana
		JLabel lCabecera = new JLabel("Identificate con tus datos de inicio de sesión:");
		lCabecera.setForeground(Color.BLUE);
		add(lCabecera, BorderLayout.NORTH);

		JPanel panelIniciarSesion = new JPanel(new GridLayout(5, 5));
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		add(panelIniciarSesion, BorderLayout.CENTER);
		add(panelAcciones, BorderLayout.SOUTH);

		panelIniciarSesion.add(lblNewLabel);
		panelIniciarSesion.add(textField);
		panelIniciarSesion.add(lblNewLabel_1);
		panelIniciarSesion.add(password);
		panelAcciones.add(recuerdameButton);
		panelAcciones.add(btnNewButton);
		panelAcciones.add(btnNewButton_1);

		setVisible(true);
		setTitle("Iniciar sesión");
		setBounds(100, 100, 800, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(VentanaIniciarSesion.EXIT_ON_CLOSE);
	}

}
