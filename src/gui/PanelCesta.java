package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import Usuarios.Cliente;
import main.BaseDeDatos;

public class PanelCesta extends JPanel{

	private static final long serialVersionUID = 1L;
	private JList<String> jlist;
	private DefaultListModel<String> modeloLista;
	private JScrollPane scrollpanelList;
	private JButton botonVolver, botonComprar;
	
public PanelCesta(/*JPanel panelAnterior8*/) {
		
	
		setLayout(new FlowLayout());
		botonVolver = new JButton("Volver");
		botonComprar = new JButton("Comprar");
		
		modeloLista = new DefaultListModel<>();
		if (VentanaIniciarSesion.isSesionIniciada() /* && PanelInformacionPelicula.tickDeCarrito() */) {
			Cliente c = VentanaIniciarSesion.clienteIniciado();
			String correo = c.getCorreo();
			List<String> l = BaseDeDatos.obtenerListaCarrito(correo);
			modeloLista.removeAllElements();
			
			for (String s : l) {
				modeloLista.addElement(s);
			}
		}
		jlist = new JList<>(modeloLista);
		scrollpanelList = new JScrollPane(jlist);
		jlist.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
		
		
		/*Lectura de la base de datos
		 * diseñar la interfaz mejor:
		 * hay una lista con peliculas agregadas al carrito  que contendran cada una un checkbox,
		 * esas entradas son unicas ya que iran con el numero de asiento.
		 * 
		 * El checbox funcionara para seleccionar cuales quieres comprar y el boton compra te llevara a la pasarela de pago
		 * */
		
//ActionListeners
		botonVolver.addActionListener((e)-> {
			if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
				VentanaPricipalNueva.getPanelCentral().remove(0);
				VentanaPricipalNueva.getPanelCentral().revalidate();
				VentanaPricipalNueva.getPanelCentral().repaint();
			}
			/*
			 * VentanaPricipalNueva.getPanelCentral().add();
			 * VentanaPricipalNueva.getPanelCentral().repaint();
			 * VentanaPricipalNueva.getPanelCentral().revalidate();
			 */
		});
		
		botonComprar.addChangeListener((e)-> {
			
		});
		
		add(botonComprar);
		add(botonVolver);
		add(scrollpanelList);
		setVisible(true);
		setName("Cesta");
	}

}
