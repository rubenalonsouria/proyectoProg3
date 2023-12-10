package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.MainCine;

public class PanelPrecios extends JPanel{
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MainCine.class.getName());
	
	public PanelPrecios() {
		
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		
		JTextArea test = new JTextArea("test");
        test.setLineWrap(true);
        test.setWrapStyleWord(true);
        test.setEditable(false);
        test.setFont(font);
        test.setOpaque(false);
		
		setLayout(new GridLayout(0, 3, 5, 5));
		
		add(test);
		
		setVisible(true);
		setName("Precios");
	}
}
