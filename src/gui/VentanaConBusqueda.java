package gui;

import javax.swing.*;

import domain.Pelicula;
import main.MainCine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaConBusqueda extends JFrame {
    
    private static final long serialVersionUID = 1L;
	private JTextField campoBusqueda;
	private JLabel labelBuscar;
    private JButton buscar;
    protected ImageIcon iconoBuscar;
    protected JPanel panelCuenta, panel, panelCuentaIzquierda, panelCuentaDerecha, panelCine, panelCinesInforamcion;
    private static Logger logger = Logger.getLogger(MainCine.class.getName());

    public VentanaConBusqueda() {
    	
        setTitle("Ventana con Búsqueda");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        JLabel labelBuscar = new JLabel("Buscar: ");
        JTextField campoBusqueda = new JTextField(20);
        JButton buscar = new JButton();
        iconoBuscar = new ImageIcon("images/iconoBuscar.png");
        buscar.setIcon(iconoBuscar);

        panel.add(labelBuscar);
        panel.add(campoBusqueda);
        panel.add(buscar);

        add(panel);
        
        campoBusqueda.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Creo que no es necesario implementar esto
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Creo que no es necesario implementar esto
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    realizarBusqueda(campoBusqueda.getText());
                }
            }
        });	
		
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	logger.log(Level.INFO, "SE HA PULSADO EL BOTÓN BUSCAR");
                realizarBusqueda(campoBusqueda.getText());
            }
        });
    }

    private void realizarBusqueda(String textoBusqueda) {
        if (textoBusqueda.isEmpty()) {
            logger.log(Level.INFO, "NO SE REALIZÓ LA BUSQUEDA POR QUE EL CAMPO ESTA VACIO");
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un término de búsqueda.");
            return;
        }

        ArrayList<Pelicula> listaPeliculas = MainCine.getListaPeliculas();
        ArrayList<Pelicula> peliculasEncontradas = new ArrayList<>();

        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().toLowerCase().contains(textoBusqueda.toLowerCase())) {
                peliculasEncontradas.add(pelicula);
            }
        }

        if (!peliculasEncontradas.isEmpty()) {
            logger.log(Level.INFO, "BUSCANDO: " + textoBusqueda);
            StringBuilder mensaje = new StringBuilder("Películas encontradas:\n");
            for (Pelicula pelicula : peliculasEncontradas) {
                mensaje.append(pelicula.getTitulo()).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensaje.toString());
        } else {

            logger.log(Level.INFO, "NO SE ENCONTRARON PELÍCULAS CON LA BÚSQUEDA: " + textoBusqueda);
            JOptionPane.showMessageDialog(this, "No se encontraron películas con la búsqueda: " + textoBusqueda);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.log(Level.INFO, "Búsqueda completada de " + textoBusqueda);
    }
}
