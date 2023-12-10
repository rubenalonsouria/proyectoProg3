package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Pelicula.Pelicula;

public class ModeloTablaPelicula extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	List<Pelicula> listaPelicula;
	List<String> titulos = Arrays.asList("TITULO");
	
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
		case 0: return p.getTitulo();		//tampoco funciona con todos los atributos
		case 1: return p.getDuracion();
		case 2: return p.getSinopsis();
		case 3: return p.getActores();
		case 4: return p.getDirectores();
		case 5: return p.getGenero();
		case 6: return p.getEstrellas();
		default: return null;
		}
	}
 
	@Override
	public int getColumnCount() {
		return super.getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		
		return super.getColumnName(column);
	}
	
	
	
	
	
	
	

}
