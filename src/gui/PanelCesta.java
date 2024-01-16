package gui;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import db.BaseDeDatos;
import domain.Cliente;

public class PanelCesta extends JPanel {

	private static final long serialVersionUID = 1L;
	// private JList<String> jlist;
	// private DefaultListModel<String> modeloLista;
	private ModeloTablaCesta modeloTabla;
	private JTable tabla;
	private JScrollPane scrollpaneltabla;
	private JButton botonVolver, botonComprar;
	private JSpinner spiner;

	private int getnEstradas(int fila) {
		return Integer.parseInt((String) modeloTabla.getValueAt(fila, 1));
	}

	private void actualizarTabla() {
		ArrayList<String[]> listaPeliculas = cargarPeliculas();
		modeloTabla.actualizarDatos(listaPeliculas);
	}

	private ArrayList<String[]> cargarPeliculas() {

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

		return listaPeliculas;
	}

	public PanelCesta() {

		setLayout(new FlowLayout());
		botonVolver = new JButton("Volver");
		botonComprar = new JButton("Comprar");
		spiner = new JSpinner();
		spiner.setVisible(false);

		modeloTabla = new ModeloTablaCesta(cargarPeliculas());
		String[] titulo = { "TITULO", "NUMERO ENTRADAS" };
		modeloTabla.setColumnIdentifiers(titulo);

		tabla = new JTable(modeloTabla);

//ActionListeners
		botonVolver.addActionListener((e) -> {
			if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
				VentanaPricipalNueva.getPanelCentral().remove(0);
				VentanaPricipalNueva.getPanelCentral().revalidate();
				VentanaPricipalNueva.getPanelCentral().repaint();
			}
		});

		botonComprar.addActionListener((e) -> {
			int row = tabla.getSelectedRow();
			int veces = Integer.parseInt((String) tabla.getValueAt(row, 1));
			String pelicula = (String) tabla.getValueAt(row, 0);
			
			for (int i = 0; i < veces ; i++) {
				BaseDeDatos.quitarCarritoDeCliente(VentanaIniciarSesion.clienteIniciado().getCorreo(), pelicula);
			}
			
			if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
				VentanaPricipalNueva.getPanelCentral().remove(0);
				VentanaPricipalNueva.getPanelCentral().revalidate();
				VentanaPricipalNueva.getPanelCentral().repaint();
			}
			
			VentanaPricipalNueva.getPanelCentral().add(new PanelEleccionAsientos((String) modeloTabla.getValueAt(tabla.getSelectedRow(), 0),(int) spiner.getValue()));
			
			//nuevo panel el metodo de pago que lo coja de lo del inicio de sesion 
		});

		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int fila = tabla.getSelectedRow();
				if (fila != -1) {
					spiner.setValue(getnEstradas(fila));
					spiner.setVisible(true);

				} else {
					spiner.setVisible(false);
				}
			}
		});

		spiner.addChangeListener((e) -> {
			int fila = tabla.getSelectedRow();

			if (fila >= 0) {

				String pelicula = (String) tabla.getValueAt(fila, 0);

				int valorNuevo = (int) spiner.getValue();
				int valorActual = getnEstradas(fila);
				int resultadoResta = valorNuevo - valorActual;

				if (resultadoResta == 1) {
					for (int i = 0; i < resultadoResta; i++) {
						BaseDeDatos.anadirCarritoDeCliente(VentanaIniciarSesion.clienteIniciado().getCorreo(),
								pelicula);
					}
				} else if (resultadoResta == -1) {
					for (int i = 0; i < Math.abs(resultadoResta); i++) {
						BaseDeDatos.quitarCarritoDeCliente(VentanaIniciarSesion.clienteIniciado().getCorreo(),
								pelicula);
					}
				}
				actualizarTabla();

			}
			tabla.setRowSelectionInterval(fila, fila);
		});

		scrollpaneltabla = new JScrollPane(tabla);
		add(spiner);
		add(botonComprar);
		add(botonVolver);
		add(scrollpaneltabla);
		setVisible(true);
		setName("Cesta");
	}

}
