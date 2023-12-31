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

	public PanelPeliculas() {
		setLayout(new FlowLayout());
		JPanel estePanel = this;
		
		ArrayList<Pelicula> listaPeliculas = MainCine.getListaPeliculas();
		modelo = new ModeloTablaPelicula(listaPeliculas);
		tablaPeliculas = new JTable(modelo);
		scrollPanel = new JScrollPane(tablaPeliculas);
		tablaPeliculas.setRowHeight(500);

		tablaPeliculas.setDefaultRenderer(Object.class, new RenderTablaPeliculas());

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
