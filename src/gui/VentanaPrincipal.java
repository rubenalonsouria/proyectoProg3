package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
	protected JButton identificarse, cineBilbao, cineBarakaldo, cineVitoria, cineSanSebastian, cine;
	protected JPanel panelCuenta, panelCentro, panelCinesInforamcion;
	protected JTable tablaPeliculas;
	protected DefaultTableModel modeloPeliculas;
	protected ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
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

		tablaPeliculas = new JTable();// Aqui anadir un Jlist con botones que contenga la imagen y el titulo de la
										// peli

		// Utilidad Ventana
		panelCuenta = new JPanel(new BorderLayout());
		panelCinesInforamcion = new JPanel();
		

		
		iconoIdentificarse = new ImageIcon("images/iconoCuenta.png");
		identificarse = new JButton();
		identificarse.setToolTipText("Iniciar sesión o registrarse");
		identificarse.setIcon(iconoIdentificarse);

		identificarse.addActionListener((e) -> {
			setVisible(false);
			new VentanaIdentificarse(ventanaPrincipal);

		});

		cine = new JButton("Cines");
		cine.setToolTipText("Información sobre los cines disponibles");
		
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
		
		// Panel Cines
		panelCinesInforamcion = new JPanel(new GridLayout(4,1)); //Modificable segun cantidad de cines
		iconoZubi = new ImageIcon("images/BilbaoZubi.jpg");
		cineBilbao = new JButton();
		cineBilbao.setToolTipText("");
		cineBilbao.setIcon(iconoZubi);

		cineBilbao.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineBilbao();

		});

		iconoMax = new ImageIcon("images/BarakaldoMaxCenter.jpg");

		cineBarakaldo = new JButton();
		cineBarakaldo.setToolTipText("");
		cineBarakaldo.setIcon(iconoMax);

		cineBarakaldo.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineBarakaldo();

		});

		iconoBoulevard = new ImageIcon("images/Vitoriaboulevard.jpg");

		cineVitoria = new JButton();
		cineVitoria.setToolTipText("");
		cineVitoria.setIcon(iconoBoulevard);

		cineVitoria.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineVitoria();

		});

		iconoGarbera = new ImageIcon("images/SanSebastianGarbera.jpg");

		cineSanSebastian = new JButton();
		cineSanSebastian.setToolTipText("");
		cineSanSebastian.setIcon(iconoGarbera);

		cineSanSebastian.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineSanSebastian();

		});

		// Ventana
		 setLayout(new BorderLayout());		
		 JLabel labelBilbao = new JLabel("CINE ZUBIARTE BILBAO");
	     JLabel labelBarakaldo = new JLabel("CINE MAX CENTER BARAKALDO");
	     JLabel labelSanSebastian = new JLabel("CINE BOULEVARD VITORIA");
		 JLabel labelVitoria = new JLabel("CINE GARBERA SAN SEBASTIAN");
		 
		JPanel panelCines = new JPanel(new GridLayout(2, 2));
		
		//Ventana
		setLayout(new BorderLayout(0, 0));
		add(panelCuenta, BorderLayout.NORTH);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		add(panelCentro, BorderLayout.CENTER);

		panelCentro.add(tablaPeliculas);
		
		
		panelCentro.add(tablaPeliculas);
		panelCuenta.add(admin, BorderLayout.CENTER);
		panelCuenta.add(identificarse, BorderLayout.EAST);
		panelCuenta.add(cine, BorderLayout.WEST);
		
		add(panelCines, BorderLayout.CENTER);
		panelCines.add(cineBilbao);
		panelCines.add(cineBarakaldo);
		panelCines.add(cineVitoria);
		panelCines.add(cineSanSebastian);
		panelCines.add(labelBilbao);
		panelCines.add(labelBarakaldo);
		panelCines.add(labelVitoria);
		panelCines.add(labelSanSebastian);
		
		

		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
