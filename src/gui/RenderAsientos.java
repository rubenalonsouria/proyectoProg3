package gui;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderAsientos extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel label = new JLabel();
		// El color de fondo es el color por defecto de la tabla
		label.setBackground(table.getBackground());
		// Por defecto el label se centra
		label.setHorizontalAlignment(JLabel.CENTER);
		if (value != null) {
			if (value.equals("1")) {
				label.setIcon(new ImageIcon("images/ocupada.png"));
			} else {
				label.setIcon(new ImageIcon("images/libre.png"));
			}

		}

		if (isSelected) {
			label.setBackground(table.getSelectionBackground());
			label.setForeground(table.getSelectionForeground());
		}

		label.setOpaque(true);

		return label;
	}
}
