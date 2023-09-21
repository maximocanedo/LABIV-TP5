package tp5;

public class Pelicula {
	private int id;
	private String nombre;
	private Categoria categoria;
	
	public static int ID = 0;
	
	public Pelicula(String nombre, Categoria categoria) {
		this.id = ID + 1;
		ID++;
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public Pelicula(String nombre) {
		this(nombre, Categoria.NONE);
	}
	
	public Pelicula(Categoria categoria) {
		this("Película sin nombre", categoria);
	}
	
	public static int getNextId() {
		return ID + 1;
	}
	public static String getNextIdAsString() {
		return "" + (ID + 1);
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
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
		return  this.id + ". [" + categoria.toString() + "] "+ this.nombre;
	}
	
}
