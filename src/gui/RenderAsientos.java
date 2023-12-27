package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderAsientos extends DefaultTableCellRenderer {
    
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rendererComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Integer) {
            int estado = (int) value;
            if (estado == 1) {
                rendererComp.setBackground(Color.RED); // Asiento ocupado
            } else {
                rendererComp.setBackground(Color.GREEN); // Asiento libre
            }
        }
        return rendererComp;
        }
}

