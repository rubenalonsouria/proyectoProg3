package Ventanas;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
//por que hay que poner serialVersionUID = 1L PREGUNTAR
	
	private static final long serialVersionUID = 1L;
	protected JFrame ventanaPrincipal;
	protected JButton iniciarSesion, registrarse;
	protected JLabel labelLogo;

	public VentanaPrincipal() {
		iniciarSesion = new JButton("Iniciar Sesion");
		registrarse = new JButton("Registrarse");
		ventanaPrincipal = this;

		/*
		 * Con absolute layout no se anade el segundo bottonn de momento ponemos un flow
		 * layout para que sea funcional iniciarSesion.setBounds(825, 200, 122, 38);
		 * registrarse.setBounds(825, 110, 122, 38);
		 */

		iniciarSesion.addActionListener((e) -> {
			setVisible(false);
			new VentanaIniciarSesion(ventanaPrincipal);
		});
		registrarse.addActionListener((e) -> {
			new VentanaRegistro();
		});

		JPanel panelBotonesAcciones = new JPanel();
		JPanel panelLogo = new JPanel();
		
		labelLogo = new JLabel(new ImageIcon("deustocinelogo2.png"));
		
		add(panelBotonesAcciones, BorderLayout.NORTH);
		add(panelLogo, BorderLayout.CENTER);
		panelBotonesAcciones.add(registrarse);
		panelBotonesAcciones.add(iniciarSesion);
		panelLogo.add(labelLogo);

		setVisible(true);
		setTitle("DeustoCine");
		pack();
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);

	}

}
