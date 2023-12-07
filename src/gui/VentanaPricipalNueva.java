package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainCine;
import main.Utilidades;

public class VentanaPricipalNueva extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());

	private JLabel labelLogo;
	private JButton botonIdentificarseSuperior, botonCineSuperior, botonPeliculasSuperior, botonBuscarSuperior,
			botonUsuarioSuperior;
	public static JButton botonAdminSuperior;
	private JPanel panelCentral;
	private JPanel panelCuentaSuperior, panelCuentaIzquierdaSuperior, panelCuentaDerechaSuperior;
	private PanelDatosCuenta panelDatosCuenta;

	public VentanaPricipalNueva() {
		JFrame ventanaPrincipal = this;
		
		
		/* VISTA USUARIO */
		panelDatosCuenta = new PanelDatosCuenta();
		
		panelCentral = new JPanel(new FlowLayout());
		panelCentral.setVisible(true);
				
		panelCuentaSuperior = new JPanel(new BorderLayout());
		panelCuentaIzquierdaSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelCuentaDerechaSuperior = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		labelLogo = new JLabel(new ImageIcon("images/deustocinelogo.png"));

		botonIdentificarseSuperior = new JButton(new ImageIcon("images/iconoCuenta.png"));
		botonIdentificarseSuperior.setToolTipText("Iniciar sesión o registrarse");

		botonCineSuperior = new JButton("Cines");
		botonCineSuperior.setToolTipText("Información sobre los cines disponibles");

		botonPeliculasSuperior = new JButton("Películas");
		botonPeliculasSuperior.setToolTipText("Todas las películas disponibles");

		botonBuscarSuperior = new JButton(" Buscar", new ImageIcon("images/iconoBuscar.png"));
		botonBuscarSuperior.setToolTipText("Buscador de peliculas");

// ACTION LISTENERS
		botonCineSuperior.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN CINE");
			setVisible(false);
			new VentanaInfoCine();
		});

		botonPeliculasSuperior.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN PELICULAS");
			panelCentral.setVisible(true);
		});

		botonBuscarSuperior.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN BUSQUEDA");
			setVisible(true);
			new VentanaConBusqueda();
		});
		botonIdentificarseSuperior.addActionListener((e) -> {
			if (VentanaIniciarSesion.isSesionIniciada() == true) {
				panelDatosCuenta.setVisible(true);
				panelCentral.add(panelDatosCuenta);
				
				panelDatosCuenta.setBorder(BorderFactory.createLineBorder(Color.RED)); // Agregar un borde rojo al panel

				
				
				panelCentral.revalidate();
		        panelCentral.repaint();
		        this.revalidate();
		        this.repaint();
				
			} else {
				setVisible(false);
				new VentanaIdentificarse(ventanaPrincipal);
			}
		});
		
		/* VISTA ADMINISTRADOR */
		botonUsuarioSuperior = new JButton("Vista Usuario");
		botonUsuarioSuperior.setToolTipText("Volver a la vista Usuario");
		botonUsuarioSuperior.setVisible(false);

		botonAdminSuperior = new JButton("Admin");
		botonAdminSuperior.setToolTipText("Ventana Administrador");
		botonAdminSuperior.setVisible(false);
		
		//Ad esAdministrador =  ;

//ACTION LISTENERS
	
		if (VentanaIniciarSesion.isEsAdmin()) { // No entra a este bucle
			botonAdminSuperior.addActionListener((e) -> {
				logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN ADMIN");
				botonAdminSuperior.setVisible(false);
				botonUsuarioSuperior.setVisible(true);
				Utilidades.privilegiosAdministrador(true);
			});
			botonUsuarioSuperior.addActionListener((e) -> {
				botonAdminSuperior.setVisible(true);
				botonUsuarioSuperior.setVisible(false);
				Utilidades.privilegiosAdministrador(false);
			});

		} else {
			botonAdminSuperior.setVisible(false);
			botonUsuarioSuperior.setVisible(false);
		}
		

		/* VENTANA */
		setLayout(new BorderLayout(0, 0));
		panelCuentaSuperior.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelCuentaSuperior.setBackground(Color.CYAN);
		panelCuentaIzquierdaSuperior.setBackground(Color.CYAN);
		panelCuentaDerechaSuperior.setBackground(Color.CYAN);

		panelCuentaDerechaSuperior.add(botonAdminSuperior, BorderLayout.CENTER);
		panelCuentaDerechaSuperior.add(botonUsuarioSuperior, BorderLayout.CENTER);
		panelCuentaDerechaSuperior.add(botonIdentificarseSuperior, BorderLayout.EAST);

		panelCuentaIzquierdaSuperior.add(labelLogo, BorderLayout.WEST);
		panelCuentaIzquierdaSuperior.add(botonBuscarSuperior, BorderLayout.WEST);
		panelCuentaIzquierdaSuperior.add(botonPeliculasSuperior, BorderLayout.WEST);
		panelCuentaIzquierdaSuperior.add(botonCineSuperior, BorderLayout.WEST);

		panelCuentaSuperior.add(panelCuentaIzquierdaSuperior, BorderLayout.WEST);
		panelCuentaSuperior.add(panelCuentaDerechaSuperior, BorderLayout.EAST);
		add(panelCuentaSuperior, BorderLayout.NORTH);
		
		add(panelCentral, BorderLayout.CENTER);
		//add(panelCentral, BorderLayout.CENTER);

		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
