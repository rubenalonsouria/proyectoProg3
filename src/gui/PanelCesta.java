package gui;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCesta extends JPanel{

	private static final long serialVersionUID = 1L;
	
public PanelCesta() {
		setLayout(new FlowLayout());
		
		add(new JLabel("Aqui iria una tabla"));
		
		
		setVisible(true);
		setName("Cesta");
	}

}
