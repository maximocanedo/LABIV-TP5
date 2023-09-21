package A;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class PanelListar extends JPanel {

	private JList<Pelicula> list;
	private DefaultListModel<Pelicula> modelo;
	
	public PanelListar() {
		modelo = new DefaultListModel<>();
		cargarPanel();
	}
	
	public void cargarPanel() {
		
		list = new JList<>();
		list.setModel(modelo);
		//JScrollPane scrollPane = new JScrollPane(list);

		setLayout(new MigLayout("", "[90.00][323.00][20.00,fill]", "[][][][][grow]"));
		add(list, "cell 1 1 1 4,grow");
		//add(scrollPane, "cell 1 1 1 4,grow");
		
		JLabel lblPeliculas = new JLabel("Peliculas:");
		add(lblPeliculas, "cell 0 3,alignx right");

	}
	public void setDefaultListModel(DefaultListModel<Pelicula> modeloRecibido) {
		this.modelo = modeloRecibido;
	}

}
