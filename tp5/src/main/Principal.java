package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JList;

public class Principal extends JFrame {

	private JPanel rootPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPanel panelAgregar, panelListar;
	private DefaultListModel<Pelicula> peliculas;

	
	public Principal() {
		peliculas = new DefaultListModel<Pelicula>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		rootPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelAgregar = new PanelAgregar();
		rootPane.add(panelAgregar);
		
		panelAgregar.setVisible(true);
		
		
		panelListar = new PanelListar();
		rootPane.add(panelListar);
		panelListar.setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPeliculas = new JMenu("Pel\u00EDculas");
		menuBar.add(mnPeliculas);
		
		JMenuItem mntmAgregar = new JMenuItem("A\u00F1adir");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAgregar.setVisible(true);
				panelListar.setVisible(false);
			}
		});
		mnPeliculas.add(mntmAgregar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregar.setVisible(false);
				panelListar.setVisible(true);
			}
		});
		mnPeliculas.add(mntmListar);
		
		
	}

}
