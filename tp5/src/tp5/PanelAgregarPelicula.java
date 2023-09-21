package tp5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregarPelicula extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
		private JComboBox<Categoria> cbGeneros;
		private JLabel lbl_IDActual;
		private JButton btnAceptar;
		private JPanel panelAgregar;
		private JTextField textField;
		
		private DefaultListModel<Pelicula> modeloAgregarPeli;
		
	public PanelAgregarPelicula() {
		DibujarPanel();
	}
		
	public void DibujarPanel() {	
		panelAgregar = new JPanel();
		panelAgregar.setBounds(0, 0, 468, 200);
		
		panelAgregar.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(178, 51, 136, 20);
		panelAgregar.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(92, 54, 46, 14);
		panelAgregar.add(lblNombre);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setBounds(92, 85, 46, 14);
		panelAgregar.add(lblGenero);
		
		
		cbGeneros = new JComboBox<Categoria>();
		cbGeneros.setBounds(178, 82, 136, 20);
		panelAgregar.add(cbGeneros);
		//carga de combobox
		cbGeneros.addItem(new Categoria("Seleccione un genero"));
		cbGeneros.addItem(new Categoria("Terror"));
		cbGeneros.addItem(new Categoria("Acción"));
		cbGeneros.addItem(new Categoria("Suspenso"));
		cbGeneros.addItem(new Categoria("Romántica"));
		
		
		JLabel lbl_ID = new JLabel("ID :");
		lbl_ID.setBounds(92, 23, 46, 14);
		panelAgregar.add(lbl_ID);
		
		
		lbl_IDActual = new JLabel("");
		lbl_IDActual.setBounds(178, 23, 136, 14);
		panelAgregar.add(lbl_IDActual);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(!textField.getText().isEmpty() && cbGeneros.getSelectedIndex()!=0) {
				Pelicula x = new Pelicula();	
			x.setNombre(textField.getText());
			x.setID(Integer.parseInt(lbl_IDActual.getText()));
			x.setCategoria(new Categoria(cbGeneros.getSelectedItem().toString()));
			
			modeloAgregarPeli.addElement(x);
			}
		  }
		});
		btnAceptar.setBounds(131, 124, 89, 23);
		panelAgregar.add(btnAceptar);
		
		}
	
	
	public void setDefaultListModel(DefaultListModel<Pelicula> modelRecibido) {
		this.modeloAgregarPeli = modelRecibido;
	}
	
}
