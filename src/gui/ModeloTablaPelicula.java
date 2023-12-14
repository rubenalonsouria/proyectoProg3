package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Pelicula.Pelicula;

public class ModeloTablaPelicula extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	List<Pelicula> listaPelicula;
	List<String> titulo = Arrays.asList("TITULO");
	
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
		/*
		 * case 1: return p.getDuracion(); 
		 * case 2: return p.getSinopsis(); 
		 * case 3:return p.getActores(); 
		 * case 4: return p.getDirectores(); 
		 * case 5: return p.getGenero(); 
		 * case 6: return p.getEstrellas();
		 */
		default: return null;
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
	
	
//Render
	/*public void setValueAt(Object aValue, int row, int column) {
	    if (aValue instanceof ImageIcon && column == 0) {
	        // Establecer la imagen en la película correspondiente en la lista
	        listaPelicula.get(row).setImagen((ImageIcon) aValue);
	        fireTableCellUpdated(row, column);
	    } else {
	        super.setValueAt(aValue, row, column);
	    }*/
	}
