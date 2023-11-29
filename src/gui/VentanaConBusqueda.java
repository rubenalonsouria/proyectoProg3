package gui;

import javax.swing.*;

import main.MainCine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaConBusqueda extends JFrame {
    
    private static final long serialVersionUID = 1L;
	private JTextField campoBusqueda;
	private JLabel labelBuscar;
    private JButton buscar;
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
        JButton buscar = new JButton("Buscar");

        panel.add(labelBuscar);
        panel.add(campoBusqueda);
        panel.add(buscar);

        add(panel);
        
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

        JOptionPane.showMessageDialog(this, "Realizando búsqueda con: " + textoBusqueda);
    
    }
    
}
