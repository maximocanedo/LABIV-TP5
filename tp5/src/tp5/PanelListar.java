package tp5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class PanelListar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelListar() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblPelculas = new JLabel("Pel\u00EDculas");
		lblPelculas.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPelculas, BorderLayout.NORTH);
		
		JList list = new JList();
		list.setModel(Pelicula.model);
		add(list, BorderLayout.CENTER);

	}

}
