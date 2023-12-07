package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCines extends JPanel{
	private JButton btn;
	public PanelCines() {
		super();
		setLayout(new BorderLayout());
		btn = new JButton("BOTÓN");
		add(btn, BorderLayout.SOUTH);
		setVisible(true);
		
	}

}
