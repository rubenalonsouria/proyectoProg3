package gui;

import java.awt.FlowLayout;

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
	private JButton BotonComprar, botonVolver;
	private JLabel  labelTitulo, labelDuracion, labelSinopsis, labelDirectores, labelGenero, labelValoracion, labelValoracionIcono;
	private JTextField textDuracion, textSinopsis, textActores, textDirectores, textGenero;
	//private static boolean cambioBool;
	
	
	// public static boolean tickDeCarrito() { return cambioBool; }
	 
	 	public PanelInformacionPelicula(Pelicula p, JPanel estePanel) {
		setLayout(new FlowLayout());//Esta ventana estaria bien hacerla con absoloutlayout con ayuda de windowBuielder
									//Solo para coger las posiciones x e y
		botonVolver = new JButton("Volver");
		BotonComprar = new JButton("Añadir al carro");
		
		labelTitulo = new JLabel("Titulo");
		labelDuracion = new JLabel("Duracion");
		labelSinopsis = new JLabel("Sinopsis");
		labelDirectores = new JLabel("Directores");
		labelGenero = new JLabel("Genero");
		labelValoracion = new JLabel("Valoracion");
		labelValoracionIcono = new JLabel();
		
		textDuracion = new JTextField(p.getDuracion());
		textSinopsis = new JTextField(p.getSinopsis());
		textActores = new JTextField(p.getActores().toString()); //Modificar metodo toString para que salga bonito
		textDirectores = new JTextField(p.getDirectores().toString());
		textGenero = new JTextField(p.getGenero().toString());
		
		/*TERMINAR DE CREAR Y ORGASNIZAR VENTANA
		 * * * 
		 * *
		 */
		
		botonVolver.addActionListener((e)->{
			if (VentanaPricipalNueva.getPanelCentral().getComponentCount() > 0) {
				VentanaPricipalNueva.getPanelCentral().remove(0);
				VentanaPricipalNueva.getPanelCentral().revalidate();
				VentanaPricipalNueva.getPanelCentral().repaint();
			}
			VentanaPricipalNueva.getPanelCentral().add(estePanel);
			VentanaPricipalNueva.getPanelCentral().repaint();
			VentanaPricipalNueva.getPanelCentral().revalidate();

		});
		BotonComprar.addActionListener((e)-> {
			if (VentanaIniciarSesion.isSesionIniciada()) {
				Cliente c = VentanaIniciarSesion.clienteIniciado();
				String correo = c.getCorreo();
				String titulo = p.getTitulo();
				BaseDeDatos.anadirCarritoDeCliente(correo, titulo);	//TODO poner un Jspin y habra qeu poner un render de seleccion de asiento y el hilo de a;adiendo...
				JOptionPane.showMessageDialog(null, "Añadida con exito", null, JOptionPane.INFORMATION_MESSAGE);
				//cambioBool = true;
			}else {
				JOptionPane.showMessageDialog(null, "Primero inicia Sesion o Registrate", null, JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			//cambioBool = false;
		});
		
		
		add(botonVolver);
		add(BotonComprar);
		
		setName("Peliculas Disponibles");
		setVisible(true);
	}

}
