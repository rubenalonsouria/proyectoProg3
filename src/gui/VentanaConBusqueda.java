package gui;

import javax.swing.*;

import main.MainCine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        setSize(400, 400);
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
        // Implementar funcion de búsqueda aquí
        try {
            // Simulación de búsqueda
        	logger.log(Level.INFO, "BUSCANDO: " + textoBusqueda);
            Thread.sleep(1000);
            logger.log(Level.INFO, "MOSTRANDO RESULTADO: " + textoBusqueda);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Busqueda completada de " + textoBusqueda);
    
    }
    
    
    
}
