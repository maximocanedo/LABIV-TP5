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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setTitle("Trabajo Practico Nº5");
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
				Punto1.Ventana2();
			}
		});
		mnPeliculas.add(miAgregar);
		
		miListar = new JMenuItem("Listar");
		mnPeliculas.add(miListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
