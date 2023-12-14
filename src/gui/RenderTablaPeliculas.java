package gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class RenderTablaPeliculas extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		// Verificamos si el valor es una instancia de ImageIcon
		if (value instanceof ImageIcon) {
			label.setIcon((ImageIcon) value);
			label.setText(null); // Limpiamos cualquier texto
			label.setHorizontalAlignment(JLabel.CENTER); // Alineamos la imagen al centro
		}
		return label;
	}

}
