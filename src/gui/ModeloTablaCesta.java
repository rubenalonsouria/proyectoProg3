package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaCesta extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<String[]> l;

	public ModeloTablaCesta(ArrayList<String[]> l) {
		super();
		this.l = l;
	}

	@Override
	public void removeRow(int row) {
		l.remove(row);
	}

	@Override
	public int getRowCount() {
		if (l == null) {
			return 0;
		}
		return l.size();
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int column) {
		//System.out.println(l.size());
		//System.out.println(row);
		String[] o = l.get(row);
		
		switch(column) {
		case 0: return o[0];
		case 1: return o[1]; 
		default: return null;
		}
	}

	public void actualizarDatos(ArrayList<String[]> nuevosDatos) {
        this.l = nuevosDatos; // Actualizar los datos con los nuevos obtenidos de la base de datos
        fireTableDataChanged(); // Notificar a la tabla que los datos han cambiado
    }
	
	
	
	
	
	
	
}
