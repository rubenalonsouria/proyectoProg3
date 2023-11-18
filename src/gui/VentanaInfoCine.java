package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaInfoCine extends JFrame{

	private static final long serialVersionUID = 1L;
	protected JButton identificarse, cine;
	protected JPanel panelCuenta, panelCentro, panelCinesInforamcion;
	protected ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
	public static JButton admin;
	
	public VentanaInfoCine() {
		
		JFrame VentanaInfoCine = this;
		
		panelCuenta = new JPanel(new BorderLayout());
		panelCentro = new JPanel();
		
		iconoIdentificarse = new ImageIcon("images/iconoCuenta.png");
		identificarse = new JButton();
		identificarse.setToolTipText("Iniciar sesión o registrarse");
		identificarse.setIcon(iconoIdentificarse);

		identificarse.addActionListener((e) -> {
			setVisible(false);
			new VentanaIdentificarse(VentanaInfoCine);

		});

		cine = new JButton("Cines");
		cine.setToolTipText("Información sobre los cines disponibles");
		
		cine.addActionListener((e) -> {
			setVisible(false);
			new VentanaInfoCine();

		});

		
		admin = new JButton("Admin");
		admin.setToolTipText("Ventana Administrador");
		admin.setVisible(false);
		
		setLayout(new BorderLayout(0, 0));
		add(panelCuenta, BorderLayout.NORTH);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		add(panelCentro, BorderLayout.CENTER);

		panelCuenta.add(admin, BorderLayout.CENTER);
		panelCuenta.add(identificarse, BorderLayout.EAST);
		panelCuenta.add(cine, BorderLayout.WEST);
		
		
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Cines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
