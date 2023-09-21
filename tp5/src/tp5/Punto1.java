package tp5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Punto1 extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JLabel lblID;
	private JLabel lblNombre;
	private JLabel lblGenero;
	private JComboBox comboBox;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void Ventana2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Punto1 frame = new Punto1();
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
	public Punto1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("ID");
		lblID.setBounds(66, 26, 46, 14);
		contentPane.add(lblID);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(153, 23, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(66, 51, 46, 14);
		contentPane.add(lblNombre);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(66, 83, 46, 14);
		contentPane.add(lblGenero);
		
		textNombre = new JTextField();
		textNombre.setBounds(153, 54, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un g\u00E9nero", "Terror", "Acci\u00F3n", "Suspenso", "Rom\u00E1ntica"}));
		comboBox.setBounds(153, 80, 127, 17);
		contentPane.add(comboBox);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(66, 122, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(284, 122, 89, 23);
		contentPane.add(btnCancelar);
	}
}
