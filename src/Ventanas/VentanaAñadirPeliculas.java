package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAñadirPeliculas {

    public static void main(String[] args) {
        VentanaAñadirPeliculas ventana = new VentanaAñadirPeliculas();
        ventana.crearVentana();
    }

    private void crearVentana() {
        JFrame ventana = new JFrame("Añadir película");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel tituloLabel = new JLabel("Título:");
        JTextField tituloField = new JTextField();

        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();

        JLabel anioLabel = new JLabel("Año:");
        JTextField anioField = new JTextField();

        panel.add(tituloLabel);
        panel.add(tituloField);
        panel.add(directorLabel);
        panel.add(directorField);
        panel.add(anioLabel);
        panel.add(anioField);

        JButton añadirButton = new JButton("Añadir película");
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText();
                String director = directorField.getText();
                String anio = anioField.getText();

                if (!titulo.isEmpty() && !director.isEmpty() && !anio.isEmpty()) {
                    // Aquí debería agregar la película a la base de datos 
                    System.out.println("Se añadió la película");
                }
             }
       
    }
 }
}