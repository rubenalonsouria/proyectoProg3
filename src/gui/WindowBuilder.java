package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;

public class WindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;

	public WindowBuilder() {
		setResizable(false);
		setTitle("DeustoCine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Identificarse");
		panelCentro.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon("imagenes/logodeusto.png"));
		btnNewButton.setSize(getMaximumSize());
		
		JList listaPeliculas = new JList();
		panelCentro.add(listaPeliculas);
		
		
		setVisible(true);
	}
}
