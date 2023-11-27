package gui;

import javax.swing.*;

import main.MainCine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class VentanaConBusqueda extends JFrame {
    
    private static final long serialVersionUID = 1L;
	private JTextField campoBusqueda;
    private JButton buscar;
    protected JPanel panelCuenta, panelCuentaIzquierda, panelCuentaDerecha, panelCine, panelCinesInforamcion;
    private static Logger logger = Logger.getLogger(MainCine.class.getName());

    public VentanaConBusqueda() {
		
    	
        setTitle("Ventana con Búsqueda");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        
        campoBusqueda = new JTextField();
        buscar = new JButton("Buscar");

        
        setLayout(new FlowLayout());

        
        add(new JLabel("Buscar: "));
        add(campoBusqueda);
        add(buscar);

        
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarBusqueda();
            }
        });
    }

    private void realizarBusqueda() {
        //  implementar la lógica de busqueda 
        // por ahora solo se muestra un mensaje con el texto buscado
        String textoBusqueda = campoBusqueda.getText();
        JOptionPane.showMessageDialog(this, "Realizando búsqueda con: " + textoBusqueda);
    }
    
    
}
