package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.Cliente;
import Usuarios.Usuario;

public class VentanaRegistro extends JFrame {
	private static final long serialVersionUID = 1L;
	protected JPanel panel1, panel2;
	protected JTextField nameTextField, surnameTextField, correoTextField, telTextField, ageTextField, fechaNacimiento,
			dniTextField;
	protected JLabel nameLabel, surnameLabel, ageLabel, correoLabel, contraseñaLabel, dniLabel, telLabel,
			fechaNacimientoLabel;
	protected JPasswordField contraseñaTextField;
	protected JButton botonRegistrarse, botonVolver;
	
	public VentanaRegistro(JFrame ventanaPrincipal) {
		panel1 = new JPanel();
		add(panel1, BorderLayout.WEST);

		nameLabel = new JLabel("Nombre: ");
		nameTextField = new JTextField(20);

		surnameLabel = new JLabel("Apellidos: ");
		surnameTextField = new JTextField(20);

//		ageLabel = new JLabel("Edad: ");
//		ageTextField = new JTextField(20);

		correoLabel = new JLabel("Correo Electronico: ");
		correoTextField = new JTextField(20);

		contraseñaLabel = new JLabel("Contraseña: ");
		contraseñaTextField = new JPasswordField(20);

		telLabel = new JLabel("Numero de Telefono: ");
		telTextField = new JTextField(20);

		fechaNacimientoLabel = new JLabel("Fecha Nacimiento: ");
		fechaNacimiento = new JTextField(20);// formas para darle el formato correcto al localDate
		fechaNacimiento.setEditable(false); // De momento el usuario se crea con su cumplea;os en NULL.

		dniLabel = new JLabel("Dni:");
		dniTextField = new JTextField(20);

		botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.addActionListener((e) -> {
			//Cogemos de los TextFields
			String name = nameTextField.getText();
			String apellidos = surnameTextField.getText();
			// String edad = ageTextField.getText();
			String correo = correoTextField.getText();
			String contrasena = contraseñaTextField.getText();
			String dni = dniTextField.getText();
			
			//Comprobamos la informacion y si es correcta escribimos en fichero y creamos cliente
			if (name.matches("[a-zA-Z]+") && apellidos.matches("[a-zA-Z]+") && telTextField.getText().matches("\\d+")) {
				int telefono = Integer.parseInt(telTextField.getText());
				Cliente cliente = new Cliente(correo, contrasena, name, apellidos, dni, null, telefono);
				
				//Escritura
				try (FileWriter fileWriter = new FileWriter("Ficheros/usuarios", true)) {
					fileWriter.write(correo + "," + contrasena + "," + name + "," + apellidos + "," + dni + ","
							+ "fechaNULLTemporal" + "," + telefono + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new VentanaIniciarSesion(ventanaPrincipal);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Te has registrado correctamente",
						null, JOptionPane.INFORMATION_MESSAGE);
				

			} else {
				if (name.matches("[a-zA-Z]+") && apellidos.matches("[a-zA-Z]+")) {
					JOptionPane.showMessageDialog(null, "Comprueba que el numero de tlf solo contenga numeros ",
							"ERROR", JOptionPane.WARNING_MESSAGE);
				} else if (telTextField.getText().matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Comprueba que el nombre y apellido solo contine letras ",
							"ERROR", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Comprueba nombre, apellido y telefono", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		});

		botonVolver = new JButton("Volver");
		botonVolver.addActionListener((e) -> {
			ventanaPrincipal.setVisible(true);
			setVisible(false);
		});

		panel1.add(nameLabel);
		panel1.add(nameTextField);
		panel1.add(surnameLabel);
		panel1.add(surnameTextField);
		// panel1.add(ageLabel);
		// panel1.add(ageTextField);
		panel1.add(correoLabel);
		panel1.add(correoTextField);
		panel1.add(contraseñaLabel);
		panel1.add(contraseñaTextField);
		panel1.add(telLabel);
		panel1.add(telTextField);
		panel1.add(dniLabel);
		panel1.add(dniTextField);
		panel1.add(fechaNacimientoLabel);
		panel1.add(fechaNacimiento);
		panel1.add(botonRegistrarse);
		panel1.add(botonVolver);

		panel1.setLayout(new GridLayout(8, 2));
		add(panel1, BorderLayout.WEST);

		setBounds(400, 100, 800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("REGISTRO");
		setVisible(true);
	}
}
