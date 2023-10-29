package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ventana.Inicio;

public class BienvenidaTesting extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private Fondo fondo;
	private JLabel bienvenida;
	private JButton accederButton;

	public BienvenidaTesting() {
		this.setTitle("Bienvenida");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		try { 
			fondo = new Fondo(ImageIO.read(new File("img/VolvoXC90Fondo.jpg")));
			panel = (JPanel) this.getContentPane();

			bienvenida = new JLabel("Bienvenido al concesionario");
			bienvenida.setFont(new Font("Tahoma", Font.BOLD, 30));
			bienvenida.setVerticalAlignment(SwingConstants.CENTER);
			bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
			bienvenida.setForeground(Color.PINK);

			accederButton = new JButton("Acceder");
			accederButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					InicioParaBienvenida.abrirInicio();
					dispose();
				}
			});

			getContentPane().add(bienvenida, BorderLayout.CENTER);
			getContentPane().add(accederButton, BorderLayout.SOUTH);

			panel.setBorder(fondo);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}		
		this.setVisible(true);
	}

	public static void abrirBienvenida() {
		BienvenidaTesting bienvenida = new BienvenidaTesting();
		bienvenida.setVisible(true);
		bienvenida.setSize(480,360);
		bienvenida.setLocationRelativeTo(null);
		bienvenida.setVisible(true);
	}
}
