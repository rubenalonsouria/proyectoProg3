package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;

import Usuarios.Cliente;
import main.MainCine;
import main.Utilidades;

public class VentanaPricipalNueva extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(MainCine.class.getName());

	private JLabel labelLogo;
	private JButton botonIdentificarseSuperior, botonCineSuperior, botonPeliculasSuperior, botonBuscarSuperior,
			botonUsuarioSuperior, botonPrecioSuperior, botonCarritoSuperior;
	public static JButton botonAdminSuperior;
	private static JPanel panelCentral;
	private JPanel panelCuentaSuperior, panelCuentaIzquierdaSuperior, panelCuentaDerechaSuperior;
	private PanelDatosCuenta panelDatosCuenta;
	private PanelInformacionCines panelInformacionCines;

	private PanelPeliculas panelPeliculas;
	
	private PanelPrecios panelPrecios;
	
	private PanelCesta panelCesta;
	
/* METODOS */
	

	public static JPanel getPanelCentral() {
		return panelCentral;
	}
	public static void setPanelCentral(JPanel panelCentral) {
		VentanaPricipalNueva.panelCentral = panelCentral;
	}
	
/* VENTANA */

	public VentanaPricipalNueva() {
		JFrame ventanaPrincipal = this;

		/* VISTA USUARIO */
		panelCentral = new JPanel(new FlowLayout());
		panelCentral.setVisible(true);
		panelInformacionCines = new PanelInformacionCines();

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
		
		botonPrecioSuperior = new JButton("Precios");
		botonPrecioSuperior.setToolTipText("Consulta los precios disponibles");
		
		botonCarritoSuperior = new JButton("Cesta");
		

// ACTION LISTENERS
		botonCarritoSuperior.addActionListener((e) -> {  
			if (VentanaIniciarSesion.isSesionIniciada()) {
				if (getPanelCentral().getComponentCount() > 0) {
				getPanelCentral().remove(0);
				getPanelCentral().revalidate();
				getPanelCentral().repaint();
			}
			
			panelCesta = new PanelCesta();
			getPanelCentral().add(panelCesta); //de la base de datos que lea y cree una jtable
			getPanelCentral().revalidate();
			getPanelCentral().repaint();
			}else {
				JOptionPane.showMessageDialog(null, "Primero inicia sesion" );
			}
				
			
		});

		
		botonCineSuperior.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN CINE"); 
			if (getPanelCentral().getComponentCount() > 0) {
				//getPanelCentral().getComponent(0).setVisible(false);
				getPanelCentral().remove(0);
				getPanelCentral().revalidate();
				getPanelCentral().repaint();
			}
			getPanelCentral().add(panelInformacionCines);
			getPanelCentral().revalidate();
			getPanelCentral().repaint();	
			
		});

		botonPeliculasSuperior.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN PELICULAS");
			if (getPanelCentral().getComponentCount() > 0) {
				getPanelCentral().remove(0);
				getPanelCentral().revalidate();
				getPanelCentral().repaint();
			}
			panelPeliculas = new PanelPeliculas();
			getPanelCentral().add(panelPeliculas);
			getPanelCentral().revalidate();
			getPanelCentral().repaint();	
			
		});

		/*
		botonBuscarSuperior.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN BUSQUEDA");
			setVisible(true);
			new VentanaConBusqueda();
		});
		*/
		
		botonIdentificarseSuperior.addActionListener((e) -> {
			if (VentanaIniciarSesion.isSesionIniciada() == true) {
				if (getPanelCentral().getComponentCount() > 0) {
					getPanelCentral().remove(0);
					getPanelCentral().revalidate();
					getPanelCentral().repaint();
				}
				panelDatosCuenta = new PanelDatosCuenta();
				getPanelCentral().add(panelDatosCuenta);
				getPanelCentral().revalidate();
				getPanelCentral().repaint();

			} else {
				setVisible(false);
				new VentanaIdentificarse(ventanaPrincipal);
			}
		});
		
		botonPrecioSuperior.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN PRECIOS"); 
			if (getPanelCentral().getComponentCount() > 0) {
				//getPanelCentral().getComponent(0).setVisible(false);
				getPanelCentral().remove(0);
				getPanelCentral().revalidate();
				getPanelCentral().repaint();
			}
			panelPrecios = new PanelPrecios();
			getPanelCentral().add(panelPrecios); //CAMBIAR (SOLO PARA TEST)
			getPanelCentral().revalidate();
			getPanelCentral().repaint();	
			
		});
		
		/* VISTA ADMINISTRADOR */
		botonUsuarioSuperior = new JButton("Vista Usuario");
		botonUsuarioSuperior.setToolTipText("Volver a la vista Usuario");
		botonUsuarioSuperior.setVisible(false);

		botonAdminSuperior = new JButton("Admin");
		botonAdminSuperior.setToolTipText("Ventana Administrador");
		botonAdminSuperior.setVisible(false);

		// Ad esAdministrador = ;

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
		panelCuentaDerechaSuperior.add(botonCarritoSuperior);
		panelCuentaDerechaSuperior.add(botonIdentificarseSuperior, BorderLayout.EAST);
		


		panelCuentaIzquierdaSuperior.add(labelLogo, BorderLayout.WEST);
		//panelCuentaIzquierdaSuperior.add(botonBuscarSuperior, BorderLayout.WEST);
		panelCuentaIzquierdaSuperior.add(botonPeliculasSuperior, BorderLayout.WEST);
		panelCuentaIzquierdaSuperior.add(botonCineSuperior, BorderLayout.WEST);
		panelCuentaIzquierdaSuperior.add(botonPrecioSuperior, BorderLayout.WEST);

		panelCuentaSuperior.add(panelCuentaIzquierdaSuperior, BorderLayout.WEST);
		panelCuentaSuperior.add(panelCuentaDerechaSuperior, BorderLayout.EAST);
		add(panelCuentaSuperior, BorderLayout.NORTH);

		add(panelCentral, BorderLayout.CENTER);
        
		setBounds(100, 100, 1600, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
