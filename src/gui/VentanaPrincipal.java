package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

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
	protected JButton identificarse;
	protected JPanel panelCuenta, panelCentro;
	protected JList<?> listaPeliculas;
	ImageIcon iconoIdentificarse = new ImageIcon("images/iconoCuenta.png");
	
	public VentanaPrincipal() {
		
		panelCuenta = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelCentro = new JPanel();
		listaPeliculas = new JList();//Aqui anadir un Jlist con botones que contenga la imagen y el titulo de la peli
		
		identificarse = new JButton();
		//identificarse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JFrame ventanaPrincipal = this;
		
		identificarse.addActionListener((e)->{
			setVisible(false);
			new VentanaIdentificarse(ventanaPrincipal);
			
		});
		
		
		//Ventana
		setLayout(new BorderLayout(0, 0));
		
		add(panelCuenta, BorderLayout.NORTH);
		
		panelCuenta.setBackground(Color.CYAN);
		panelCuenta.setBorder(BorderFactory.createLineBorder( Color.GRAY ));
		add(panelCentro, BorderLayout.CENTER);
		
		
		panelCentro.add(listaPeliculas);
		panelCuenta.add(identificarse);
		
		
		identificarse.setToolTipText("Iniciar sesión o registrarse");
		identificarse.setIcon(iconoIdentificarse);
		
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
