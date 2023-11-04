package gui;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
//por que hay que poner serialVersionUID = 1L PREGUNTAR
	
	private static final long serialVersionUID = 1L;
	protected JButton identificarse;
	protected JPanel panelNorte, panelCentro;
	protected JList<?> listaPeliculas;
	

	public VentanaPrincipal() {
		
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		listaPeliculas = new JList();//Aqui anadir un Jlist con botones que contenga la imagen y el titulo de la peli
		
		identificarse = new JButton("Identificarse");
		identificarse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		identificarse.addActionListener((e)->{
			setVisible(false);
			JFrame ventanaPrincipal = this;
			new VentanaIdentificarse(ventanaPrincipal);
			
		});
		
		
		//Ventana
		setLayout(new BorderLayout(0, 0));
		panelCentro.add(listaPeliculas);
		panelNorte.add(identificarse);
		
		add(panelNorte, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		
		
		
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
