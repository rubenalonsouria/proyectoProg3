package gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Pelicula.Pelicula;

public class ModeloTablaPelicula extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	List<String> listaPelicula;

	public ModeloTablaPelicula(List<String> listaPelicula) {
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
	
	

}
