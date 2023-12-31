package gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class RenderTablaPeliculas extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
				
		JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		ImageIcon foto = new ImageIcon(String.format("images/%s.jpg", value));
		label.setIcon(foto); 
		label.setHorizontalAlignment(JLabel.CENTER); 
		
		if (isSelected) {
			label.setBackground(table.getSelectionBackground());
			label.setForeground(table.getSelectionForeground());
		}
		label.setText(null);
		label.setOpaque(true);
		return label;
	}

}
