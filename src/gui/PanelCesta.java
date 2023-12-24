package gui;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JSpinner spiner;
	private static int nEntradas;

	private int getnEstradas(int fila) {
		return Integer.parseInt((String) tabla.getValueAt(fila, 1));
	}

	private JTable cargarModelo() {

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
		// TODO Poner qeu solo se pueda seleccionar una fila a la vez

		tabla = new JTable(modeloTabla);

		return tabla;
	}

	public PanelCesta(/* JPanel panelAnterior8 */) {

		setLayout(new FlowLayout());
		botonVolver = new JButton("Volver");
		botonComprar = new JButton("Comprar");
		spiner = new JSpinner();

		// modeloLista = new DefaultListModel<>();

		scrollpaneltabla = new JScrollPane(cargarModelo());

		// jlist = new JList<>(modeloLista);
		// scrollpanelList = new JScrollPane(jlist);
		// jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// jlist.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,
		// Color.DARK_GRAY, Color.LIGHT_GRAY));

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

		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int fila = tabla.getSelectedRow();
				spiner.setValue(getnEstradas(fila));
			}
		});

		spiner.addChangeListener((e) -> {
			if (tabla.getSelectedRow() >= 0) {
				int fila = tabla.getSelectedRow();
				String pelicula = (String) tabla.getValueAt(fila, 0);

				int valorNuevo = (int) spiner.getValue();
				int valorActual = getnEstradas(fila);
				int resultadoResta = valorNuevo - valorActual;

				System.out.println(resultadoResta);

				if (resultadoResta > 0) {
					System.out.println("entro");
					BaseDeDatos.anadirCarritoDeCliente(VentanaIniciarSesion.clienteIniciado().getCorreo(), pelicula);
					//antes de borrar qeu seleccione cual esta seleccionada en el modelo para qeu la nueva jtabel este con esa y 
					//opcional visible jspinner
					scrollpaneltabla.remove(0);
					add(scrollpaneltabla = new JScrollPane(cargarModelo()));
					VentanaPricipalNueva.getPanelCentral().revalidate();
					VentanaPricipalNueva.getPanelCentral().repaint();

				} else if (resultadoResta < 0) {
					System.out.println("Entro 2");
					BaseDeDatos.quitarCarritoDeCliente(VentanaIniciarSesion.clienteIniciado().getCorreo(), pelicula);
					
					scrollpaneltabla.remove(0);
					add(scrollpaneltabla = new JScrollPane(cargarModelo()));
					VentanaPricipalNueva.getPanelCentral().revalidate();
					VentanaPricipalNueva.getPanelCentral().repaint();
				}

			}

		});

		add(spiner);
		add(botonComprar);
		add(botonVolver);
		add(scrollpaneltabla);
		setVisible(true);
		setName("Cesta");
	}

}
