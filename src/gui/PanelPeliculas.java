package gui;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Pelicula.Pelicula;
import main.MainCine;

public class PanelPeliculas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private ModeloTablaPelicula modelo;
	private JScrollPane scrollPanel;
	private JTable tablaPeliculas;

	public PanelPeliculas() {
		setLayout(new FlowLayout());
		
		ArrayList<Pelicula> listaPeliculas = MainCine.getListaPeliculas();
		
		
		modelo = new ModeloTablaPelicula(listaPeliculas);
		tablaPeliculas = new JTable(modelo);
		scrollPanel = new JScrollPane(tablaPeliculas);
		
		
		
		add(scrollPanel);
		setName("Peliculas Disponibles");
		setVisible(true);
	}

}
