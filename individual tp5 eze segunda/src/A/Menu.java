package A;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
	private static JList<Pelicula> ListaPelis;
	//PANEL AGREGAR
	private JPanel panelAgregar = new JPanel();
	private JLabel lbl_idActual;;
	
	//PANEL LISTAR
	private JPanel panelListar = new JPanel();
	
	
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
				panelListar.setVisible(false);
				panelAgregar.setVisible(true);
				panelListar.removeAll();
				
				contentPane.removeAll();
				PanelAgregar();
				contentPane.add(panelAgregar);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
	
		mnPeliculas.add(mntmAgregar);
		
		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				panelAgregar.setVisible(false);
				panelListar.setVisible(true);
				
				panelAgregar.removeAll();
				contentPane.removeAll();
				PanelListar();
				contentPane.add(panelListar);
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
	
	/*
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	*/
	
	public void PanelAgregar() {
		
		
		panelAgregar.setLayout(new MigLayout("", "[][][][23.00][27.00][161.00,grow][][][grow]", "[34.00][25.00][22.00][12.00][][][][]"));
		
		
		JLabel lblAgregarPelicula = new JLabel("Agregar una nueva Pelicula");
		lblAgregarPelicula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgregarPelicula.setForeground(Color.BLUE);
		lblAgregarPelicula.setBackground(Color.WHITE);
		panelAgregar.add(lblAgregarPelicula, "cell 4 0 2 1,alignx center");
		
		JLabel lbl_id = new JLabel("ID :");
		panelAgregar.add(lbl_id, "cell 3 1 2 1,alignx right,aligny bottom");
		
		
		if(modeloMenu.isEmpty()==true) {
			lbl_idActual = new JLabel("1");
		}
		panelAgregar.add(lbl_idActual, "cell 5 1,aligny bottom");
		
		
		JLabel lblNombre = new JLabel("Nombre :");
		panelAgregar.add(lblNombre, "cell 3 2 2 1,alignx right");
		
		JTextField textNombre = new JTextField();
		panelAgregar.add(textNombre, "cell 5 2,growx");
		textNombre.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero :");
		panelAgregar.add(lblGenero, "cell 3 4 2 1,alignx right");
		
		JComboBox<Categoria> cbGenero = new JComboBox<>();
		panelAgregar.add(cbGenero, "cell 5 4,growx");
		
		cbGenero.addItem(new Categoria("Seleccione un genero"));
		cbGenero.addItem(new Categoria("Terror"));
		cbGenero.addItem(new Categoria("Acción"));
		cbGenero.addItem(new Categoria("Suspenso"));
		cbGenero.addItem(new Categoria("Romántica"));
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textNombre.getText().isEmpty() && cbGenero.getSelectedIndex()!=0) {
					Pelicula x = new Pelicula();	
					x.setNombre(textNombre.getText());
					x.setID(Integer.parseInt(lbl_idActual.getText()));
					x.setCategoria(new Categoria(cbGenero.getSelectedItem().toString()));
					
					modeloMenu.addElement(x);
					
					textNombre.setText("");
					cbGenero.setSelectedIndex(0);
					lbl_idActual.setText(Integer.toString(modeloMenu.getSize()+1));
					
			
				}
				else {
					JOptionPane.showMessageDialog(null, "Campos invalidos");
				}
		 }
		});
		panelAgregar.add(btnAceptar, "cell 5 6,alignx center");
				
	
	}
	/*
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	/
	*/
	public void PanelListar() {
		
			
		ListaPelis = new JList<>();
		ListaPelis.setModel(modeloMenu);
		panelListar.setLayout(new MigLayout("", "[90.00][323.00][20.00,fill]", "[][][][][grow]"));
		panelListar.add(ListaPelis, "cell 1 1 1 4,grow");
		
		JLabel lblPeliculas = new JLabel("Peliculas:");
		panelListar.add(lblPeliculas, "cell 0 3,alignx right");
	}
}
