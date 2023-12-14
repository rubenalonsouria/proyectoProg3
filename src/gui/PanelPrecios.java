package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.MainCine;

public class PanelPrecios extends JPanel {
    private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MainCine.class.getName());
    
    private JCheckBox chkPrecios, chkOfertas;
    private ButtonGroup grupoCheckBoxes;
    private JPanel panelFiltros, panelPrecios;

    public PanelPrecios() {
        // VISTA USUARIO

        Font font = new Font("Times New Roman", Font.BOLD, 20);

        panelFiltros = new JPanel();
        panelPrecios = new JPanel();
        panelPrecios.setLayout(new BoxLayout(panelPrecios, BoxLayout.Y_AXIS));

        chkPrecios = new JCheckBox("Precios");
        chkPrecios.setSelected(true);
        chkOfertas = new JCheckBox("Ofertas");

        grupoCheckBoxes = new ButtonGroup();
        grupoCheckBoxes.add(chkPrecios);
        grupoCheckBoxes.add(chkOfertas);

        // SCROLLPANE
        JScrollPane scrollPane = new JScrollPane(panelPrecios);

        // Crea elementos (imagen + texto) y agregarlos al panelPrecios [CAMBIAR IMAGENES Y TEXTO Y AGREGAR MAS]
        agregarElementoConImagenYTexto(panelPrecios, "images/deustocinelogo.png", "Texto para precios", font);
        agregarElementoConImagenYTexto(panelPrecios, "images/deustocinelogo.png", "Texto para oferta1", font);
        agregarElementoConImagenYTexto(panelPrecios, "images/deustocinelogo.png", "Texto para oferta2", font);
        agregarElementoConImagenYTexto(panelPrecios, "images/deustocinelogo.png", "Texto para otra oferta", font);

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
        setLayout(new BorderLayout(0, 0));

        panelFiltros.add(chkPrecios);
        panelFiltros.add(chkOfertas);

        panelFiltros.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelFiltros.setBackground(Color.BLUE);
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
        elementoPanel.add(lblImagen);
        elementoPanel.add(txtArea);

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

        for (int i = 0; i < panelPrecios.getComponentCount(); i++) {
            JPanel elementoPanel = (JPanel) panelPrecios.getComponent(i);
            JTextArea txtArea = (JTextArea) elementoPanel.getComponent(1);

            boolean esOferta = txtArea.getText().toLowerCase().contains("oferta");

            boolean mostrarElemento = (mostrarPrecios && !esOferta) || (mostrarOfertas && esOferta);

            elementoPanel.setVisible(mostrarElemento);
        }

        panelPrecios.revalidate();
        panelPrecios.repaint();
    }
}
