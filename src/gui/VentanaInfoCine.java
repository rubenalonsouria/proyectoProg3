package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaInfoCine extends JFrame{

	private static final long serialVersionUID = 1L;
	protected JButton identificarse, cine, peliculas;
	protected JPanel panelCuenta, panelCuentaIzquierda, panelCuentaDerecha, panelCine, panelCinesInforamcion;
	protected ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
	public static JButton admin;
	protected JLabel labelLogo, labelBara, labelZubi, labelGarbe, labelBoule;
	
	public VentanaInfoCine() {
		
		JFrame VentanaInfoCine = this;
		
		// Utilidad Ventana
		panelCuenta = new JPanel(new BorderLayout());
		panelCuentaIzquierda = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelCuentaDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelCinesInforamcion = new JPanel();
		panelCine = new JPanel(new GridLayout(0, 2, 10, 10));
		
		//Imagenes Cine fuente y descripciones
		ImageIcon iconoBarakaldo = new ImageIcon("images/BarakaldoMaxCenter.jpg");
		Image logoBarakaldo = iconoBarakaldo.getImage();
		labelBara = new JLabel(new ImageIcon(logoBarakaldo));
		
		Font font = new Font("Arial", Font.BOLD, 20);
		
        JTextArea descripcionBara = new JTextArea(
        		"Max Center es un centro comercial de Baracaldo, en la provincia vasca de Vizcaya. "
        		+ "Es la mayor zona de ocio y restauración de la provincia.");
        descripcionBara.setLineWrap(true);
        descripcionBara.setWrapStyleWord(true);
        descripcionBara.setEditable(false);
        descripcionBara.setFont(font);
		
		ImageIcon iconoZubi = new ImageIcon("images/BilbaoZubi.jpg");
		Image logoZubi = iconoZubi.getImage();
		labelZubi = new JLabel(new ImageIcon(logoZubi));
		
        JTextArea descripcionZubi = new JTextArea(
        		"Tiendas variadas, restaurantes y cine en un centro comercial cubierto"
        		+ " y elegante con un diseño que aporta sensación de amplitud.");
        descripcionZubi.setLineWrap(true);
        descripcionZubi.setWrapStyleWord(true);
        descripcionZubi.setEditable(false);
		descripcionZubi.setFont(font);
        
		ImageIcon iconoGarbera = new ImageIcon("images/SanSebastianGarbera.jpg");
		Image logoGarbera = iconoGarbera.getImage();
		labelGarbe = new JLabel(new ImageIcon(logoGarbera));
		
        JTextArea descripcionGarbe = new JTextArea(
        		"Centro comercial moderno con boutiques chic, "
        		+ "artículos para el hogar y varios restaurantes.");
        descripcionGarbe.setLineWrap(true);
        descripcionGarbe.setWrapStyleWord(true);
        descripcionGarbe.setEditable(false);
		descripcionGarbe.setFont(font);
        
		ImageIcon iconoBoule = new ImageIcon("images/VitoriaBoulevard.jpg");
		Image logoBoule = iconoBoule.getImage();
		labelBoule = new JLabel(new ImageIcon(logoBoule));
		
        JTextArea descripcionBoule = new JTextArea(
        		"El Boulevard es un maxicentro comercial situado"
        		+ " en la ciudad de Vitoria en el norte de España.");
        descripcionBoule.setLineWrap(true);
        descripcionBoule.setWrapStyleWord(true);
        descripcionBoule.setEditable(false);
		descripcionBoule.setFont(font);
        
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

		identificarse.addActionListener((e) -> {
			setVisible(false);
			new VentanaIdentificarse(VentanaInfoCine);

		});

		//Boton Cine
		cine = new JButton("Cines");
		cine.setToolTipText("Información sobre los cines disponibles");
				
		cine.addActionListener((e) -> {
			setVisible(false);
			new VentanaInfoCine();

		});

		//Boton Peliculas (Ventana Principal)
		peliculas = new JButton("Películas");
		peliculas.setToolTipText("Todas las películas disponibles");
				
		peliculas.addActionListener((e) -> {
			setVisible(false);
			new VentanaPrincipal();

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
			setVisible(false);
			new VentanaPrincipalAdmin(this);

		});
		
		setLayout(new BorderLayout(0, 0));
		add(panelCuenta, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(panelCine);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelCuentaIzquierda.setBackground(Color.CYAN);
		// panelCuentaIzquierda.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelCuentaDerecha.setBackground(Color.CYAN);
		// panelCuentaDerecha.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelCuenta.add(panelCuentaIzquierda, BorderLayout.WEST);
		panelCuenta.add(panelCuentaDerecha, BorderLayout.EAST);
		
		add(panelCine, BorderLayout.CENTER);

		
		panelCuentaDerecha.add(admin, BorderLayout.CENTER);
		panelCuentaDerecha.add(identificarse, BorderLayout.EAST);
		panelCuentaIzquierda.add(labelLogo, BorderLayout.WEST);
		panelCuentaIzquierda.add(cine, BorderLayout.WEST);
		panelCuentaIzquierda.add(peliculas, BorderLayout.WEST);

		panelCine.add(labelBara);
		panelCine.add(descripcionBara);
		panelCine.add(labelZubi);
		panelCine.add(descripcionZubi);
		panelCine.add(labelGarbe);
		panelCine.add(descripcionGarbe);
		panelCine.add(labelBoule);
		panelCine.add(descripcionBoule);
		
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Cines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
