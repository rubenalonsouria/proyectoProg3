package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
//por que hay que poner serialVersionUID = 1L PREGUNTAR

	private static final long serialVersionUID = 1L;
	protected JButton identificarse, cineBilbao, cineBarakaldo, cineVitoria, cineSanSebastian;
	protected JPanel panelCuenta, panelCentro, panelCinesInforamcion;
	protected JTable tablaPeliculas;
	protected DefaultTableModel modeloPeliculas;
	protected ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
	public static JButton admin;

	public VentanaPrincipal() {//Ordenar todo segun en el panel qeu sea 
								//si no es mucho lio para buscar en la ventana
		JFrame ventanaPrincipal = this;
		
		// Peliculas
		panelCentro = new JPanel();
		tablaPeliculas = new JTable();// Aqui anadir un Jlist con botones que contenga la imagen y el titulo de la
										// peli

		// Utilidad Ventana
		panelCuenta = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		iconoIdentificarse = new ImageIcon("images/iconoCuenta.png");
		identificarse = new JButton();
		identificarse.setToolTipText("Iniciar sesión o registrarse");
		identificarse.setIcon(iconoIdentificarse);

		identificarse.addActionListener((e) -> {
			setVisible(false);
			new VentanaIdentificarse(ventanaPrincipal);

		});

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
		iconoZubi = new ImageIcon("images/BilbaoZubi.png");
		cineBilbao = new JButton();
		cineBilbao.setToolTipText("");
		cineBilbao.setIcon(iconoZubi);

		cineBilbao.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineBilbao();

		});

		iconoMax = new ImageIcon("images/BarakaldoMaxCenter.png");

		cineBarakaldo = new JButton();
		cineBarakaldo.setToolTipText("");
		cineBarakaldo.setIcon(iconoMax);

		cineBarakaldo.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineBarakaldo();

		});

		iconoBoulevard = new ImageIcon("images/Vitoriaboulevard.png");

		cineVitoria = new JButton();
		cineVitoria.setToolTipText("");
		cineVitoria.setIcon(iconoBoulevard);

		cineVitoria.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineVitoria();

		});

		iconoGarbera = new ImageIcon("images/SanSebastianGarbera.png");

		cineSanSebastian = new JButton();
		cineSanSebastian.setToolTipText("");
		cineSanSebastian.setIcon(iconoGarbera);

		cineSanSebastian.addActionListener((e) -> {
			setVisible(false);
			new VentanaCineSanSebastian();

		});

		// Ventana
		setLayout(new BorderLayout());
		add(panelCuenta, BorderLayout.NORTH);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		add(panelCentro, BorderLayout.CENTER);

		panelCentro.add(tablaPeliculas);
		panelCuenta.add(admin);
		panelCuenta.add(identificarse);
		
		add(panelCinesInforamcion, BorderLayout.WEST);
		panelCinesInforamcion.add(cineBilbao);
		panelCinesInforamcion.add(cineBarakaldo);
		panelCinesInforamcion.add(cineVitoria);
		panelCinesInforamcion.add(cineSanSebastian);

		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
