package gui;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import Pelicula.Pelicula;
import main.MainCine;

public class PanelPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;

	private ModeloTablaPelicula modelo;
	private JScrollPane scrollPanel;
	private JTable tablaPeliculas;

	// Supongamos que tienes un método para obtener la ruta de las imágenes basado
	// en el nombre de la película
	public String obtenerRutaImagen(String nombrePelicula) {
		// Esta función debería devolver la ruta completa a la imagen basada en el
		// nombre de la película
		// Por ejemplo, si tus imágenes están en la carpeta "imagenes" dentro de tu
		// proyecto:
		return "images/" + nombrePelicula + ".jpg";
	}

	public PanelPeliculas() {
		setLayout(new FlowLayout());
		JPanel estePanel = this;
		
		ArrayList<Pelicula> listaPeliculas = MainCine.getListaPeliculas();
		modelo = new ModeloTablaPelicula(listaPeliculas);
		tablaPeliculas = new JTable(modelo);
		scrollPanel = new JScrollPane(tablaPeliculas);

		/*
		 * //RENDER
		 * 
		 * TableColumn columnaImagen = tablaPeliculas.getColumnModel().getColumn(0);
		 * columnaImagen.setCellRenderer(new RenderTablaPeliculas());
		 * 
		 * 
		 * // Luego, al llenar la JTable con los datos, cargas las imágenes y las
		 * asignas a la tabla for (int i = 0; i < listaPeliculas.size(); i++) { String
		 * nombrePelicula = listaPeliculas.get(i).getTitulo(); // Suponiendo que
		 * obtienes el nombre de la película
		 * 
		 * // Obtener la ruta de la imagen basada en el nombre de la película String
		 * rutaImagen = obtenerRutaImagen(nombrePelicula);
		 * 
		 * // Cargar la imagen desde el archivo y asignarla como ImageIcon ImageIcon
		 * imagen = new ImageIcon(rutaImagen);
		 * 
		 * // Añadir la imagen a la JTable modelo.setValueAt(imagen, i, 0Aqui da error);
		 * // Donde 'columnaImagen' es la columna de las imágenes }
		 * 
		 * 
		 */
		tablaPeliculas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int filaSeleccionada = tablaPeliculas.rowAtPoint(p);

				if (filaSeleccionada != -1) {
					Pelicula peliculaSeleccionada = listaPeliculas.get(filaSeleccionada);
					if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
						VentanaPricipalNueva.getPanelCentral().remove(0);
						VentanaPricipalNueva.getPanelCentral().revalidate();
						VentanaPricipalNueva.getPanelCentral().repaint();
					}
					VentanaPricipalNueva.getPanelCentral().add(new PanelInformacionPelicula(peliculaSeleccionada,estePanel));
					VentanaPricipalNueva.getPanelCentral().repaint();
					VentanaPricipalNueva.getPanelCentral().revalidate();

				}
			}
		});

		add(scrollPanel);
		setName("Peliculas Disponibles");
		setVisible(true);
	}

}
