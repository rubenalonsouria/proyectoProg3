package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import db.BaseDeDatos;

public class PanelEleccionAsientos extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tablaAsientos;
	private ModeloAsientos tableModel;
	private JLabel pantalla;
	private ArrayList<String[]> listaAsientos;
	private JButton botonCompra;

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
		tableModel = new ModeloAsientos(listaAsientos, columnNames) {
			private static final long serialVersionUID = 1L;
		};

		tablaAsientos = new JTable(tableModel);
		botonCompra = new JButton("Comprar");
		JScrollPane scrollPane = new JScrollPane(tablaAsientos);
		scrollPane.setPreferredSize(new Dimension(1400, 750));
		this.tablaAsientos.setRowHeight(50);

		tablaAsientos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tablaAsientos.getTableHeader().setReorderingAllowed(false);

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
					}
				}
			}
		});
		botonCompra.addActionListener((e) -> {
			int[] selectedRows = tablaAsientos.getSelectedRows();
			int[] selectedColumns = tablaAsientos.getSelectedColumns();
			// HILO//
			JDialog dialog = new JDialog();
			dialog.setTitle("Cargando...");
			dialog.setModal(true);

			JProgressBar progressBar = new JProgressBar();
			progressBar.setIndeterminate(true);

			dialog.add(BorderLayout.CENTER, progressBar);
			dialog.setSize(200, 100);
			dialog.setLocationRelativeTo(null);

			Thread loadingThread = new Thread(() -> {
				try {
					Thread.sleep(2500); // Simula la carga durante 3 segundos
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				dialog.dispose();
				JOptionPane.showMessageDialog(null, "Carga completa");
			});

			loadingThread.start();
			dialog.setVisible(true);
			// HILO//

			BaseDeDatos.editarAsientos(selectedRows, selectedColumns, pelicula.replace(" ", ""));

			// seguir desarollarndo, guardar en la tabla

		});

		add(scrollPane, BorderLayout.CENTER);
		add(pantalla, BorderLayout.SOUTH);
		add(botonCompra, BorderLayout.EAST);
		setVisible(true);
	}

}
