package main;

import javax.swing.DefaultListModel;

public class Pelicula {
	int id;
	String nombre;
	Categoria categoria;
	
	public static int ID = 0;
	public static DefaultListModel<Pelicula> peliculas = new DefaultListModel<Pelicula>();
	
	public Pelicula(String nombre, Categoria categoria) {
		this.id = ID;
		ID++;
		this.nombre = nombre;
		this.categoria = categoria;
	}
	public Pelicula(String nombre) {
		this(nombre, Categoria.SIN_CATEGORIA);
	}
	public Pelicula() {
		this("Película sín título");
	}

	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return  "#" + this.id + " [" + categoria.toString() + "] "+ nombre;
	}
	
}
