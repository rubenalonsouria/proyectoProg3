package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.BaseDeDatos;

public class PanelEleccionAsientos extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTable tablaAsientos;
    private ModeloAsientos tableModel;
    private JLabel pantalla;
    private ArrayList<String[]> listaAsientos;
    
    public PanelEleccionAsientos(String pelicula) {
    	setLayout(new BorderLayout());
    	
        

        Object[] columnNames = new Object[10];
        pantalla = new JLabel(new ImageIcon("images/pantalla.png"));
        listaAsientos = new ArrayList<String[]>();
        
        for (int i = 0; i < 10; i++) {
            columnNames[i] = "Columna " + (i + 1);
            
        }
        
       listaAsientos = BaseDeDatos.obtenerAsientos(pelicula.replace(" ", "")); 
       tableModel = new ModeloAsientos(listaAsientos) {};
       tablaAsientos = new JTable(tableModel);
       
       this.tablaAsientos.setRowHeight(50);
       JScrollPane scrollPane = new JScrollPane(tablaAsientos);
        
        tableModel.setColumnIdentifiers(columnNames);
        
        tablaAsientos.setDefaultRenderer(Object.class, new RenderAsientos());
         
        
        for (int i = 0; i < tablaAsientos.getColumnCount(); i++) {
        	
			tablaAsientos.getColumnModel().getColumn(i).setMinWidth(75);
		}
       
            
        
        add(scrollPane,BorderLayout.CENTER);
        add(pantalla, BorderLayout.SOUTH);
        setVisible(true);
    }

}
