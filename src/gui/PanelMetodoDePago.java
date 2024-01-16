package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import domain.Cliente;
import domain.MetodoDePago;
import main.MainCine;
import main.Utilidades;

public class PanelMetodoDePago extends JPanel {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	private JComboBox<String> comboOpciones;
	private JPanel panelPaypal, panelBizum, panelPagoEnCine, panelTarjeta;
	private JLabel labelCorreo, labelPassword, labelNumeroTlf, labelTarjeta, labelFecha, labelCVV;
	private JTextField textCorreo, textoNumeroTlf, textoTarjeta, TextoFecha;
	JTextArea textoPagoEnCine;
	private JCheckBox pagoEnCine;
	private JPasswordField textPassword, textCVV;
	private JButton botonVolver, botonGuardar;

	public PanelMetodoDePago(Cliente c, PanelDatosCuenta panelDatosCuenta) {
		setLayout(new FlowLayout());
		// Combobox
		String[] metodosAceptados = { "Tarjeta", "Bizum", "PayPal", "Pago en cine" };
		comboOpciones = new JComboBox<String>(metodosAceptados);
		comboOpciones.setSelectedIndex(-1);
		add(comboOpciones);

		botonGuardar = new JButton("Guardar");
		botonVolver = new JButton("Volver");

		// Paneles metodo de Pago (PONER ICONOS LOGO DEL METODO DE PAGO DE FONDO DE
		// PANTALLA O UNA MARCA DE AGUA )
		// PayPal
		panelPaypal = new JPanel();
		labelCorreo = new JLabel("Correo: ");
		labelPassword = new JLabel("Contraseña: ");
		textCorreo = new JTextField(15);
		textPassword = new JPasswordField(12);

		panelPaypal.add(labelCorreo);
		panelPaypal.add(textCorreo);
		panelPaypal.add(labelPassword);
		panelPaypal.add(textPassword);

		// Bizum
		panelBizum = new JPanel();
		labelNumeroTlf = new JLabel("Numero de Tlf:");
		textoNumeroTlf = new JTextField(15);

		panelBizum.add(labelNumeroTlf);
		panelBizum.add(textoNumeroTlf);

		// Pago en Cine
		panelPagoEnCine = new JPanel(new BorderLayout());
		pagoEnCine = new JCheckBox("Pagar en cine");
		textoPagoEnCine = new JTextArea(
				"Marca la Casilla si desea pagar en cine," + "\n" + "tendra que llegar 5 minutos antes y proporcionar"
						+ "\n" + "el correo con el que esta haceiendo la compra.");
		textoPagoEnCine.setEditable(false);

		panelPagoEnCine.add(pagoEnCine, BorderLayout.NORTH);
		panelPagoEnCine.add(textoPagoEnCine, BorderLayout.CENTER);

		// Tarjeta
		panelTarjeta = new JPanel(new GridLayout(3, 2));
		labelTarjeta = new JLabel("Numero de Tarjeta: ");
		labelCVV = new JLabel("CVV: ");
		labelFecha = new JLabel("Fecha Caducidad: ");
		textoTarjeta = new JTextField(19);
		textCVV = new JPasswordField(3);
		TextoFecha = new JTextField();// Poner cuando este implementado las Date

		panelTarjeta.add(labelTarjeta);
		panelTarjeta.add(textoTarjeta);
		panelTarjeta.add(labelCVV);
		panelTarjeta.add(textCVV);
		panelTarjeta.add(labelFecha);
		panelTarjeta.add(TextoFecha);

		// Listeners
		// ComboBox
		comboOpciones.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO OPCIONES");
			if (comboOpciones.getSelectedItem().equals("PayPal")) {
				panelBizum.setVisible(false);
				panelPagoEnCine.setVisible(false);
				panelPaypal.setVisible(true);
				panelTarjeta.setVisible(false);

			} else if (comboOpciones.getSelectedItem().equals("Bizum")) {
				panelBizum.setVisible(true);
				panelPagoEnCine.setVisible(false);
				panelPaypal.setVisible(false);
				panelTarjeta.setVisible(false);

			} else if (comboOpciones.getSelectedItem().equals("Pago en cine")) {
				panelBizum.setVisible(false);
				panelPagoEnCine.setVisible(true);
				panelPaypal.setVisible(false);
				panelTarjeta.setVisible(false);

			} else {
				panelBizum.setVisible(false);
				panelPagoEnCine.setVisible(false);
				panelPaypal.setVisible(false);
				panelTarjeta.setVisible(true);
			}
		});

		// Botones guardar/volver
		botonGuardar.addActionListener((e) -> { // Pensar solucion para a ver como almacenamos los datos de pago
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN GUARDAR");
			MetodoDePago m = null;
			ArrayList<String> datos = new ArrayList<String>();
			if (comboOpciones.getSelectedItem().equals("Tarjeta")) {
				logger.log(Level.INFO, "SE HA ELEGIDO TARJETA");
				m = MetodoDePago.tarjeta;
				datos.add(textoTarjeta.getText());
				datos.add(textCVV.getText());
				datos.add(TextoFecha.getText());

			} else if (comboOpciones.getSelectedItem().equals("Bizum")) {
				logger.log(Level.INFO, "SE HA ELEGIDO BIZUM");
				m = MetodoDePago.bizum;
				datos.add(textoNumeroTlf.getText());

			} else if (comboOpciones.getSelectedItem().equals("PayPal")) {
				logger.log(Level.INFO, "SE HA ELEGIDO PAYPAL");
				m = MetodoDePago.payPal;
				datos.add(textCorreo.getText());
				datos.add(textPassword.getText());

			} else if (comboOpciones.getSelectedItem().equals("Pago en cine") && pagoEnCine.isSelected()) {
				logger.log(Level.INFO, "SE HA ELEGIDO CINE");
				m = MetodoDePago.cine;
				datos.add("pago en cine");
			} else {
				JOptionPane.showMessageDialog(null, "No se ha guardado" + "\n" + "Comprueba los campos.");
			}

			c.setMetodoDePago(m);
			Utilidades.actualizarMetodosDePago(m, datos);
			datos = new ArrayList<String>();
		});

		botonVolver.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN VOLVER");
			if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
				VentanaPricipalNueva.getPanelCentral().remove(0);
				VentanaPricipalNueva.getPanelCentral().revalidate();
				VentanaPricipalNueva.getPanelCentral().repaint();
			}
			//setVisible(false);
			VentanaPricipalNueva.getPanelCentral().add(panelDatosCuenta);
			VentanaPricipalNueva.getPanelCentral().repaint();
			VentanaPricipalNueva.getPanelCentral().revalidate();

		});

		panelBizum.setVisible(false);
		panelPagoEnCine.setVisible(false);
		panelPaypal.setVisible(false);
		panelTarjeta.setVisible(false);

		add(panelBizum);
		add(panelPagoEnCine);
		add(panelPaypal);
		add(panelTarjeta);
		add(botonGuardar);
		add(botonVolver);

		setVisible(true);
		setName("Metodo De Pago");
	}

}
