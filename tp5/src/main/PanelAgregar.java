package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelAgregar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtNombre;

	/**
	 * Create the panel.
	 */
	public PanelAgregar() {
		setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		JLabel lbID = new JLabel("ID (Generado automáticamente):");
		add(lbID, "cell 0 0,alignx trailing");
		
		txtId = new JTextField();
		txtId.setText("" + (Pelicula.ID + 1));
		txtId.setEditable(false);
		add(txtId, "cell 1 0,growx");
		txtId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		add(lblNombre, "cell 0 1,alignx trailing");
		
		txtNombre = new JTextField();
		add(txtNombre, "cell 1 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		add(lblGnero, "cell 0 2,alignx trailing");
		
		JComboBox<Categoria> cmbGenero = new JComboBox<Categoria>();
		cmbGenero.addItem(Categoria.SELECCIONE_CATEGORIA);
		cmbGenero.addItem(Categoria.TERROR);
		cmbGenero.addItem(Categoria.ACCION);
		cmbGenero.addItem(Categoria.SUSPENSO);
		cmbGenero.addItem(Categoria.ROMANTICA);
		cmbGenero.setSelectedIndex(0);
		
		add(cmbGenero, "cell 1 2,growx");
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				boolean nombreOK = txtNombre.getText().trim().length() > 0;
				boolean catOK = cmbGenero.getSelectedIndex() > 0;
				
				if(nombreOK && catOK) {
					Pelicula pelicula = new Pelicula(txtNombre.getText(), (Categoria)cmbGenero.getSelectedItem());
					Pelicula.peliculas.addElement(pelicula);
					ArrayList<Pelicula> lt = new ArrayList<Pelicula>();
				    for (int i = 0; i < Pelicula.peliculas.getSize(); i++) {
				        lt.add(Pelicula.peliculas.get(i));
				    }

				    Collections.sort(lt, new Comparator<Pelicula>() {
				        @Override
				        public int compare(Pelicula p1, Pelicula p2) {
				            return p1.getNombre().compareToIgnoreCase(p2.getNombre());
				        }
				    });
				    Pelicula.peliculas.clear();
				    for (Pelicula p : lt) {
				    	Pelicula.peliculas.addElement(p);
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
		
		add(btnAgregar, "cell 1 3");
	}

}
