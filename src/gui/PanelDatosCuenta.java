package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.Administrador;
import Usuarios.Cliente;
import main.MainCine;

public class PanelDatosCuenta extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField datosCuentaCorreo, datosCuentaNombre, datosCuentaApellido, datosCuentaDni,
			datosCuentaFechaNacimiento;
	private JPasswordField datosCuentaPassword;
	private JButton editarDatosCuenta, salirDatosCuenta, guardarDatosCuenta, cerrarSesionDatosCuenta, metodoDePago;

	public PanelDatosCuenta() {
			editarDatosCuenta = new JButton("Editar");
			salirDatosCuenta = new JButton("salir"); // Poner icono de una x
			guardarDatosCuenta = new JButton("Guardar Cambios");
			cerrarSesionDatosCuenta = new JButton("Cerrar Sesion");
			metodoDePago = new JButton("Metodo De Pago");
			
			datosCuentaCorreo = new JTextField();
			datosCuentaPassword = new JPasswordField();
			datosCuentaNombre = new JTextField();
			datosCuentaApellido = new JTextField();
			datosCuentaDni = new JTextField();
			
		if (VentanaIniciarSesion.isSesionIniciada() == true) {
		if (VentanaIniciarSesion.administradorIniciado() == null) {
			// Cargamos los datos del cliente
			
			datosCuentaCorreo.setText(VentanaIniciarSesion.clienteIniciado().getCorreo());
			datosCuentaCorreo.setEditable(false);

			datosCuentaPassword.setText(VentanaIniciarSesion.clienteIniciado().getPassword());
			datosCuentaPassword.setEditable(false);

			datosCuentaNombre.setText(VentanaIniciarSesion.clienteIniciado().getNombre());
			datosCuentaNombre.setEditable(false);

			datosCuentaApellido.setText(VentanaIniciarSesion.clienteIniciado().getApellido());
			datosCuentaApellido.setEditable(false);

			datosCuentaDni.setText(VentanaIniciarSesion.clienteIniciado().getDni());
			datosCuentaDni.setEditable(false);

			// datosCuentaFechaNacimiento = new
			// JTextField(VentanaIniciarSesion.clienteIniciado().getFechaNacimineto().toString());
			// datosCuentaFechaNacimiento.setEditable(false);

			add(datosCuentaCorreo);
			add(datosCuentaPassword);
			add(datosCuentaNombre);
			add(datosCuentaApellido);
			add(datosCuentaDni);
			add(datosCuentaFechaNacimiento);

		} else if (VentanaIniciarSesion.clienteIniciado() == null) {
			// Cargamos los datos del Administrador
			datosCuentaCorreo.setText(VentanaIniciarSesion.administradorIniciado().getCorreo());
			datosCuentaCorreo.setEditable(false);

			datosCuentaPassword.setText(VentanaIniciarSesion.administradorIniciado().getPassword());
			datosCuentaPassword.setEditable(false);

			datosCuentaNombre.setText(VentanaIniciarSesion.administradorIniciado().getNombre());
			datosCuentaNombre.setEditable(false);

			datosCuentaApellido.setText(VentanaIniciarSesion.administradorIniciado().getApellido());
			datosCuentaApellido.setEditable(false);

			datosCuentaDni.setText(VentanaIniciarSesion.administradorIniciado().getDni());
			datosCuentaDni.setEditable(false);

			// datosCuentaFechaNacimiento = new
			// JTextField(VentanaIniciarSesion.administradorIniciado().getFechaNacimineto().toString());
			// datosCuentaFechaNacimiento.setEditable(false);

			add(datosCuentaCorreo);
			add(datosCuentaPassword);
			add(datosCuentaNombre);
			add(datosCuentaApellido);
			add(datosCuentaDni);
			add(datosCuentaFechaNacimiento);
		}

//ACTION LISTENERS DE PANEL DATOS CUENTA
		editarDatosCuenta.addActionListener((a) -> {
			datosCuentaCorreo.setEditable(true);
			datosCuentaPassword.setEditable(true);
			datosCuentaNombre.setEditable(true);
			datosCuentaApellido.setEditable(true);
			datosCuentaDni.setEditable(true);
			// datosCuentaFechaNacimiento.setEditable(true);
		});
		add(editarDatosCuenta);

		salirDatosCuenta.addActionListener((a) -> {
			setVisible(false);
		});
		add(salirDatosCuenta);

		cerrarSesionDatosCuenta.addActionListener((a) -> {
			VentanaIniciarSesion.setadministradorIniciado(null);
			VentanaIniciarSesion.setclienteIniciado(null);
			VentanaIniciarSesion.setSesionIniciada(false);
			setVisible(false);
		});
		add(cerrarSesionDatosCuenta);

		guardarDatosCuenta.addActionListener((a) -> {
			if (VentanaIniciarSesion.clienteIniciado() != null) {
				for (Cliente c : MainCine.getListaClientes()) { // Hay qeu editarlo tmb en el mapa
					if (c.getCorreo().equals(VentanaIniciarSesion.clienteIniciado().getCorreo())) {
						// Mapa
						String[] valorMapa = MainCine.getMapaUsuarios().get(c.getCorreo());
						valorMapa[0] = datosCuentaPassword.getText();
						MainCine.getMapaUsuarios().remove(c.getCorreo());
						MainCine.getMapaUsuarios().put(datosCuentaCorreo.getText(), valorMapa);
						// Lista
						c.setCorreo(datosCuentaCorreo.getText());
						c.setNombre(datosCuentaNombre.getText());
						c.setApellido(datosCuentaApellido.getText());
						c.setDni(datosCuentaDni.getText());
						c.setPassword(datosCuentaPassword.getText());
					}
				}
			} else {
				for (Administrador ad : MainCine.getListaAdministradores()) {
					if (ad.getCorreo().equals(VentanaIniciarSesion.administradorIniciado().getCorreo())) {
						// Mapa
						String[] valorMapa = MainCine.getMapaUsuarios().get(ad.getCorreo());
						valorMapa[0] = datosCuentaPassword.getText();
						MainCine.getMapaUsuarios().remove(ad.getCorreo());
						MainCine.getMapaUsuarios().put(datosCuentaCorreo.getText(), valorMapa);
						// Lista
						ad.setCorreo(datosCuentaCorreo.getText());
						ad.setNombre(datosCuentaNombre.getText());
						ad.setApellido(datosCuentaApellido.getText());
						ad.setDni(datosCuentaDni.getText());
						ad.setPassword(datosCuentaPassword.getText());
					}
				}
			}
			datosCuentaCorreo.setEditable(false);
			datosCuentaPassword.setEditable(false); // Una vez editado, se ponen en false
			datosCuentaNombre.setEditable(false);
			datosCuentaApellido.setEditable(false);
			datosCuentaDni.setEditable(false);
		});add(guardarDatosCuenta);

		metodoDePago.addActionListener((a) -> {
			setVisible(false);

		});add(metodoDePago);
	
	}
		//setPreferredSize(new Dimension(200, 200));
		setVisible(true);
}}
