package tp5;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelListarPeliculas extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Pelicula> model;
	private JList lista;
	
	public PanelListarPeliculas() {
		cargarPanel();

	}
	
	public void cargarPanel() {
		setLayout(null);
		
		lista = new JList();
		lista.setBounds(109, 58, 331, 197);
		add(lista);
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeliculas.setBounds(36, 131, 63, 25);
		add(lblPeliculas);
	}
	
	
	public void setDefaultListModel(DefaultListModel<Pelicula> modelRecibido) {
		this.model = modelRecibido;
	}
}
