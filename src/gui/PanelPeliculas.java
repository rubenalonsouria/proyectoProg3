package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;

import Pelicula.Pelicula;
import main.MainCine;

public class PanelPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	
	private ModeloTablaPelicula modelo;
	private JScrollPane scrollPanel;
	private JTable tablaPeliculas;

	public PanelPeliculas() {
		setLayout(new BorderLayout());
		JPanel estePanel = this;
		
        //JMENU
        JMenuBar menuBar = new JMenuBar();
        
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        JMenu buscar = new JMenu("Buscar");
        JMenuItem buscarItem = new JMenuItem("Buscar por nombre");
        
        //ACCION, CIENCIA_FICCION, COMEDIA, DRAMA, FANTASIA, MUSICAL, ROMANCE, SUSPENSE, TERROR
        
        JMenu filtrar = new JMenu("Filtrar");
        JMenuItem AccionItem = new JMenuItem("Acción");
        JMenuItem CienciaFiccionItem = new JMenuItem("Ciencia Ficción");
        JMenuItem ComediaItem = new JMenuItem("Comedia");
        JMenuItem DramaItem = new JMenuItem("Drama");
        JMenuItem FantasiaItem = new JMenuItem("Fantasia");
        JMenuItem MusicalItem = new JMenuItem("Musical");
        JMenuItem RomanceItem = new JMenuItem("Romance");
        JMenuItem SuspenseItem = new JMenuItem("Suspense");
        JMenuItem TerrorItem = new JMenuItem("Terror");
        
        buscar.add(buscarItem); //Boton buscar por nombre dentro de Boton Buscar
        menuBar.add(buscar); //Boton Buscar
        
        buscar.addSeparator(); //Separador
        
        filtrar.add(AccionItem);
        filtrar.add(CienciaFiccionItem);
        filtrar.add(ComediaItem);
        filtrar.add(DramaItem);
        filtrar.add(FantasiaItem);
        filtrar.add(MusicalItem);
        filtrar.add(RomanceItem);
        filtrar.add(SuspenseItem);
        filtrar.add(TerrorItem);
        
        menuBar.add(filtrar);
        


        // Repite este bloque para los demás géneros

        
        buscarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN BUSQUEDA");
                VentanaConBusqueda ventanaBusqueda = new VentanaConBusqueda();
                ventanaBusqueda.setVisible(true);
            }
        });
        
        this.add(menuBar, BorderLayout.NORTH);
		


    

        
        //JTABLE
        
		ArrayList<Pelicula> listaPeliculas = MainCine.getListaPeliculas();
		modelo = new ModeloTablaPelicula(listaPeliculas);
		tablaPeliculas = new JTable(modelo);
		scrollPanel = new JScrollPane(tablaPeliculas);
		scrollPanel.setPreferredSize(new Dimension(1400, 750));
		tablaPeliculas.setRowHeight(500);

		tablaPeliculas.setDefaultRenderer(Object.class, new RenderTablaPeliculas());

		tablaPeliculas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int filaSeleccionada = tablaPeliculas.rowAtPoint(p);

				if (filaSeleccionada != -1) {
					Pelicula peliculaSeleccionada = listaPeliculas.get(filaSeleccionada);
					if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
						VentanaPricipalNueva.getPanelCentral().remove(0);
						VentanaPricipalNueva.getPanelCentral().revalidate();
						VentanaPricipalNueva.getPanelCentral().repaint();
					}
					VentanaPricipalNueva.getPanelCentral().add(new PanelInformacionPelicula(peliculaSeleccionada,estePanel));
					VentanaPricipalNueva.getPanelCentral().repaint();
					VentanaPricipalNueva.getPanelCentral().revalidate();

				}
			}
		});
		
		add(scrollPanel);
		setName("Peliculas Disponibles");
		setVisible(true);
	}

}