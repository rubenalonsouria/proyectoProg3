package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelInformacionCines extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel labelBara, labelZubi, labelGarbe, labelBoule;
    private JPanel panelImagenes, panelDescripcion;
    private JTextArea descripcionArea;
    
    public PanelInformacionCines() {
        Font font = new Font("Times New Roman", Font.BOLD, 20);

        panelImagenes = new JPanel();
        panelDescripcion = new JPanel(new GridLayout(1, 1));

        // CINES (IMAGENES Y DESCRIPCIONES)
        
        labelBara = crearEtiquetaConEvento("images/BarakaldoMaxCenter.jpg", "Max Center es un centro comercial de Baracaldo, en la provincia vasca de Vizcaya. Es la mayor zona de ocio y restauración de la provincia.", font);
        labelZubi = crearEtiquetaConEvento("images/BilbaoZubi.jpg", "Tiendas variadas, restaurantes y cine en un centro comercial cubierto y elegante con un diseño que aporta sensación de amplitud.", font);
        labelGarbe = crearEtiquetaConEvento("images/SanSebastianGarbera.jpg", "Centro comercial moderno con boutiques chic, artículos para el hogar y varios restaurantes.", font);
        labelBoule = crearEtiquetaConEvento("images/VitoriaBoulevard.jpg", "El Boulevard es un maxicentro comercial situado en la ciudad de Vitoria en el norte de España.", font);
        
        // VENTANA
        
        panelImagenes.setLayout(new GridLayout(2, 2, 5, 5));

        panelImagenes.add(labelBara);
        panelImagenes.add(labelZubi);
        panelImagenes.add(labelGarbe);
        panelImagenes.add(labelBoule);

        descripcionArea = new JTextArea();
        descripcionArea.setEditable(false);
        descripcionArea.setFont(font);
        panelDescripcion.add(descripcionArea);
        
        setLayout(new BorderLayout());
        add(panelImagenes, BorderLayout.NORTH);
        add(panelDescripcion, BorderLayout.CENTER);

        setVisible(true);
        setName("Cines");
        
    }
    
    private JLabel crearEtiquetaConEvento(String rutaImagen, String descripcion, Font font) {
        ImageIcon icono = new ImageIcon(rutaImagen);
        Image logo = icono.getImage();
        JLabel etiqueta = new JLabel(new ImageIcon(logo));

        etiqueta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                descripcionArea.setText(descripcion);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                descripcionArea.setText("");
            }
        });

        return etiqueta;
    }
    
}
