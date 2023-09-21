package tp5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PanelAgregar extends JPanel {

    private JTextField textId;
    private JTextField textNombre;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblGenero;
    private JComboBox<String> comboBox;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public PanelAgregar() {
        setLayout(null);

        lblID = new JLabel("ID");
        lblID.setBounds(66, 26, 46, 14);
        add(lblID);

        textId = new JTextField();
        textId.setEditable(false);
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

        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Seleccione un género", "Terror", "Acción", "Suspenso", "Romántica" }));
        comboBox.setBounds(153, 80, 127, 17);
        add(comboBox);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(66, 122, 89, 23);
        add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(284, 122, 89, 23);
        add(btnCancelar);
    }
}
