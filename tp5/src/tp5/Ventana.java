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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Ventana extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnPeliculas;
	private JMenuItem miAgregar;
	private JMenuItem miListar;
	
	private static DefaultListModel<Pelicula> modeloMenu;
	
		
	public Ventana(DefaultListModel<Pelicula> modeloRecibido) {
		this.modeloMenu =	modeloRecibido;
		contentPane = new JPanel();
		contentPane.setLayout(null); // Nota. Seteá el layout que quieras		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 260);
		setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		 mnPeliculas = new JMenu("Peliculas");
		menuBar.add(mnPeliculas);
		
		miAgregar = new JMenuItem("Agregar");
		miAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				//Abrir panel ingreso peliculas
				PanelAgregarPelicula panel1 = new PanelAgregarPelicula();
				panel1.setDefaultListModel(modeloMenu);
				contentPane.add(panel1);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnPeliculas.add(miAgregar);

		miListar = new JMenuItem("Listar");
		miListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					PanelListarPeliculas panel2 = new PanelListarPeliculas();
					panel2.setDefaultListModel(modeloMenu);
					contentPane.add(panel2);
					contentPane.repaint();
					contentPane.revalidate();
					
			}
		});
		mnPeliculas.add(miListar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
