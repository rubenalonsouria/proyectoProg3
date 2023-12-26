package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Cine.Cine;

public class PanelInformacionCines extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel panelImagenes, panelDescripcion;
    private JTextArea descripcionArea;

    public PanelInformacionCines() {
        Font font = new Font("Times New Roman", Font.BOLD, 20);

        panelImagenes = new JPanel();
        panelDescripcion = new JPanel();

        Cine cineBara = new Cine("Max Center", "images/BarakaldoMaxCenter.jpg",
                "Max Center es un centro comercial de Baracaldo, en la provincia vasca de Vizcaya. Es la mayor zona de ocio y restauración de la provincia.");
        Cine cineZubi = new Cine("Bilbao Zubi", "images/BilbaoZubi.jpg",
                "Tiendas variadas, restaurantes y cine en un centro comercial cubierto y elegante con un diseño que aporta sensación de amplitud.");
        Cine cineGarbe = new Cine("San Sebastian Garbera", "images/SanSebastianGarbera.jpg",
                "Centro comercial moderno con boutiques chic, artículos para el hogar y varios restaurantes.");
        Cine cineBoule = new Cine("Vitoria Boulevard", "images/VitoriaBoulevard.jpg",
                "El Boulevard es un maxicentro comercial situado en la ciudad de Vitoria en el norte de España.");

        panelImagenes.setLayout(new GridLayout(2, 0, 5, 5));

        panelImagenes.add(crearEtiquetaConEvento(cineBara, font));
        panelImagenes.add(crearEtiquetaConEvento(cineZubi, font));
        panelImagenes.add(crearEtiquetaConEvento(cineGarbe, font));
        panelImagenes.add(crearEtiquetaConEvento(cineBoule, font));

        descripcionArea = new JTextArea();
        descripcionArea.setEditable(false);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        descripcionArea.setFont(font);

        panelDescripcion.setLayout(new BoxLayout(panelDescripcion, BoxLayout.Y_AXIS));
        panelDescripcion.add(descripcionArea);

        setLayout(new BorderLayout());
        add(panelImagenes, BorderLayout.NORTH);
        add(panelDescripcion, BorderLayout.CENTER);

        setVisible(true);
        setName("Cines");
    }

    // Método para crear una etiqueta con evento de ratón
    private JLabel crearEtiquetaConEvento(Cine cine, Font font) {
        ImageIcon icono = new ImageIcon(cine.getImagenCine());
        Image logo = icono.getImage();
        JLabel etiqueta = new JLabel(new ImageIcon(logo));

        etiqueta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                descripcionArea.setText(cine.getDescripcionCine());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                descripcionArea.setText("");
            }
        });

        return etiqueta;
    }
}
