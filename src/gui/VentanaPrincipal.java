package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Pelicula.Pelicula;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.MetodoDePago;
import main.MainCine;
import main.Utilidades;

public class VentanaPrincipal extends JFrame {
//por que hay que poner serialVersionUID = 1L PREGUNTAR

	private static final long serialVersionUID = 1L;
	protected JButton identificarse, buscar, cine, botonPeliculas, promociones, cineBilbao, cineBarakaldo, cineVitoria,
			cineSanSebastian, editarDatosCuenta, guardarDatosCuenta, salirDatosCuenta, cerrarSesionDatosCuenta,
			metodoDePago,botonVolverAdmin;
	
	protected JPanel panelCuenta, panelCuentaIzquierda, panelCuentaDerecha, panelCentro, panelDatosCuenta;
	protected JTable tablaPeliculas;
	protected JScrollPane srollTablaPeliculas;
	protected ImageIcon iconoIdentificarse, iconoBuscar;
	protected JLabel labelLogo;
	public static JButton admin;
	private JTextField datosCuentaCorreo, datosCuentaNombre, datosCuentaApellido, datosCuentaDni,
			datosCuentaFechaNacimiento;
	private boolean esCliente;
	private JPasswordField datosCuentaPassword;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());

	// metodo de pago PRUEBA
	private JComboBox<String> comboOpciones;
	private JPanel panelPaypal, panelBizum, panelPagoEnCine, panelTarjeta, panelMetodoDePago;
	private JLabel labelCorreo, labelPassword, labelNumeroTlf, labelTarjeta, labelFecha, labelCVV;
	private JTextField textCorreo, textoNumeroTlf, textoTarjeta, TextoFecha;
	JTextArea textoPagoEnCine;
	private JCheckBox pagoEnCine;
	private JPasswordField textPassword, textCVV;
	private JButton botonVolver, botonGuardar;
	
	private PanelPagos panel;

	/*
	 * public VentanaPrincipal() {//Ordenar todo segun en el panel qeu sea //si no
	 * es mucho lio para buscar en la ventana
	 * 
	 * protected JButton identificarse, admin, cineBilbao, cineBarakaldo,
	 * cineVitoria, cineSanSebastian; protected JPanel panelCuenta, panelCentro,
	 * panelCines; protected JList<?> listaPeliculas; protected ImageIcon
	 * iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
	 * protected JLabel labelBilbao, labelBarakaldo, labelVitoria,
	 * labelSanSebastian;
	 */

	public VentanaPrincipal() {
		/* VISTA CLIENTE */
//PANELES
		JFrame ventanaPrincipal = this;
		panelCuenta = new JPanel(new BorderLayout());
		panelCuentaIzquierda = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelCuentaDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));

//PANEL CENTRAL CON PELICULAS
		panelCentro = new JPanel(); // La idea es que la imagen tenga el mismo nombre que la peli y asi sea mas
									// facil
									// agregarlo a la Jtable
		List<Pelicula> listaPeliculas = new ArrayList<>();
		for (Pelicula p : MainCine.getListaPeliculas()) {
			listaPeliculas.add(p);
		}

		tablaPeliculas = new JTable(new ModeloTablaPelicula(listaPeliculas));// Aqui anadir un Jlist con botones que
																				// contenga la imagen y el titulo de la
																				// peli
		srollTablaPeliculas = new JScrollPane(tablaPeliculas);
		panelCentro.add(srollTablaPeliculas);

		// ...
		// ..
		// .

//PANEL SUPERIOR, BARRA DE BOTONES	
		labelLogo = new JLabel(new ImageIcon("images/deustocinelogo.png"));

		identificarse = new JButton(new ImageIcon("images/iconoCuenta.png"));
		identificarse.setToolTipText("Iniciar sesión o registrarse");

		cine = new JButton("Cines");
		cine.setToolTipText("Información sobre los cines disponibles");

		botonPeliculas = new JButton("Películas");
		botonPeliculas.setToolTipText("Todas las películas disponibles");

		buscar = new JButton(" Buscar", new ImageIcon("images/iconoBuscar.png"));
		buscar.setToolTipText("Buscador de peliculas");

		// ACTION LISTENERS
		cine.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN CINE");
			setVisible(false);
			new VentanaInfoCine();
		});

		botonPeliculas.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN PELICULAS");
			panelCentro.setVisible(true);
		});

		buscar.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN BUSQUEDA");
			setVisible(true);
			new VentanaConBusqueda();
		});

