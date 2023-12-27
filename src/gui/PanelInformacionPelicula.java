package gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Pelicula.Pelicula;
import Usuarios.Cliente;
import main.BaseDeDatos;

public class PanelInformacionPelicula extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton botonVolver, botonComprar;
    private JLabel labelTitulo, labelDuracion, labelSinopsis, labelDirectores, labelGenero, labelValoracion,
            labelValoracionIcono;
    private JTextField textDuracion, textActores, textDirectores, textGenero;
    private JTextArea textSinopsis;

    public PanelInformacionPelicula(Pelicula p, JPanel estePanel) {
        setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));

        botonVolver = new JButton("Volver");
        botonComprar = new JButton("Añadir al carro");

        //HACE FALTA AÑADIR POSTER Y ORDENARLO BIEN (ADEMAS DE AÑADIR COMENTARIOS)
        
        labelTitulo = new JLabel(p.getTitulo());
        labelDuracion = new JLabel("Duración: ");
        labelSinopsis = new JLabel("Sinopsis: ");
        labelDirectores = new JLabel("Directores: ");
        labelGenero = new JLabel("Género: ");
        labelValoracion = new JLabel("Valoración: ");
        labelValoracionIcono = new JLabel();

        
        //Hay que hacer que si no eres admin no lo puedes modificar.
        textDuracion = new JTextField(p.getDuracion()); //HAY QUE AÑADIR LAS DURACIONES 
        textActores = new JTextField(String.join(", ", p.getActores()));
        textDirectores = new JTextField(String.join(", ", p.getDirectores()));
        textGenero = new JTextField(p.getGenero().toString());
        textSinopsis = new JTextArea(p.getSinopsis());
        textSinopsis.setLineWrap(true);
        textSinopsis.setWrapStyleWord(true);
        textSinopsis.setEditable(false);

        // Añadir componentes al panel
        add(labelTitulo);
        add(labelDuracion);
        add(textDuracion);
        add(labelSinopsis);
        add(textSinopsis);
        add(labelDirectores);
        add(textDirectores);
        add(labelGenero);
        add(textGenero);
        add(labelValoracion);

        // Añadir un espacio vertical entre los botones y la información de la película
        add(Box.createVerticalStrut(10));

        add(botonVolver);
        add(botonComprar);
        botonVolver.addActionListener((e) -> {
			if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
				VentanaPricipalNueva.getPanelCentral().remove(0);
				VentanaPricipalNueva.getPanelCentral().revalidate();
				VentanaPricipalNueva.getPanelCentral().repaint();
			}
			VentanaPricipalNueva.getPanelCentral().add(estePanel);
			VentanaPricipalNueva.getPanelCentral().repaint();
			VentanaPricipalNueva.getPanelCentral().revalidate();
        });

        botonComprar.addActionListener((e) -> {
			if (VentanaIniciarSesion.isSesionIniciada()) {
				Cliente c = VentanaIniciarSesion.clienteIniciado();
				String correo = c.getCorreo();
				String titulo = p.getTitulo();
				BaseDeDatos.anadirCarritoDeCliente(correo, titulo);	//TODO poner un Jspin y habra qeu poner un render de seleccion de asiento y el hilo de a;adiendo...
				JOptionPane.showMessageDialog(null, "Añadida con exito", null, JOptionPane.INFORMATION_MESSAGE);
				//cambioBool = true;
			} else {
				JOptionPane.showMessageDialog(null, "Primero inicia Sesion o Registrate", null, JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			//cambioBool = false;
        });
    }
}
