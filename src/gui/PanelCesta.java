package gui;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Usuarios.Cliente;
import main.BaseDeDatos;

public class PanelCesta extends JPanel {

	private static final long serialVersionUID = 1L;
	// private JList<String> jlist;
	// private DefaultListModel<String> modeloLista;
	private ModeloTablaCesta modeloTabla;
	private JTable tabla;
	private JScrollPane scrollpaneltabla;
	private JButton botonVolver, botonComprar;

	public PanelCesta(/* JPanel panelAnterior8 */) {

		setLayout(new FlowLayout());
		botonVolver = new JButton("Volver");
		botonComprar = new JButton("Comprar");

		// modeloLista = new DefaultListModel<>();

		if (VentanaIniciarSesion.isSesionIniciada() /* && PanelInformacionPelicula.tickDeCarrito() */) {
			
			Cliente c = VentanaIniciarSesion.clienteIniciado();
			String correo = c.getCorreo();
			List<String> l = BaseDeDatos.obtenerListaCarrito(correo);
			ArrayList<String[]> listaPeliculas = new ArrayList<>();

			for (String s : l) {
				boolean found = false;

				for (String[] a : listaPeliculas) {
					if (a[0].equals(s)) {
						a[1] = String.valueOf(Integer.parseInt(a[1]) + 1);
						found = true;
						break; 
					}
				}

				if (!found) {
					String[] newMovie = { s, "1" };
					listaPeliculas.add(newMovie);
				}
			}

			
			modeloTabla = new ModeloTablaCesta(listaPeliculas);
			String[] titulo = { "TITULO", "NUMERO ENTRADAS" };
			modeloTabla.setColumnIdentifiers(titulo);
		}

		// jlist = new JList<>(modeloLista);
		// scrollpanelList = new JScrollPane(jlist);
		// jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// jlist.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,
		// Color.DARK_GRAY, Color.LIGHT_GRAY));
		tabla = new JTable(modeloTabla);
		scrollpaneltabla = new JScrollPane(tabla);

		/*
		 * Lectura de la base de datos diseñar la interfaz mejor: hay una lista con
		 * peliculas agregadas al carrito que contendran cada una un checkbox, esas
		 * entradas son unicas ya que iran con el numero de asiento.
		 * 
		 * El checbox funcionara para seleccionar cuales quieres comprar y el boton
		 * compra te llevara a la pasarela de pago
		 */

//ActionListeners
		botonVolver.addActionListener((e) -> {
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

		botonComprar.addChangeListener((e) -> {

		});

		add(botonComprar);
		add(botonVolver);
		add(scrollpaneltabla);
		setVisible(true);
		setName("Cesta");
	}

}