//LOGICA SI LA SESION ESTA INICIADA Y DEL PANEL DATOS CUENTA
		panelDatosCuenta = new JPanel(new FlowLayout());
		panelMetodoDePago = new JPanel(new FlowLayout());

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

		identificarse.addActionListener((e) -> {
			if (VentanaIniciarSesion.isSesionIniciada() == true) {
				//panel datos cuenta tenria que hacer un remove????
				
				if (VentanaIniciarSesion.administradorIniciado() == null) {
					esCliente = true;
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

					panelDatosCuenta.add(datosCuentaCorreo);
					panelDatosCuenta.add(datosCuentaPassword);
					panelDatosCuenta.add(datosCuentaNombre);
					panelDatosCuenta.add(datosCuentaApellido);
					panelDatosCuenta.add(datosCuentaDni);
					// panelDatosCuenta.add(datosCuentaFechaNacimiento);

				} else if (VentanaIniciarSesion.clienteIniciado() == null) {
					esCliente = false;
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

					panelDatosCuenta.add(datosCuentaCorreo);
					panelDatosCuenta.add(datosCuentaPassword);
					panelDatosCuenta.add(datosCuentaNombre);
					panelDatosCuenta.add(datosCuentaApellido);
					panelDatosCuenta.add(datosCuentaDni);
					// panelDatosCuenta.add(datosCuentaFechaNacimiento);
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
				panelDatosCuenta.add(editarDatosCuenta);

				
				
				salirDatosCuenta.addActionListener((a) -> {
					panelDatosCuenta.setVisible(false);
					panelMetodoDePago.setVisible(false);
					panelCentro.setVisible(true);
				});
				panelDatosCuenta.add(salirDatosCuenta);

				cerrarSesionDatosCuenta.addActionListener((a) -> {
					VentanaIniciarSesion.setadministradorIniciado(null);
					VentanaIniciarSesion.setclienteIniciado(null);
					VentanaIniciarSesion.setSesionIniciada(false);
					panelCentro.setVisible(true);
					panelDatosCuenta.setVisible(false);
					panelMetodoDePago.setVisible(false);
				});
				panelDatosCuenta.add(cerrarSesionDatosCuenta);

				guardarDatosCuenta.addActionListener((a) -> {
					if (esCliente == true) {
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
				});
				panelDatosCuenta.add(guardarDatosCuenta);

				metodoDePago.addActionListener((a) -> {
					panelMetodoDePago.setVisible(true);
					panelDatosCuenta.setVisible(false);
					add(panelMetodoDePago, BorderLayout.CENTER);
					repaint();
					//panelCentro.setVisible(false);
		
				});
				panelDatosCuenta.add(metodoDePago);

				panelCentro.setVisible(false);
				panelMetodoDePago.setVisible(false);
				panelDatosCuenta.setVisible(true);

				// add(panelMetodoDePago, BorderLayout.SOUTH);

//PANEL METODO DE PAGO
				String[] metodosAceptados = { "Tarjeta", "Bizum", "PayPal", "Pago en cine" };
				comboOpciones = new JComboBox<String>(metodosAceptados);
				comboOpciones.setSelectedIndex(-1);
				botonGuardar = new JButton("Guardar");
				botonVolver = new JButton("Volver");

				
				 // Paneles metodo de Pago (PONER ICONOS LOGO DEL METODO DE PAGO DE FONDO DE
				 // PANTALLA O UNA MARCA DE AGUA )
				

				// PayPal
				panelPaypal = new JPanel();
				labelCorreo = new JLabel("Correo: ");
				labelPassword = new JLabel("Contraseña: ");
				textCorreo = new JTextField(15);
				textPassword = new JPasswordField(12);

				panelPaypal.add(labelCorreo);
				panelPaypal.add(textCorreo);
				panelPaypal.add(labelPassword);
				panelPaypal.add(textPassword);

				panelPaypal.setVisible(false);

				// Bizum
				panelBizum = new JPanel();
				labelNumeroTlf = new JLabel("Numero de Tlf:");
				textoNumeroTlf = new JTextField(15);

				panelBizum.add(labelNumeroTlf);
				panelBizum.add(textoNumeroTlf);

				panelBizum.setVisible(false);

				// Pago en Cine
				panelPagoEnCine = new JPanel(new BorderLayout());
				pagoEnCine = new JCheckBox("Pagar en cine");
				textoPagoEnCine = new JTextArea("Marca la Casilla si desea pagar en cine," + "\n"
						+ "tendra que llegar 5 minutos antes y proporcionar" + "\n"
						+ "el correo con el que esta haceiendo la compra.");
				textoPagoEnCine.setEditable(false);

				panelPagoEnCine.add(pagoEnCine, BorderLayout.NORTH);
				panelPagoEnCine.add(textoPagoEnCine, BorderLayout.CENTER);

				panelPagoEnCine.setVisible(false);

				// Tarjeta
				panelTarjeta = new JPanel(new GridLayout(3, 2));
				labelTarjeta = new JLabel("Numero de Tarjeta: ");
				labelCVV = new JLabel("CVV: ");
				labelFecha = new JLabel("Fecha Caducidad: ");
				textoTarjeta = new JTextField(19);
				textCVV = new JPasswordField(3);
				TextoFecha = new JTextField(); // Poner cuando este implementado las Date

				panelTarjeta.add(labelTarjeta);
				panelTarjeta.add(textoTarjeta);
				panelTarjeta.add(labelCVV);
				panelTarjeta.add(textCVV);
				panelTarjeta.add(labelFecha);
				panelTarjeta.add(TextoFecha);

				panelTarjeta.setVisible(false);

				// Listeners
				botonVolver.addActionListener((f) -> {
					logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN VOLVER");
					panelMetodoDePago.setVisible(false);
					panelDatosCuenta.setVisible(true);
					panelCentro.setVisible(false);

				});

				comboOpciones.addActionListener((d) -> {
					logger.log(Level.INFO, "SE HA PULSADO OPCIONES");
					if (comboOpciones.getSelectedItem().equals("PayPal")) {
						panelBizum.setVisible(false);
						panelPagoEnCine.setVisible(false);
						panelPaypal.setVisible(true);
						panelTarjeta.setVisible(false);

					} else if (comboOpciones.getSelectedItem().equals("Bizum")) {
						panelBizum.setVisible(true);
						panelPagoEnCine.setVisible(false);
						panelPaypal.setVisible(false);
						panelTarjeta.setVisible(false);

					} else if (comboOpciones.getSelectedItem().equals("Pago en cine")) {
						panelBizum.setVisible(false);
						panelPagoEnCine.setVisible(true);
						panelPaypal.setVisible(false);
						panelTarjeta.setVisible(false);

					} else {
						panelBizum.setVisible(false);
						panelPagoEnCine.setVisible(false);
						panelPaypal.setVisible(false);
						panelTarjeta.setVisible(true);
					}
				});

				botonGuardar.addActionListener((a) -> { // Pensar solucion para a ver como almacenamos los datos de pago
					logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN GUARDAR");
					MetodoDePago m = null;
					ArrayList<String> datos = new ArrayList<String>();
					if (comboOpciones.getSelectedItem().equals("Tarjeta")) {
						logger.log(Level.INFO, "SE HA ELEGIDO TARJETA");
						m = MetodoDePago.tarjeta;
						datos.add(textoTarjeta.getText());
						datos.add(textCVV.getText());
						datos.add(TextoFecha.getText());

					} else if (comboOpciones.getSelectedItem().equals("Bizum")) {
						logger.log(Level.INFO, "SE HA ELEGIDO BIZUM");
						m = MetodoDePago.bizum;
						datos.add(textoNumeroTlf.getText());

					} else if (comboOpciones.getSelectedItem().equals("PayPal")) {
						logger.log(Level.INFO, "SE HA ELEGIDO PAYPAL");
						m = MetodoDePago.payPal;
						datos.add(textCorreo.getText());
						datos.add(textPassword.getText());

					} else if (comboOpciones.getSelectedItem().equals("Pago en cine") && pagoEnCine.isSelected()) {
						logger.log(Level.INFO, "SE HA ELEGIDO CINE");
						m = MetodoDePago.cine;
						datos.add("pago en cine");
					} else {
						JOptionPane.showMessageDialog(null, "No se ha guardado" + "\n" + "Comprueba los campos.");
					}
					Cliente c = VentanaIniciarSesion.clienteIniciado();
					c.setMetodoDePago(m);
					Utilidades.actualizarMetodosDePago(m, datos); // Este Metodo no esta HECHO
					datos = new ArrayList<String>();

					// poner messagedialog se ha guardado correctamente

				});
				
				panelMetodoDePago.add(panelBizum);
				panelMetodoDePago.add(panelPagoEnCine);
				panelMetodoDePago.add(panelPaypal);
				panelMetodoDePago.add(panelTarjeta);
				panelMetodoDePago.add(botonGuardar);
				panelMetodoDePago.add(botonVolver);
				panelMetodoDePago.add(comboOpciones);

			} else {
				setVisible(false);
				new VentanaIdentificarse(ventanaPrincipal);

			}

		});

		/* VISTA ADMINISTRADOR */
		botonVolverAdmin = new JButton("Vista Usuario");
		botonVolverAdmin.setToolTipText("Volver a la vista Usuario");
		botonVolverAdmin.setVisible(false);

		admin = new JButton("Admin");
		admin.setToolTipText("Ventana Administrador");
		admin.setVisible(false);
		
//ACTION LISTENERS
		if (!esCliente) {
		admin.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN ADMIN");
			admin.setVisible(false);
			botonVolverAdmin.setVisible(true);
			Utilidades.privilegiosAdministrador(true);
		});
		botonVolverAdmin.addActionListener((e)->{
			admin.setVisible(true);
			botonVolverAdmin.setVisible(false);
			Utilidades.privilegiosAdministrador(false);
		});
}
		// Ventana
		setLayout(new BorderLayout(0, 0));
		panelCuenta.setBackground(Color.CYAN);
		panelCentro.setBackground(Color.LIGHT_GRAY);
		panelCuentaIzquierda.setBackground(Color.CYAN);
		panelCuentaDerecha.setBackground(Color.CYAN);

		panelCuenta.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelCuenta.add(panelCuentaIzquierda, BorderLayout.WEST);
		panelCuenta.add(panelCuentaDerecha, BorderLayout.EAST);

		panelCuentaDerecha.add(admin, BorderLayout.CENTER);
		panelCuentaDerecha.add(botonVolverAdmin, BorderLayout.CENTER);
		panelCuentaDerecha.add(identificarse, BorderLayout.EAST);
		panelCuentaIzquierda.add(labelLogo, BorderLayout.WEST);
		panelCuentaIzquierda.add(buscar, BorderLayout.WEST);
		panelCuentaIzquierda.add(botonPeliculas, BorderLayout.WEST);
		panelCuentaIzquierda.add(cine, BorderLayout.WEST);

		panelCentro.add(tablaPeliculas, BorderLayout.CENTER);
		// panelCuentaIzquierda.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		// panelCuentaDerecha.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		//add(panelCentro, BorderLayout.CENTER);
		add(panelCuenta, BorderLayout.NORTH);

		add(panelMetodoDePago, BorderLayout.CENTER);
		//add(panel, BorderLayout.CENTER);
		add(panelDatosCuenta, BorderLayout.CENTER);

		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
