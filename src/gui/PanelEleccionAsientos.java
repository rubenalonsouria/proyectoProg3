package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelEleccionAsientos extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTable tablaAsientos;
    private ModeloAsientos tableModel;

    public PanelEleccionAsientos() {
        // Crear el modelo de la tabla con 20 filas y 10 columnas
        Object[] columnNames = new Object[10];
        
        for (int i = 0; i < 10; i++) {
            columnNames[i] = "Columna " + (i + 1);
        }
       
        tableModel = new ModeloAsientos(columnNames, 20);

        tablaAsientos = new JTable(tableModel);
        tablaAsientos.setDefaultRenderer(Integer.class, new RenderAsientos());

        JScrollPane scrollPane = new JScrollPane(tablaAsientos);
        add(scrollPane);
        
        for (int i = 0; i < tablaAsientos.getColumnCount(); i++) {
        	
			tablaAsientos.getColumnModel().getColumn(i).setMinWidth(75);
		}
        
        
        setVisible(true);
    }

}
