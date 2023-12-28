package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.BaseDeDatos;

public class PanelEleccionAsientos extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tablaAsientos;
	private ModeloAsientos tableModel;
	private JLabel pantalla;
	private ArrayList<String[]> listaAsientos;
	private int seleccionActual = 0;
    

	public PanelEleccionAsientos(String pelicula, int numeroEntradas) {
		setLayout(new BorderLayout());
		
		final int MAX_SELECCIONES = numeroEntradas;

		Object[] columnNames = new Object[10];
		pantalla = new JLabel(new ImageIcon("images/pantalla.png"));
		listaAsientos = new ArrayList<String[]>();

		for (int i = 0; i < 10; i++) {
			columnNames[i] = "Columna " + (i + 1);

		}

		listaAsientos = BaseDeDatos.obtenerAsientos(pelicula.replace(" ", ""));
		//tableModel = new ModeloAsientos(listaAsientos, columnNames);
		tablaAsientos = new JTable(tableModel);

		this.tablaAsientos.setRowHeight(50);
        JScrollPane scrollPane = new JScrollPane(tablaAsientos);
		
		
		tablaAsientos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		tableModel.setColumnIdentifiers(columnNames);
		
		tablaAsientos.setDefaultRenderer(Object.class, new RenderAsientos());

		for (int i = 0; i < tablaAsientos.getColumnCount(); i++) {

			tablaAsientos.getColumnModel().getColumn(i).setMinWidth(75);
		}

//Actions Listeners

		
		tablaAsientos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int seleccionadas = tablaAsientos.getSelectedRowCount();

                    if (seleccionadas > MAX_SELECCIONES) {
                        int lastSelectedRow = tablaAsientos.getSelectedRow();
                        int lastSelectedColumn = tablaAsientos.getSelectedColumn();
                        tablaAsientos.changeSelection(lastSelectedRow, lastSelectedColumn, false, false);
                    } else {
                        seleccionActual = seleccionadas;
                    }
                }
            }
        });
		
		add(scrollPane, BorderLayout.CENTER);
		add(pantalla, BorderLayout.SOUTH);
		setVisible(true);
	}

}
