package tp5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnPeliculas;
	private JMenuItem miAgregar;
	private JMenuItem miListar;
	private PanelAgregar panelAgregar;
	private PanelListar panelListar;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 230);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		 mnPeliculas = new JMenu("Peliculas");
		menuBar.add(mnPeliculas);
		
		miAgregar = new JMenuItem("Agregar");
		miAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregar.setVisible(true);
				panelListar.setVisible(false);
				
			}
		});
		mnPeliculas.add(miAgregar);
		
		miListar = new JMenuItem("Listar");
		miListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregar.setVisible(false);
				panelListar.setVisible(true);
				
			}
		});
		mnPeliculas.add(miListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panelAgregar = new PanelAgregar();
		panelAgregar.setBounds(0, 0, 393, 170);
		contentPane.add(panelAgregar);
		
		panelListar = new PanelListar();
		panelListar.setBounds(0,0,393,170);
		contentPane.add(panelListar);
		
		panelAgregar.setVisible(true);
		panelListar.setVisible(false);
	}
}
