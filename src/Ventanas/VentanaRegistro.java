package Ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame{
	public VentanaRegistro() {
		setBounds(400, 100, 800, 500); 
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("REGISTRO");
		
		JPanel panel1 = new JPanel();
		getContentPane().add(panel1, BorderLayout.WEST);
		JLabel nameLabel = new JLabel("Nombre: ");
        JTextField nameTextField = new JTextField(20);
        
        JPanel panel2 = new JPanel();
        getContentPane().add(panel2, BorderLayout.NORTH);
        
        
        JLabel surnameLabel = new JLabel("Apellidos: ");
        JTextField surnameTextField = new JTextField(20);
        
        JLabel ageLabel = new JLabel("Edad: ");
        JTextField ageTextField = new JTextField(20);
        
        JLabel correoLabel = new JLabel("Correo Electronico: ");
        JTextField correoTextField = new JTextField(20);
        
        JLabel contraseñaLabel = new JLabel("Contraseña: ");
        JTextField contraseñaTextField = new JTextField(20);
        
        JLabel telLabel = new JLabel("Numero de Telefono: ");
        JTextField telTextField = new JTextField(20);
        
        JButton submitButton = new JButton("Enviar");

        panel1.add(nameLabel);
        panel1.add(nameTextField);
        panel1.add(surnameLabel);
        panel1.add(surnameTextField);
        panel1.add(ageLabel);
        panel1.add(ageTextField);
        panel1.add(correoLabel);
        panel1.add(correoTextField);
        panel1.add(contraseñaLabel);
        panel1.add(contraseñaTextField);
        panel1.add(telLabel);
        panel1.add(telTextField);
        panel1.add(submitButton);
        panel1.setLayout(new GridLayout(7,2));
        
        
        this.add(panel1, BorderLayout.WEST);
        
        setVisible(true);
	}
}
