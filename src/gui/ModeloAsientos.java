package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

abstract

public class ModeloAsientos extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList<String[]> lista;
	private Object[] titulos;

	public ModeloAsientos(ArrayList<String[]> l, Object[] titulos) {
		super();
		lista = l;
		this.titulos = titulos;
	}

	@Override
	public String getColumnName(int column) {
		return titulos[column].toString();
	}

	@Override
	public int getRowCount() {
		if (lista == null) {
			return 0;
		} else {
			return lista.size();
		}
	}

	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public void removeRow(int row) {
		lista.remove(row);
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		String[] rowData = lista.get(row);
		rowData[column] = aValue.toString();
		lista.set(row, rowData);
		fireTableCellUpdated(row, column);

	}

	@Override
	public Object getValueAt(int row, int column) {

		String[] o = lista.get(row);

		switch (column) {
		case 0:
			return o[0];
		case 1:
			return o[1];
		case 2:
			return o[2];
		case 3:
			return o[3];
		case 4:
			return o[4];
		case 5:
			return o[5];
		case 6:
			return o[6];
		case 7:
			return o[7];
		case 8:
			return o[8];
		case 9:
			return o[9];
		default:
			return null;
		}
	}

}
