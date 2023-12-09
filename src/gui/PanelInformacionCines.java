package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.MainCine;

public class PanelInformacionCines extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private ImageIcon iconoIdentificarse, iconoZubi, iconoMax, iconoBoulevard, iconoGarbera;
	private JLabel labelLogo, labelBara, labelZubi, labelGarbe, labelBoule;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	
	
	public PanelInformacionCines() {
		
		//Imagenes Cine fuente y descripciones
		
		ImageIcon iconoBarakaldo = new ImageIcon("images/BarakaldoMaxCenter.jpg");
		Image logoBarakaldo = iconoBarakaldo.getImage();
		labelBara = new JLabel(new ImageIcon(logoBarakaldo));
		
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		
        JTextArea descripcionBara = new JTextArea(
        		"Max Center es un centro comercial de Baracaldo, en la provincia vasca de Vizcaya. "
        		+ "Es la mayor zona de ocio y restauración de la provincia.");
        descripcionBara.setLineWrap(true);
        descripcionBara.setWrapStyleWord(true);
        descripcionBara.setEditable(false);
        descripcionBara.setFont(font);
        descripcionBara.setOpaque(false);
		
		ImageIcon iconoZubi = new ImageIcon("images/BilbaoZubi.jpg");
		Image logoZubi = iconoZubi.getImage();
		labelZubi = new JLabel(new ImageIcon(logoZubi));
		
        JTextArea descripcionZubi = new JTextArea(
        		"Tiendas variadas, restaurantes y cine en un centro comercial cubierto"
        		+ " y elegante con un diseño que aporta sensación de amplitud.");
        descripcionZubi.setLineWrap(true);
        descripcionZubi.setWrapStyleWord(true);
        descripcionZubi.setEditable(false);
		descripcionZubi.setFont(font);
		descripcionZubi.setOpaque(false);
        
		ImageIcon iconoGarbera = new ImageIcon("images/SanSebastianGarbera.jpg");
		Image logoGarbera = iconoGarbera.getImage();
		labelGarbe = new JLabel(new ImageIcon(logoGarbera));
		
        JTextArea descripcionGarbe = new JTextArea(
        		"Centro comercial moderno con boutiques chic, "
        		+ "artículos para el hogar y varios restaurantes.");
        descripcionGarbe.setLineWrap(true);
        descripcionGarbe.setWrapStyleWord(true);
        descripcionGarbe.setEditable(false);
		descripcionGarbe.setFont(font);
		descripcionGarbe.setOpaque(false);
        
		ImageIcon iconoBoule = new ImageIcon("images/VitoriaBoulevard.jpg");
		Image logoBoule = iconoBoule.getImage();
		labelBoule = new JLabel(new ImageIcon(logoBoule));
		
        JTextArea descripcionBoule = new JTextArea(
        		"El Boulevard es un maxicentro comercial situado"
        		+ " en la ciudad de Vitoria en el norte de España.");
        descripcionBoule.setLineWrap(true);
        descripcionBoule.setWrapStyleWord(true);
        descripcionBoule.setEditable(false);
		descripcionBoule.setFont(font);
		descripcionBoule.setOpaque(false);
		
		setLayout(new GridLayout(0, 4, 5, 5));
		
		add(labelBara);
        add(descripcionBara);
        add(labelZubi);
        add(descripcionZubi);
        add(labelGarbe);
        add(descripcionGarbe);
        add(labelBoule);
        add(descripcionBoule);
		
		setVisible(true);
		setName("Cines");
	}

	
}
