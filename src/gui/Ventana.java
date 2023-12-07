package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	private PanelPagos pp;
	private JButton btnP, btnC;
	private PanelDatosCuenta pc;
	private JPanel pCentro,pSur;
	public Ventana() {
		super();
		setBounds(200, 300, 660, 400);
		pp = new PanelPagos(null);
		pc = new PanelDatosCuenta();
		pCentro = new JPanel();
		
		pCentro.add(pp);
		
				add(pc, BorderLayout.EAST);

		pSur = new JPanel();
		btnP = new JButton("P");
		btnC = new JButton("C");
		pSur.add(btnP);
		pSur.add(btnC);
		
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		btnP.addActionListener((e)->{
			pCentro.remove(0);
			pCentro.add(pc);
			repaint();
		});
		
		btnC.addActionListener((e)->{
			pCentro.remove(0);
			pCentro.add(pp);
			repaint();
		});
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ventana();
	}

}
