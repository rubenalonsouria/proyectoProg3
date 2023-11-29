package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Usuarios.Administrador;
import Usuarios.Cliente;
import main.MainCine;


public class VentanaPrincipal extends JFrame {
//por que hay que poner serialVersionUID = 1L PREGUNTAR

	private static final long serialVersionUID = 1L;
	protected JButton identificarse, buscar, cine, peliculas, promociones, cineBilbao, cineBarakaldo, cineVitoria, cineSanSebastian, 
	editarDatosCuenta, guardarDatosCuenta,salirDatosCuenta,cerrarSesionDatosCuenta;
	protected JPanel panelCuenta, panelCuentaIzquierda, panelCuentaDerecha, 
	panelCentro, panelDatosCuenta;
	protected JTable tablaPeliculas;
	protected DefaultTableModel modeloPeliculas;
	protected ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
	protected JLabel labelLogo;
	public static JButton admin;
	private JTextField datosCuentaCorreo,datosCuentaNombre,datosCuentaApellido,datosCuentaDni,datosCuentaFechaNacimiento;
	private boolean esCliente;
	MainCine mainCine = new MainCine();
	private JPasswordField datosCuentaPassword;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());

	
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
		JFrame ventanaPrincipal = this;
		
		// Peliculas y Busqueda
		panelCentro = new JPanel();
		tablaPeliculas = new JTable();// Aqui anadir un Jlist con botones que contenga la imagen y el titulo de la peli
								
		// Utilidad Ventana
		panelCuenta = new JPanel(new BorderLayout());
		panelCuentaIzquierda = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelCuentaDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		
		//Botones y más de panelCuenta
		//Logo Deusto		
		ImageIcon icono = new ImageIcon("images/deustocinelogo.png");
		Image logo = icono.getImage();
		labelLogo = new JLabel(new ImageIcon(logo));
		
		//Boton Identificarse
		iconoIdentificarse = new ImageIcon("images/iconoCuenta.png");
		identificarse = new JButton();
		identificarse.setToolTipText("Iniciar sesión o registrarse");
		identificarse.setIcon(iconoIdentificarse);

		//paneldatoscuenta
		identificarse.addActionListener((e) -> {
			if (VentanaIniciarSesion.isSesionIniciada() == true) {
				panelDatosCuenta = new JPanel(new FlowLayout());
				editarDatosCuenta = new JButton("Editar");
				salirDatosCuenta = new JButton("salir"); //Poner icono de una x
				guardarDatosCuenta = new JButton("Guardar Cambios");
				cerrarSesionDatosCuenta = new JButton("Cerrar Sesion");
				
				if (VentanaIniciarSesion.administradorIniciado() == null) {
					esCliente = true;
					//Cargamos los datos del cliente
					datosCuentaCorreo = new JTextField(VentanaIniciarSesion.clienteIniciado().getCorreo());
					datosCuentaCorreo.setEditable(false);
					
					datosCuentaPassword = new JPasswordField(VentanaIniciarSesion.clienteIniciado().getPassword());
					datosCuentaPassword.setEditable(false);
					
					datosCuentaNombre = new JTextField(VentanaIniciarSesion.clienteIniciado().getNombre());
					datosCuentaNombre.setEditable(false);
					
					datosCuentaApellido = new JTextField(VentanaIniciarSesion.clienteIniciado().getApellido());
					datosCuentaApellido.setEditable(false);
					
					datosCuentaDni = new JTextField(VentanaIniciarSesion.clienteIniciado().getDni());
					datosCuentaDni.setEditable(false);
					
					//datosCuentaFechaNacimiento = new JTextField(VentanaIniciarSesion.clienteIniciado().getFechaNacimineto().toString());
					//datosCuentaFechaNacimiento.setEditable(false);
					
					//Anadimos al panel
					panelDatosCuenta.add(datosCuentaCorreo);
					panelDatosCuenta.add(datosCuentaPassword);
					panelDatosCuenta.add(datosCuentaNombre);
					panelDatosCuenta.add(datosCuentaApellido);
					panelDatosCuenta.add(datosCuentaDni);
					//panelDatosCuenta.add(datosCuentaFechaNacimiento);
					
				}else if (VentanaIniciarSesion.clienteIniciado() == null) {
					esCliente = false;
					//Cargamos los datos del Administrador
					datosCuentaCorreo = new JTextField(VentanaIniciarSesion.administradorIniciado().getCorreo());
					datosCuentaCorreo.setEditable(false);
					
					datosCuentaPassword = new JPasswordField(VentanaIniciarSesion.administradorIniciado().getPassword());
					datosCuentaPassword.setEditable(false);
					
					datosCuentaNombre = new JTextField(VentanaIniciarSesion.administradorIniciado().getNombre());
					datosCuentaNombre.setEditable(false);
					
					datosCuentaApellido = new JTextField(VentanaIniciarSesion.administradorIniciado().getApellido());
					datosCuentaApellido.setEditable(false);
					
					datosCuentaDni = new JTextField(VentanaIniciarSesion.administradorIniciado().getDni());
					datosCuentaDni.setEditable(false);
					
					//datosCuentaFechaNacimiento = new JTextField(VentanaIniciarSesion.administradorIniciado().getFechaNacimineto().toString());
					//datosCuentaFechaNacimiento.setEditable(false);
					
					//Anadimos al panel
					panelDatosCuenta.add(datosCuentaCorreo);
					panelDatosCuenta.add(datosCuentaPassword);
					panelDatosCuenta.add(datosCuentaNombre);
					panelDatosCuenta.add(datosCuentaApellido);
					panelDatosCuenta.add(datosCuentaDni);
					//panelDatosCuenta.add(datosCuentaFechaNacimiento);
					
				}
				//Boton editar
				editarDatosCuenta.addActionListener((a) -> {
					datosCuentaCorreo.setEditable(true);
					datosCuentaPassword.setEditable(true);
					datosCuentaNombre.setEditable(true);
					datosCuentaApellido.setEditable(true);
					datosCuentaDni.setEditable(true);
					//datosCuentaFechaNacimiento.setEditable(true);
				});
				panelDatosCuenta.add(editarDatosCuenta);
				
				//Boton guardar Cambios
				guardarDatosCuenta.addActionListener((a) ->{
					if (esCliente == true) {
						for (Cliente c : mainCine.getListaClientes()) {	//Hay qeu editarlo tmb en el mapa
							if (c.getCorreo().equals(VentanaIniciarSesion.clienteIniciado().getCorreo())) {
								//Mapa
								String[] valorMapa = mainCine.getMapaUsuarios().get(c.getCorreo());
								valorMapa[0] = datosCuentaPassword.getText();
								mainCine.getMapaUsuarios().remove(c.getCorreo());
								mainCine.getMapaUsuarios().put(datosCuentaCorreo.getText(), valorMapa);
								//Lista
								c.setCorreo(datosCuentaCorreo.getText());
								c.setNombre(datosCuentaNombre.getText());
								c.setApellido(datosCuentaApellido.getText());
								c.setDni(datosCuentaDni.getText());
								c.setPassword(datosCuentaPassword.getText());
								
							}
						}
						
					}else {
						for (Administrador ad : mainCine.getListaAdministradores()) {
							if (ad.getCorreo().equals(VentanaIniciarSesion.administradorIniciado().getCorreo())) {
								//Mapa
								String[] valorMapa = mainCine.getMapaUsuarios().get(ad.getCorreo());
								valorMapa[0] = datosCuentaPassword.getText();
								mainCine.getMapaUsuarios().remove(ad.getCorreo());
								mainCine.getMapaUsuarios().put(datosCuentaCorreo.getText(), valorMapa);
								//Lista
								ad.setCorreo(datosCuentaCorreo.getText());
								ad.setNombre(datosCuentaNombre.getText());
								ad.setApellido(datosCuentaApellido.getText());
								ad.setDni(datosCuentaDni.getText());
								ad.setPassword(datosCuentaPassword.getText());
							}
						}
					}
					//Desactivo la edicion
					datosCuentaCorreo.setEditable(false);
					datosCuentaPassword.setEditable(false);
					datosCuentaNombre.setEditable(false);
					datosCuentaApellido.setEditable(false);
					datosCuentaDni.setEditable(false);
					
				});
				panelDatosCuenta.add(guardarDatosCuenta);
				
				//Boton salir
				salirDatosCuenta.addActionListener((a) -> {
					panelDatosCuenta.setVisible(false);
					panelCentro.setVisible(true);
				});
				panelDatosCuenta.add(salirDatosCuenta);
				
				//Boton Cerrar Sesion
				cerrarSesionDatosCuenta.addActionListener((a) -> {
					VentanaIniciarSesion.setadministradorIniciado(null);
					VentanaIniciarSesion.setclienteIniciado(null);
					VentanaIniciarSesion.setSesionIniciada(false);
					panelCentro.setVisible(true);
					panelDatosCuenta.setVisible(false);
				});
				panelDatosCuenta.add(cerrarSesionDatosCuenta);
				
				panelCentro.setVisible(false);
				add(panelDatosCuenta, BorderLayout.CENTER); //Cuando sesion iniciada y clicke en el boton de la cuenta se haga visible y cuando no = false.
				
			}else {
				setVisible(false);
			new VentanaIdentificarse(ventanaPrincipal);
			}
			

		});

		//Boton Cine
		cine = new JButton("Cines");
		cine.setToolTipText("Información sobre los cines disponibles");
		
		cine.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN CINE");
			setVisible(false);
			new VentanaInfoCine();

		});
		
		//Boton Peliculas (Ventana Principal)
		peliculas = new JButton("Películas");
		peliculas.setToolTipText("Todas las películas disponibles");
		
		peliculas.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN PELICULAS");
			setVisible(false);
			new VentanaPrincipal();

		});
		
		//Boton Busqueda
		buscar = new JButton("Buscar");
		buscar.setToolTipText("Buscador de peliculas");
				
		buscar.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN BUSQUEDA");
			setVisible(true);
			new VentanaConBusqueda();

		});
		
		//Boton Admin
		admin = new JButton("Admin");
		admin.setToolTipText("Ventana Administrador");
		admin.setVisible(false);
		//admin.setVisible(false);
		/*
		 * while (adminVisible) { admin.setVisible(false); //Se activa cuando el sistema
		 * detecte ha iniciado un admin }
		 */
		admin.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN ADMIN");
			setVisible(false);
			new VentanaPrincipalAdmin(this);

		});
		
		//Creacion de JTable
		
		Object[] columnas = {"Pelicula"};
		Object[][] datos = {
                {new ImageIcon("images/theMarvels.jpg")},
                {new ImageIcon("images/UnAmor.jpg")},
                // Agregar mas Peliculas
        };	    
	    
		//Ventana
		setLayout(new BorderLayout(0, 0));
		add(panelCuenta, BorderLayout.NORTH);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		//panelCentro.setBackground(Color.LIGHT_GRAY);
		
		panelCuentaIzquierda.setBackground(Color.CYAN);
		//panelCuentaIzquierda.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelCuentaDerecha.setBackground(Color.CYAN);
		//panelCuentaDerecha.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		panelCuenta.add(panelCuentaIzquierda, BorderLayout.WEST);
		panelCuenta.add(panelCuentaDerecha, BorderLayout.EAST);
		
		add(panelCentro, BorderLayout.CENTER);
		//panelCentro.add(tablaPeliculas, BorderLayout.CENTER);
		panelCentro.add(buscar);
		
		panelCuentaDerecha.add(admin, BorderLayout.CENTER);
		panelCuentaDerecha.add(identificarse, BorderLayout.EAST);
		panelCuentaIzquierda.add(labelLogo, BorderLayout.WEST);
		panelCuentaIzquierda.add(buscar, BorderLayout.WEST);
		panelCuentaIzquierda.add(peliculas, BorderLayout.WEST);
		panelCuentaIzquierda.add(cine, BorderLayout.WEST);

		
		
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
