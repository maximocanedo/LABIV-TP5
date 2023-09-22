package tp5;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregar extends JPanel {

    private JTextField textId;
    private JTextField textNombre;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblGenero;
    private JComboBox<Categoria> comboBox;
    private JButton btnAceptar;

    public PanelAgregar() {
        setLayout(null);

        lblID = new JLabel("ID");
        lblID.setBounds(66, 26, 46, 14);
        add(lblID);

        textId = new JTextField();
        textId.setEditable(false);
        textId.setText(Pelicula.getNextIdAsString());
        textId.setBounds(153, 23, 86, 20);
        add(textId);
        textId.setColumns(10);

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

        comboBox = new JComboBox<Categoria>();
        comboBox.setModel(new DefaultComboBoxModel<Categoria>(Categoria.CATEGORIAS));
        comboBox.setBounds(153, 80, 127, 17);
        add(comboBox);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(textNombre.getText().trim().length() > 0 && comboBox.getSelectedItem() != Categoria.SELECCIONE_CATEGORIA) {
        			Pelicula peli = new Pelicula(textNombre.getText(), (Categoria)comboBox.getSelectedItem());
        			Pelicula.model.addElement(peli);
        			// ACÁ HAY QUE ORDENAR TODO ALFABÉTICAMENTE Y VOLVER A GUARDAR EN Pelicula.model. 
        		}
        	}
        });
        btnAceptar.setBounds(66, 122, 89, 23);
        add(btnAceptar);
    }

}
