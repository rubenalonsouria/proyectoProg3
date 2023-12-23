package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import main.MainCine;

public class PanelPrecios extends JPanel {
    private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MainCine.class.getName());
    
    private JCheckBox chkPrecios, chkOfertas;
    private ButtonGroup grupoCheckBoxes;
    private JPanel panelFiltros, panelMostrarPrecios;

    public PanelPrecios() {
        
    	// VISTA USUARIO
        Font font = new Font("Times New Roman", Font.BOLD, 20);

        panelFiltros = new JPanel();
        panelMostrarPrecios = new JPanel();
        panelMostrarPrecios.setLayout(new BoxLayout(panelMostrarPrecios, BoxLayout.Y_AXIS));

        chkPrecios = new JCheckBox("Precios");
        chkPrecios.setSelected(true);
        chkOfertas = new JCheckBox("Ofertas");

        grupoCheckBoxes = new ButtonGroup();
        grupoCheckBoxes.add(chkPrecios);
        grupoCheckBoxes.add(chkOfertas);

        // SCROLLPANE
        JScrollPane scrollPane = new JScrollPane(panelMostrarPrecios);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        
        
        // Crea elementos (imagen + texto) y agregarlos al panelMostrarPrecios [CAMBIAR IMAGENES Y TEXTO Y AGREGAR MAS]
        // PRECIOS
        agregarElementoConImagenYTexto(panelMostrarPrecios, "images/adultosCine.jpg", "PRECIOS PARA ADULTOS\r\n"
        		+ "El precio para los adultos es 11,4€", font);
        agregarElementoConImagenYTexto(panelMostrarPrecios, "images/niñosCine.jpg", "PRECIOS PARA NIÑOS MAYORES DE 13 AÑOS\r\n"
        		+ "El precio para los niños mayo	res de 13 años es 8,4€", font);
        agregarElementoConImagenYTexto(panelMostrarPrecios, "images/seniorCine.jpg", "PRECIOS PARA SENIOR\r\n"
        		+ "El precio para los mayores de 60 años es 8,4€", font);
        
        // OFERTAS
        agregarElementoConImagenYTexto(panelMostrarPrecios, "images/seniorCine.jpg", "MARTES DE CINE A 2€\r\n"
        		+ "¡Los mayores de 65 años ya podéis disfrutar de esta oferta por solo 2€ la entrada!", font);
        agregarElementoConImagenYTexto(panelMostrarPrecios, "images/parejaCine.jpg", "¡CINE EN PAREJA AL MEJOR PRECIO!\r\n"
        		+ "Oferta valida cuando compras 2 entradas a la vez", font);
        agregarElementoConImagenYTexto(panelMostrarPrecios, "images/genteCine.jpg", "¡PARA AUTÉNTICOS FANS DEL CINE!\r\n"
        		+ "Utiliza los puntos para conseguir una oferta increible", font);
        agregarElementoConImagenYTexto(panelMostrarPrecios, "images/adultosCine.jpg", "ENTRADAS POR 9,90€ LOS MIERCOLES\r\n"
        		+ "¡Aprovecha esta oferta solo disponible los miercoles!", font);
        
        
        
        // ACTION LISTENERS
        chkPrecios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFiltro();
                logger.log(Level.INFO, "SE HA PULSADO LA CHECKBOX PRECIOS");
            }
        });

        chkOfertas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFiltro();
                logger.log(Level.INFO, "SE HA PULSADO LA CHECKBOX OFERTAS");
            }
        });
        
        

        // VENTANA
        setLayout(new BorderLayout());

        panelFiltros.add(chkPrecios);
        panelFiltros.add(chkOfertas);
        
        panelFiltros.setPreferredSize(new Dimension(1190, 50));
        add(panelFiltros, BorderLayout.NORTH);
        
        add(scrollPane, BorderLayout.CENTER);
        
        
        setVisible(true);
        setName("Precios");
        
        // Asegurarse de que al menos una checkbox esté seleccionada por defecto
        actualizarFiltro();
    }

    private void agregarElementoConImagenYTexto(JPanel panel, String rutaImagen, String texto, Font font) {
        ImageIcon icon = new ImageIcon(rutaImagen);
        JLabel lblImagen = new JLabel(icon);

        JTextArea txtArea = new JTextArea(texto);
        establecerPropiedadesJTextArea(txtArea, font);

        JPanel elementoPanel = new JPanel();
        elementoPanel.setLayout(new BoxLayout(elementoPanel, BoxLayout.X_AXIS));
        elementoPanel.add(lblImagen, BorderLayout.WEST);
        elementoPanel.add(txtArea, BorderLayout.CENTER);

        panel.add(elementoPanel);
    }

    private void establecerPropiedadesJTextArea(JTextArea jTextArea, Font font) {
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEditable(false);
        jTextArea.setFont(font);
        jTextArea.setOpaque(false);
    }

    private void actualizarFiltro() {
        boolean mostrarPrecios = chkPrecios.isSelected();
        boolean mostrarOfertas = chkOfertas.isSelected();

        for (int i = 0; i < panelMostrarPrecios.getComponentCount(); i++) {
            JPanel elementoPanel = (JPanel) panelMostrarPrecios.getComponent(i);
            JTextArea txtArea = (JTextArea) elementoPanel.getComponent(1);

            boolean esOferta = txtArea.getText().toLowerCase().contains("oferta");

            boolean mostrarElemento = (mostrarPrecios && !esOferta) || (mostrarOfertas && esOferta);

            elementoPanel.setVisible(mostrarElemento);
        }

        panelMostrarPrecios.revalidate();
        panelMostrarPrecios.repaint();
    }
}
