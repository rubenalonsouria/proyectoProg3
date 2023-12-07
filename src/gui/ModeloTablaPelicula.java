package gui;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Pelicula.Pelicula;

public class ModeloTablaPelicula extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	List<Pelicula> listaPelicula;
	List<String> titulos = Arrays.asList("TITULO","GENERO");
	public ModeloTablaPelicula(List<Pelicula> listaPelicula) {
		super();
		this.listaPelicula = listaPelicula;
	}
	
	public boolean isCellEditable(int row,int column) {
		return false;
	}
	
	@Override
	public int getRowCount() {
		if(listaPelicula==null)
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
		switch(column) {
		case 0: return p.getTitulo();
		case 1: return p.getGenero();
		default: return null;
		}
	}
	
	
	
	

}
