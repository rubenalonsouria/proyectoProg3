package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.MainCine;

public class PanelPrecios extends JPanel{
	private static final long serialVersionUID = 1L;

	private JCheckBox chkPrecios, chkOfertas;
	private ButtonGroup grupoCheckBoxes;
	private JTextArea txtPrecios, txtOferta1, txtOferta2;
	private JPanel panelFiltros, panelPrecios;
	private JScrollPane scrollPane;
	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	
	public PanelPrecios() {
		
		/* VISTA USUARIO */
		
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		
		panelFiltros = new JPanel(new FlowLayout());
		panelPrecios = new JPanel(new BorderLayout());
		
		chkPrecios = new JCheckBox("Precios");
		chkOfertas = new JCheckBox("Ofertas");
		
        grupoCheckBoxes = new ButtonGroup();
        grupoCheckBoxes.add(chkPrecios);
        grupoCheckBoxes.add(chkOfertas);

        txtPrecios = new JTextArea("test precio");
        txtOferta1 = new JTextArea("test oferta1");
        txtOferta2 = new JTextArea("test oferta2");
        
        scrollPane = new JScrollPane(panelPrecios);
        
        /* ACTION LISTENERS */
		
        chkPrecios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFiltro();
            }
        });
        chkOfertas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFiltro();
            }
        });
        
		/* VENTANA */
		setLayout(new BorderLayout(0, 0));
		
		panelFiltros.add(chkPrecios);
		panelFiltros.add(chkOfertas);
		
		panelPrecios.add(txtPrecios);
		panelPrecios.add(txtOferta1);
		panelPrecios.add(txtOferta2);
		
		panelFiltros.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelFiltros.setBackground(Color.BLUE);
		add(panelFiltros, BorderLayout.NORTH);
		
		panelPrecios.setBackground(Color.DARK_GRAY);
		add(panelPrecios, BorderLayout.CENTER);
		
		add(scrollPane);
		
		setVisible(true);
		setName("Precios");
	}
       
    private void actualizarFiltro() {
        //Implementar Logica
    	txtPrecios.setVisible(chkPrecios.isSelected());
    	txtOferta1.setVisible(chkOfertas.isSelected());
    	txtOferta2.setVisible(chkOfertas.isSelected());
    }     
        
}
