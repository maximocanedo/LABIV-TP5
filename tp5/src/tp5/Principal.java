package tp5;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Principal {
	
	private static DefaultListModel<Pelicula> dfModel;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dfModel = new DefaultListModel<Pelicula>();
					Ventana frame = new Ventana(dfModel);
					frame.setTitle("Trabajo Practico Nº5");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
