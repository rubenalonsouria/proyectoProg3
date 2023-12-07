package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.Cliente;
import Usuarios.Usuario;
import main.MainCine;
import main.Utilidades;

public class VentanaRegistro extends JFrame {
	private static final long serialVersionUID = 1L;
	protected JTextField nameTextField, surnameTextField, correoTextField, telTextField, ageTextField, fechaNacimiento,
			dniTextField;
	protected JLabel nameLabel, surnameLabel, ageLabel, correoLabel, contraseñaLabel, dniLabel, telLabel,
			fechaNacimientoLabel;
	protected JPasswordField contraseñaTextField;
	protected JButton botonRegistrarse, botonVolver;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	
	public VentanaRegistro(JFrame ventanaAnterior, JFrame ventanaPrincipal) {

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
		fechaNacimiento = new JTextField("yyyy-MM-dd");// formas para darle el formato correcto al localDate
		fechaNacimiento.setEditable(true); // De momento el usuario se crea con su cumpleaños en NULL.

		dniLabel = new JLabel("Dni:");
		dniTextField = new JTextField(20);

		botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.addActionListener((e) -> {
			//Cogemos de los TextFields
			String name = nameTextField.getText();
			String apellidos = surnameTextField.getText();
			String correo = correoTextField.getText();
			String contrasena = contraseñaTextField.getText();
			String dni = dniTextField.getText();
			
			//Comprobamos la informacion y si es correcta escribimos en fichero y creamos cliente
			if (name.matches("[a-zA-Z]+") && apellidos.matches("[a-zA-Z]+") && telTextField.getText().matches("\\d+")) {
				int telefono = Integer.parseInt(telTextField.getText());
				LocalDate ld = LocalDate.parse(fechaNacimiento.getText());
				Cliente cliente = new Cliente(correo, contrasena, name, apellidos, dni, ld , telefono, false);
				
				//Escritura
				try (FileWriter fileWriter = new FileWriter("Ficheros/usuarios", true)) {
					fileWriter.write(correo + "," + contrasena + "," + name + "," + apellidos + "," + dni + ","
							+ cliente.getFechaNacimineto().toString() + "," + telefono + "," + "false"+ "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new VentanaIniciarSesion(ventanaAnterior, ventanaPrincipal);
				setVisible(false);
				MainCine.cargaDeUsuarios();
				JOptionPane.showMessageDialog(null, "Te has registrado correctamente",
						null, JOptionPane.INFORMATION_MESSAGE);
				

			} else {
				if (name.matches("[a-zA-Z]+") && apellidos.matches("[a-zA-Z]+")) {
					JOptionPane.showMessageDialog(null, "Comprueba que el numero de tlf solo contenga numeros ",
							"ERROR", JOptionPane.WARNING_MESSAGE);
				} else if (telTextField.getText().matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Comprueba que el nombre y apellido solo contiene letras ",
							"ERROR", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Comprueba nombre, apellido y telefono", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		});

		botonVolver = new JButton("Volver");
		botonVolver.addActionListener((e) -> {
			ventanaAnterior.setVisible(true);
			setVisible(false);
		});

		JPanel panelRegistroL = new JPanel(new GridLayout(7, 0));
		JPanel panelRegistroF = new JPanel(new GridLayout(7, 0));
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		add(panelRegistroF, BorderLayout.CENTER);
		add(panelRegistroL, BorderLayout.WEST);
		add(panelAcciones, BorderLayout.SOUTH);
		
		panelRegistroL.add(nameLabel);
		panelRegistroF.add(nameTextField);
		panelRegistroL.add(surnameLabel);
		panelRegistroF.add(surnameTextField);
		// panel1.add(ageLabel);
		// panel1.add(ageTextField);
		panelRegistroL.add(correoLabel);
		panelRegistroF.add(correoTextField);
		panelRegistroL.add(contraseñaLabel);
		panelRegistroF.add(contraseñaTextField);
		panelRegistroL.add(telLabel);
		panelRegistroF.add(telTextField);
		panelRegistroL.add(dniLabel);
		panelRegistroF.add(dniTextField);
		panelRegistroL.add(fechaNacimientoLabel);
		panelRegistroF.add(fechaNacimiento);
		panelAcciones.add(botonRegistrarse);
		panelAcciones.add(botonVolver);

		//panelRegistro.setLayout(new GridLayout(8, 2));
		//add(panel1, BorderLayout.WEST);

		setBounds(400, 100, 800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Registro");
		setVisible(true);
	}
}
