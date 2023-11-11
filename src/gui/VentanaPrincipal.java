package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
//por que hay que poner serialVersionUID = 1L PREGUNTAR
	
	private static final long serialVersionUID = 1L;
	protected JButton identificarse, admin, cineBilbao, cineBarakaldo, cineVitoria, cineSanSebastian;
	protected JPanel panelCuenta, panelCentro, panelCines;
	protected JList<?> listaPeliculas;
	protected ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard,iconoGarbera; 
	protected JLabel labelBilbao, labelBarakaldo, labelVitoria, labelSanSebastian;
	
	public VentanaPrincipal() {
		JFrame ventanaPrincipal = this;
		
		panelCuenta = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelCentro = new JPanel();
		panelCines = new JPanel();
		
		listaPeliculas = new JList();//Aqui anadir un Jlist con botones que contenga la imagen y el titulo de la peli
		
		iconoIdentificarse = new ImageIcon("images/iconoCuenta.png");
		
		identificarse = new JButton();		
		identificarse.setToolTipText("Iniciar sesión o registrarse");
		identificarse.setIcon(iconoIdentificarse);
		
		identificarse.addActionListener((e)->{
			setVisible(false);
			new VentanaIdentificarse(ventanaPrincipal);
			
		});
		
		admin = new JButton("Admin");
		admin.setToolTipText("Ventana Administrador");
		
		admin.addActionListener((e)->{
			setVisible(false);
			new VentanaPrincipalAdmin();
			
		});
		
		iconoZubi = new ImageIcon("images/BilbaoZubi.png");
		
		cineBilbao = new JButton();		
		cineBilbao.setToolTipText("");
		cineBilbao.setIcon(iconoZubi);
		
		cineBilbao.addActionListener((e)->{
			setVisible(false);
			new VentanaCineBilbao();
			
		});
		
		iconoMax = new ImageIcon("images/BarakaldoMaxCenter.png");
		
		cineBarakaldo = new JButton();		
		cineBarakaldo.setToolTipText("");
		cineBarakaldo.setIcon(iconoMax);
		
		cineBarakaldo.addActionListener((e)->{
			setVisible(false);
			new VentanaCineBarakaldo();
			
		});
		
		iconoBoulevard = new ImageIcon("images/Vitoriaboulevard.png");
		
		cineVitoria = new JButton();		
		cineVitoria.setToolTipText("");
		cineVitoria.setIcon(iconoBoulevard);
		
		cineVitoria.addActionListener((e)->{
			setVisible(false);
			new VentanaCineVitoria();
			
		});
		
		iconoGarbera = new ImageIcon("images/SanSebastianGarbera.png");
		
		cineSanSebastian = new JButton();		
		cineSanSebastian.setToolTipText("");
		cineSanSebastian.setIcon(iconoGarbera);
		
		cineSanSebastian.addActionListener((e)->{
			setVisible(false);
			new VentanaCineSanSebastian();
			
		});
		
		 labelBilbao = new JLabel("CINE ZUBIARTE BILBAO");
	     labelBarakaldo = new JLabel("CINE MAX CENTER BARAKALDO");
	     labelVitoria = new JLabel("CINE GARBERA SAN SEBASTIAN");
         labelSanSebastian = new JLabel("CINE BOULEVARD VITORIA");
		
		JPanel panelCines = new JPanel(new GridLayout(2,2 ));
		
		//Ventana
		setLayout(new BorderLayout(0, 0));
		add(panelCuenta, BorderLayout.NORTH);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder( Color.GRAY ));
		add(panelCentro, BorderLayout.CENTER);
		
		add(panelCines, BorderLayout.CENTER);
		
		panelCentro.add(listaPeliculas);
		panelCuenta.add(admin);
		panelCuenta.add(identificarse);
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
