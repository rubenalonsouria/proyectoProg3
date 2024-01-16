package gui;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import db.BaseDeDatos;
import domain.Cliente;
import domain.Pelicula;
import main.MainCine;

public class PanelInformacionPelicula extends JPanel {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MainCine.class.getName());

	private JButton botonVolver, botonComprar;
	private JLabel labelTitulo, labelDuracion, labelSinopsis, labelDirectores, labelActores, labelGenero;
	private JTextField textDuracion, textActores, textDirectores, textGenero;
	private JTextArea textSinopsis;

	public PanelInformacionPelicula(Pelicula p, JPanel estePanel) {
		Font font1 = new Font("Times New Roman", Font.BOLD, 20);
		Font font2 = new Font("Times New Roman", Font.PLAIN, 15);

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		// PANEL IZQUIERDA
		JPanel panelPeliculaIzquierda = new JPanel();
		panelPeliculaIzquierda.setLayout(new BoxLayout(panelPeliculaIzquierda, BoxLayout.Y_AXIS));

		botonVolver = new JButton("Volver");
		botonComprar = new JButton("Añadir al carro");

		labelTitulo = new JLabel(p.getTitulo());
		labelTitulo.setFont(font1);

		panelPeliculaIzquierda.add(Box.createVerticalGlue());
		panelPeliculaIzquierda.add(labelTitulo);
		panelPeliculaIzquierda.add(Box.createVerticalGlue());
		panelPeliculaIzquierda.add(botonComprar);
		panelPeliculaIzquierda.add(botonVolver);
		panelPeliculaIzquierda.add(Box.createVerticalGlue());

		add(panelPeliculaIzquierda);

		// PANEL DERECHA
		JPanel panelPeliculaDerecha = new JPanel();
		panelPeliculaDerecha.setLayout(new BoxLayout(panelPeliculaDerecha, BoxLayout.Y_AXIS));

		labelDuracion = new JLabel("Duración: ");
		labelSinopsis = new JLabel("Sinopsis: ");
		labelDirectores = new JLabel("Directores: ");
		labelActores = new JLabel("Actores: ");
		labelGenero = new JLabel("Género: ");

		textDuracion = new JTextField(p.getDuracion());
		textDuracion.setEditable(false);
		textDuracion.setOpaque(false);
		textDuracion.setFont(font2);

		textActores = new JTextField(String.join(", ", p.getActores()));
		textActores.setEditable(false);
		textActores.setOpaque(false);
		textActores.setFont(font2);

		textDirectores = new JTextField(String.join(", ", p.getDirectores()));
		textDirectores.setEditable(false);
		textDirectores.setOpaque(false);
		textDirectores.setFont(font2);

		textGenero = new JTextField(p.getGenero().toString());
		textGenero.setEditable(false);
		textGenero.setOpaque(false);
		textGenero.setFont(font2);

		textSinopsis = new JTextArea(p.getSinopsis());
		textSinopsis.setLineWrap(true);
		textSinopsis.setWrapStyleWord(true);
		textSinopsis.setEditable(false);
		textSinopsis.setOpaque(false);
		textSinopsis.setFont(font2);

		panelPeliculaDerecha.add(labelSinopsis);
		panelPeliculaDerecha.add(new JScrollPane(textSinopsis));
		panelPeliculaDerecha.add(labelGenero);
		panelPeliculaDerecha.add(textGenero);
		panelPeliculaDerecha.add(labelDirectores);
		panelPeliculaDerecha.add(textDirectores);
		panelPeliculaDerecha.add(labelActores);
		panelPeliculaDerecha.add(textActores);
		panelPeliculaDerecha.add(labelDuracion);
		panelPeliculaDerecha.add(textDuracion);

		add(panelPeliculaDerecha);

		// ACTION LISTENERS
		botonVolver.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN VOLVER");
			volverAInicio(estePanel);
		});

		botonComprar.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN COMPRAR");
			if (VentanaIniciarSesion.isSesionIniciada()) {
				if (VentanaIniciarSesion.isEsAdmin()) {
					JOptionPane.showMessageDialog(null, "Cambia de cuenta para continuar", null,
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					Cliente c = VentanaIniciarSesion.clienteIniciado();
					String correo = c.getCorreo();
					String titulo = p.getTitulo();
					BaseDeDatos.anadirCarritoDeCliente(correo, titulo); // TODO poner un Jspin y habra qeu poner un
																		// render de seleccion de asiento y el hilo de
																		// a;adiendo...
					JOptionPane.showMessageDialog(null, "Añadida con exito", null, JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Primero inicia Sesion o Registrate", null,
						JOptionPane.INFORMATION_MESSAGE);

			}

		});

		estePanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					logger.log(Level.INFO, "SE HA PULSADO LA TECLA ESCAPE");
					volverAInicio(estePanel);
				}
			}
		});

	}

	private void volverAInicio(JPanel estePanel) {
		if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
			VentanaPricipalNueva.getPanelCentral().remove(0);
			VentanaPricipalNueva.getPanelCentral().revalidate();
			VentanaPricipalNueva.getPanelCentral().repaint();
		}
		VentanaPricipalNueva.getPanelCentral().add(estePanel);
		VentanaPricipalNueva.getPanelCentral().repaint();
		VentanaPricipalNueva.getPanelCentral().revalidate();
	}

}
