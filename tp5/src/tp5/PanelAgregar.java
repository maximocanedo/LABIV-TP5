package tp5;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PanelAgregar extends JPanel {
    private JTextField textNombre;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblGenero;
    private JComboBox<Categoria> comboBox;
    private JButton btnAceptar;
    private JLabel lblIDNuevo;

    public PanelAgregar() {
        setLayout(null);

        lblID = new JLabel("ID");
        lblID.setBounds(66, 26, 46, 14);
        add(lblID);

        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(66, 51, 46, 14);
        add(lblNombre);

        lblGenero = new JLabel("Genero");
        lblGenero.setBounds(66, 83, 46, 14);
        add(lblGenero);

        textNombre = new JTextField();
        textNombre.setBounds(153, 54, 86, 20);
        add(textNombre);
        textNombre.setColumns(10);
        
        lblIDNuevo = new JLabel(Pelicula.getNextIdAsString());
        lblIDNuevo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblIDNuevo.setBounds(153, 26, 138, 14);
        add(lblIDNuevo);
        
        comboBox = new JComboBox<Categoria>();
        comboBox.setModel(new DefaultComboBoxModel<Categoria>(Categoria.CATEGORIAS));
        comboBox.setBounds(153, 80, 184, 17);
        add(comboBox);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(textNombre.getText().trim().length() > 0 && comboBox.getSelectedItem() != Categoria.SELECCIONE_CATEGORIA) {
        			Pelicula peli = new Pelicula(textNombre.getText(), (Categoria)comboBox.getSelectedItem());
        			Pelicula.model.addElement(peli);
        			lblIDNuevo.setText(Pelicula.getNextIdAsString());
        			// ACÁ HAY QUE ORDENAR TODO ALFABÉTICAMENTE Y VOLVER A GUARDAR EN Pelicula.model. 
        			
        			JOptionPane.showMessageDialog(null, "La película se añadió con éxito. ");
        		} else {
        			JOptionPane.showMessageDialog(null, "Complete todos los campos para continuar. ");
        		}
        		textNombre.setText("");
        		comboBox.setSelectedItem(Categoria.SELECCIONE_CATEGORIA);
        	}
        });
        btnAceptar.setBounds(66, 122, 89, 23);
        add(btnAceptar);
        
    
    }
}
