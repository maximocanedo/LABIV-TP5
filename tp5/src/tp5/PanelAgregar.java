package tp5;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        			// ACÁ HAY QUE ORDENAR TODO ALFABÉTICAMENTE Y VOLVER A GUARDAR EN Pelicula.model. 
        			String msj="";
    				msj+= textNombre.getText().toString().trim().isEmpty() ? "- Debe ingresar nombre de la pelicula\n":  "";
    				msj+=(comboBox.getSelectedItem() == Categoria.SELECCIONE_CATEGORIA) ? "- Debe seleccionar Genero": "";	
    				
    				if((comboBox.getSelectedItem() == Categoria.SELECCIONE_CATEGORIA)	
    						|| textNombre.getText().toString().trim().isEmpty()) {
    					JOptionPane.showMessageDialog(null,msj,"Validando Datos",
    								JOptionPane.ERROR_MESSAGE);
    				}else {
    				
    					String nombrePel = textNombre.getText();
						String catElegida = ((Categoria) comboBox.getSelectedItem()).toString();
						boolean PELICULA_REPETIDA=false;
						
						for(int i=0; i < Pelicula.model.size() && !PELICULA_REPETIDA; i++) {
							nombrePel=nombrePel.toLowerCase();
							String nombrePelDlm=Pelicula.model.get(i).getNombre().toLowerCase();
							if(nombrePel.compareTo(nombrePelDlm) == 0 && (catElegida.compareTo(Pelicula.model.get(i).getCategoria().getNombre()) == 0)) {
								PELICULA_REPETIDA=true;	
								JOptionPane.showMessageDialog(null, "LA PELÍCULA INGRESADA YA SE ENCUENTRA REGISTRADA", "Advertencia", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						if(!PELICULA_REPETIDA) {
							Pelicula nuevaPel = new Pelicula(textNombre.getText(),(Categoria)comboBox.getSelectedItem());
							
							Pelicula.model.addElement(nuevaPel);
							
							if(Pelicula.model.size() > 1) {
								ordenarElementos(Pelicula.model);
							}
							lblIDNuevo.setText(Pelicula.getNextIdAsString());
	    					
	    					JOptionPane.showMessageDialog(null,"Pelicula Agregada Correctamente!","Validando Datos",
    							JOptionPane.INFORMATION_MESSAGE);
						}
	            			
    				
    				}
        			
        		textNombre.setText("");
        		comboBox.setSelectedItem(Categoria.SELECCIONE_CATEGORIA);
        	}
        });
        btnAceptar.setBounds(66, 122, 89, 23);
        add(btnAceptar);
        
    
    }
    private void ordenarElementos(DefaultListModel<Pelicula> dlmPeliculasAux) {
		ArrayList<Pelicula> coleccionPel = new ArrayList<Pelicula>();
		
		for(int i =0; i < dlmPeliculasAux.size(); i++) {
			coleccionPel.add(dlmPeliculasAux.get(i));
		}
		
		dlmPeliculasAux.removeAllElements();
		
		Collections.sort(coleccionPel, new Comparator<Pelicula>() {
			@Override
			public int compare(Pelicula objPel1, Pelicula objPel2) {
				return objPel1.getNombre().compareTo(objPel2.getNombre());
			}				
		});
		
		for(Pelicula pelAux : coleccionPel) {
			dlmPeliculasAux.addElement(pelAux);
		}			
	}
    
    
}
