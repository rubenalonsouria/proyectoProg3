package gui;

import javax.swing.table.DefaultTableModel;

public class ModeloAsientos extends DefaultTableModel {
    public ModeloAsientos(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class; // Todas las columnas contendrán valores enteros (1 o 0)
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true; // Permitir la edición de celdas para cambiar el estado de los asientos
    }
}
