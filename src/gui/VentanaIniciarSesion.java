package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaIniciarSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame ventanaPricipal;
	private JTextField textField; // Poner el nobre de cada componente con el que es
	private JLabel lblNewLabel, lblNewLabel_1;
	private JPasswordField password;
	private JButton btnNewButton, btnNewButton_1;
	private Map<String, String> mapaUsuarios = new HashMap<String, String>();

	public VentanaIniciarSesion(JFrame ventanaAnterior) {

		ventanaPricipal = ventanaAnterior;
		lblNewLabel = new JLabel("Correo Electrónico:");
		lblNewLabel_1 = new JLabel("Contraseña:");
		textField = new JTextField("", 15);
		password = new JPasswordField("", 15);
		btnNewButton = new JButton("Iniciar");
		btnNewButton_1 = new JButton("Volver");

		// Para cancelar y volver a la ventana principal
		btnNewButton_1.addActionListener((e) -> {
			setVisible(false);
			ventanaAnterior.setVisible(true);
		});

		btnNewButton.addActionListener((e) -> {
			try {
				Scanner sc = new Scanner(new FileReader("Ficheros/usuarios")); //ERROR EN LECTURA Y SI ERES UN ADMINISTRADOR TIENE QEU APARECER QUE ES ADMIN
				//String usuario = sc.nextLine();						// Y TIENE PODERES EXTRA o que aparezca una ventana administrador(diferente a la de cliente					
				String linea;										// que es la principal)
				while (sc.hasNext()) {
					linea = sc.nextLine();
					String[] partes = linea.split(";");
					String correo = partes[0];
					String contrasena = partes[1];
					mapaUsuarios.put(correo, contrasena);
				}
				sc.close();
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			String contrasenaField = password.getText();
			String correoField = textField.getText();
			if (!mapaUsuarios.containsKey(correoField)) {
				JOptionPane.showMessageDialog(null, "Primero registrate","ERROR",JOptionPane.WARNING_MESSAGE);
			}
			else {
				if (contrasenaField.equals(mapaUsuarios.get(correoField))) {
					JOptionPane.showMessageDialog(null, "Inicio Sesion correcto","ERROR",JOptionPane.OK_OPTION);
				}else {
					JOptionPane.showMessageDialog(null, "Contrasena incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		JLabel lCabecera = new JLabel("Identificate con tus datos de inicio de sesión:");
		add( lCabecera, BorderLayout.NORTH );
		JPanel panelIniciarSesion = new JPanel(new GridLayout(2, 2));
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		add(panelIniciarSesion, BorderLayout.CENTER);
		add(panelAcciones, BorderLayout.SOUTH);
		
		panelIniciarSesion.add(lblNewLabel);
		panelIniciarSesion.add(textField);
		panelIniciarSesion.add(lblNewLabel_1);
		panelIniciarSesion.add(password);
		panelAcciones.add(btnNewButton);
		panelAcciones.add(btnNewButton_1);

		setVisible(true);
		setTitle("Iniciar sesión");
		setBounds(100, 100, 800, 200);
		//setLayout(new FlowLayout()); // En el futuro lo pondremos null y lo pondremos manualmente
		setLocationRelativeTo(null);
		setDefaultCloseOperation(VentanaIniciarSesion.EXIT_ON_CLOSE);
	}

}
