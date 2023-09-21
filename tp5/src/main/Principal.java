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
	private JTextField txtId;
	private JTextField txtNombre;

	
	public Principal() {
		peliculas = new DefaultListModel<Pelicula>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		rootPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelAgregar = new JPanel();
		panelAgregar.setBackground(UIManager.getColor("Panel.background"));
		rootPane.add(panelAgregar);
		panelAgregar.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lbID = new JLabel("ID (Generado automáticamente):");
		panelAgregar.add(lbID, "cell 0 0,alignx trailing");
		
		txtId = new JTextField();
		txtId.setText("" + (Pelicula.ID + 1));
		txtId.setEditable(false);
		panelAgregar.add(txtId, "cell 1 0,growx");
		txtId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panelAgregar.add(lblNombre, "cell 0 1,alignx trailing");
		
		txtNombre = new JTextField();
		panelAgregar.add(txtNombre, "cell 1 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		panelAgregar.add(lblGnero, "cell 0 2,alignx trailing");
		
		JComboBox<Categoria> cmbGenero = new JComboBox<Categoria>();
		cmbGenero.addItem(Categoria.SELECCIONE_CATEGORIA);
		cmbGenero.addItem(Categoria.TERROR);
		cmbGenero.addItem(Categoria.ACCION);
		cmbGenero.addItem(Categoria.SUSPENSO);
		cmbGenero.addItem(Categoria.ROMANTICA);
		cmbGenero.setSelectedIndex(0);
		
		panelAgregar.add(cmbGenero, "cell 1 2,growx");
		
		JButton btnAgregar = new JButton("Agregar");
		/*public void actionPerformed(ActionEvent e) {
				
				
				
			}*/
		btnAgregar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean nombreOK = txtNombre.getText().trim().length() > 0;
				boolean catOK = cmbGenero.getSelectedIndex() > 0;
				
				if(nombreOK && catOK) {
					Pelicula pelicula = new Pelicula(txtNombre.getText(), (Categoria)cmbGenero.getSelectedItem());
					peliculas.addElement(pelicula);
					ArrayList<Pelicula> lt = new ArrayList<Pelicula>();
				    for (int i = 0; i < peliculas.getSize(); i++) {
				        lt.add(peliculas.get(i));
				    }

				    Collections.sort(lt, new Comparator<Pelicula>() {
				        @Override
				        public int compare(Pelicula p1, Pelicula p2) {
				            return p1.getNombre().compareToIgnoreCase(p2.getNombre());
				        }
				    });
				    peliculas.clear();
				    for (Pelicula p : lt) {
				        peliculas.addElement(p);
				    }
					
					
					JOptionPane.showMessageDialog(null, "La película se añadió con éxito. ");
					txtId.setText("" + (Pelicula.ID + 1));
					txtNombre.setText("");
					cmbGenero.setSelectedIndex(0);
				} else {
					JOptionPane.showMessageDialog(null, "Error. Complete los campos requeridos. ");
				}
				 
			}
		});
		
		panelAgregar.add(btnAgregar, "cell 1 3");
		panelAgregar.setVisible(true);
		
		panelListar = new JPanel();
		panelListar.setBackground(UIManager.getColor("Panel.background"));
		rootPane.add(panelListar);
		panelListar.setLayout(new MigLayout("", "[grow][grow]", "[][grow][grow]"));
		
		JLabel lblPelculas = new JLabel("Pel\u00EDculas");
		panelListar.add(lblPelculas, "cell 0 0");
		
		JList<Pelicula> list = new JList<Pelicula>();
		list.setModel(peliculas);
		panelListar.add(list, "cell 0 1 2 1,grow");
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
