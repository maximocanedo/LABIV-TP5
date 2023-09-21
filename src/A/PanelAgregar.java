package A;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import A.Categoria;
import A.Pelicula;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregar extends JPanel {

	
	private JComboBox<Categoria> cbGenero;
	private JLabel lbl_idActual;
	private JTextField textNombre;
	private DefaultListModel<Pelicula> modelo; 
	
	public PanelAgregar() {
		setLayout(new MigLayout("", "[][][][23.00][27.00][161.00,grow][][][grow]", "[34.00][25.00][22.00][12.00][][][][]"));
		
		modelo = new DefaultListModel<>();
		
		JLabel lblAgregarPelicula = new JLabel("Agregar una nueva Pelicula");
		lblAgregarPelicula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgregarPelicula.setForeground(Color.BLUE);
		lblAgregarPelicula.setBackground(Color.WHITE);
		add(lblAgregarPelicula, "cell 4 0 2 1,alignx center");
		
		JLabel lbl_id = new JLabel("ID :");
		add(lbl_id, "cell 3 1 2 1,alignx right,aligny bottom");
		
		
		if(modelo.isEmpty()==true) {
			lbl_idActual = new JLabel("1");
		}
		add(lbl_idActual, "cell 5 1,aligny bottom");
		
		
		JLabel lblNombre = new JLabel("Nombre :");
		add(lblNombre, "cell 3 2 2 1,alignx right");
		
		textNombre = new JTextField();
		add(textNombre, "cell 5 2,growx");
		textNombre.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero :");
		add(lblGenero, "cell 3 4 2 1,alignx right");
		
		cbGenero = new JComboBox<Categoria>();
		add(cbGenero, "cell 5 4,growx");
		
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
					
					modelo.addElement(x);
					
					textNombre.setText("");
					cbGenero.setSelectedIndex(0);
					lbl_idActual.setText(Integer.toString(modelo.getSize()+1));
					
			
				}
				else {
					JOptionPane.showMessageDialog(null, "Campos invalidos");
				}
		 }
		});
		add(btnAceptar, "cell 5 6,alignx center");
				
	}
	
	public void setDefaultListModel(DefaultListModel<Pelicula> modeloRecibido) {
		this.modelo = modeloRecibido;
	}

}
