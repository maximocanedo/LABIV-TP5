package main;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PanelListar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelListar() {
		setLayout(new MigLayout("", "[grow][grow]", "[][grow][grow]"));
		JLabel lblPelculas = new JLabel("Pel\u00EDculas");
		add(lblPelculas, "cell 0 0");
		
		JList<Pelicula> list = new JList<Pelicula>();
		list.setModel(Pelicula.peliculas);
		add(list, "cell 0 1 2 1,grow");
		setVisible(false);
	}

}
