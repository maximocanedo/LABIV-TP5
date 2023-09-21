package A;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import A.PanelAgregar;
import A.PanelListar;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986913309612654801L;
	private JMenuBar menuBar;
	private JMenu mnPeliculas;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmListar;
	
	private JPanel contentPane;
	private static DefaultListModel<Pelicula> modeloMenu;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setTitle("Trabajo Practico Nº 5");
					modeloMenu = new DefaultListModel<>();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPeliculas = new JMenu("Peliculas");
		menuBar.add(mnPeliculas);
		
		mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				//Abrir panel ingreso peliculas
				PanelAgregar panel1 = new PanelAgregar();
				panel1.setDefaultListModel(modeloMenu);
				contentPane.add(panel1,BorderLayout.CENTER);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPeliculas.add(mntmAgregar);
		
		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				PanelListar panel2 = new PanelListar();
				panel2.setDefaultListModel(modeloMenu);
				contentPane.add(panel2,BorderLayout.CENTER);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPeliculas.add(mntmListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
