package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Pelicula;

public class ModeloTablaPelicula extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	List<Pelicula> listaPelicula;
	List<String> titulo = Arrays.asList("PELICULAS DISPONIBLES:");

	public ModeloTablaPelicula(List<Pelicula> listaPelicula) {
		super();
		this.listaPelicula = listaPelicula;
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public int getRowCount() {
		if (listaPelicula == null)
			return 0;
		return listaPelicula.size();
	}

	@Override
	public void removeRow(int row) {
		listaPelicula.remove(row);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Pelicula p = listaPelicula.get(row);
		switch (column) {
		case 0:
			return p.getTitulo(); // tampoco funciona con todos los atributos
		default:
			return null;
		}
	}

	@Override
	public int getColumnCount() {
		return titulo.size();
	}

	@Override
	public String getColumnName(int column) {

		return titulo.get(column);
	}
}