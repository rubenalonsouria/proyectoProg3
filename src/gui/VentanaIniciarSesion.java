package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaIniciarSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	private  VentanaPrincipal ventanaPrincipal;
	private JTextField textField; // Poner el nobre de cada componente con el que es
	private JLabel lblNewLabel, lblNewLabel_1;
	private JPasswordField password;
	private JButton btnNewButton, btnNewButton_1, botonAdminSi, botonAdminNo;
	private JPanel panelAdmin;
	private JCheckBox recuerdameButton;
	private Map<String, String[]> mapaUsuarios = new HashMap<>();
	
	

	public VentanaIniciarSesion(JFrame ventanaAnterior, JFrame ventanaPrincipal) {


		lblNewLabel = new JLabel("Correo Electrónico:");
		lblNewLabel_1 = new JLabel("Contraseña:");
		textField = new JTextField("");
		password = new JPasswordField("");
		btnNewButton = new JButton("Iniciar");
		btnNewButton_1 = new JButton("Volver");
		recuerdameButton = new JCheckBox("Recuerdame", false);

		// Para cancelar y volver a la ventana principal
		btnNewButton_1.addActionListener((e) -> {
			setVisible(false);
			ventanaAnterior.setVisible(true);
		});
		// Para iniciar Sesion
		btnNewButton.addActionListener((e) -> {
			try {
				/*
				 * SI ERES UN ADMINISTRADOR TIENE QEU APARECER QUE ES ADMIN Y TIENE PODERES
				 * EXTRA o que aparezca una ventana administrador(diferente a la de cliente que
				 * es la principal)
				 */
				Scanner sc = new Scanner(new FileReader("Ficheros/usuarios"));
				String usuario = sc.nextLine(); // Primera linea no la queremos
				String linea;
				while (sc.hasNext()) {
					linea = sc.nextLine();
					String[] partes = linea.split(",");
					String correo = partes[0];
					String contrasena = partes[1];
					String admin = partes[7];
					String[] values = { contrasena, admin };
					mapaUsuarios.put(correo, values);
				}
				sc.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			String contrasenaField = password.getText();
			String correoField = textField.getText();

			if (!mapaUsuarios.containsKey(correoField)) {
				JOptionPane.showMessageDialog(null, "Primero registrate", "ERROR", JOptionPane.WARNING_MESSAGE);
				
			} else {
				
				if (contrasenaField.equals(mapaUsuarios.get(correoField)[0])) {
					
					// Comprobacion si es admin
					if (mapaUsuarios.get(correoField)[1].equals("false")) {
						JOptionPane.showMessageDialog(null, "Inicio Sesion correcto", "ERROR",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						
					} else {
						/*
						 * opcion de con un panel panelAdmin = new JPanel(new GridLayout(1,2));
						 * botonAdminNo = new JButton("No"); botonAdminSi = new JButton("Si");
						 * panelAdmin.add(botonAdminNo); panelAdmin.add(botonAdminSi);
						 */
						
						Object t = "Se ha detectado que eres administrador" + "\n"// arreglar el barra n para qeu haga												
								+ "Quieres iniciar Sesion como admin?";			// una nueva fila
						int respuesta = JOptionPane.showConfirmDialog(null, t);

						if (respuesta == 0) {
							ventanaPrincipal.setVisible(true);
							//Poner boton adminVisible a true pero no funciona
							VentanaPrincipal.admin.setVisible(true);
							setVisible(false);
							
						} else if (respuesta == 1) {
							password.setText("");
							textField.setText("");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Contrasena incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		// Ventana
		JLabel lCabecera = new JLabel("Identificate con tus datos de inicio de sesión:");
		lCabecera.setForeground(Color.BLUE);
		add(lCabecera, BorderLayout.NORTH);

		JPanel panelIniciarSesion = new JPanel(new GridLayout(5, 5));
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		add(panelIniciarSesion, BorderLayout.CENTER);
		add(panelAcciones, BorderLayout.SOUTH);

		panelIniciarSesion.add(lblNewLabel);
		panelIniciarSesion.add(textField);
		panelIniciarSesion.add(lblNewLabel_1);
		panelIniciarSesion.add(password);
		panelAcciones.add(recuerdameButton);
		panelAcciones.add(btnNewButton);
		panelAcciones.add(btnNewButton_1);

		setVisible(true);
		setTitle("Iniciar sesión");
		setBounds(100, 100, 800, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(VentanaIniciarSesion.EXIT_ON_CLOSE);
	}

}
