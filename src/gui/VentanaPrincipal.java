package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
//por que hay que poner serialVersionUID = 1L PREGUNTAR

	private static final long serialVersionUID = 1L;
	protected JButton identificarse, buscar, cine, peliculas, promociones, cineBilbao, cineBarakaldo, cineVitoria, cineSanSebastian;
	protected JPanel panelCuenta, panelCuentaIzquierda, panelCuentaDerecha, panelCentro, panelCinesInforamcion;
	protected JTable tablaPeliculas;
	protected DefaultTableModel modeloPeliculas;
	protected ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
	protected JLabel labelLogo;
	public static JButton admin;

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
		
		// Peliculas
		panelCentro = new JPanel();
		tablaPeliculas = new JTable();// Aqui anadir un Jlist con botones que contenga la imagen y el titulo de la peli
								
		// Utilidad Ventana
		panelCuenta = new JPanel(new BorderLayout());
		panelCuentaIzquierda = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelCuentaDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelCinesInforamcion = new JPanel();
		
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
			new VentanaIdentificarse(ventanaPrincipal);

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
		
		//Boton Busqueda
				buscar = new JButton("Buscar");
				buscar.setToolTipText("Buscador de peliculas");
				
				buscar.addActionListener((e) -> {
					setVisible(true);
					new VentanaConBusqueda();
//hay que hcer que la bulsar el boton buscar se abra la VentanaConBusqueda
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
		
		
		
		//Ventana
		setLayout(new BorderLayout(0, 0));
		add(panelCuenta, BorderLayout.NORTH);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		panelCuentaIzquierda.setBackground(Color.CYAN);
		//panelCuentaIzquierda.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		panelCuentaDerecha.setBackground(Color.CYAN);
		//panelCuentaDerecha.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		panelCuenta.add(panelCuentaIzquierda, BorderLayout.WEST);
		panelCuenta.add(panelCuentaDerecha, BorderLayout.EAST);
		
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.add(tablaPeliculas);
		
		panelCuentaDerecha.add(admin, BorderLayout.CENTER);
		panelCuentaDerecha.add(identificarse, BorderLayout.EAST);
		panelCuentaIzquierda.add(labelLogo, BorderLayout.WEST);
		panelCuentaIzquierda.add(cine, BorderLayout.WEST);
		panelCuentaIzquierda.add(peliculas, BorderLayout.WEST);
		panelCuentaIzquierda.add(buscar, BorderLayout.WEST);

		
		

		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
