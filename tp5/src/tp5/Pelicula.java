package tp5;

public class Pelicula {
	int id;
	String nombre;
	Categoria categoria;
	
	public static int ID = 0;
	
	public Pelicula(){
		
	}
	
	public Pelicula(int id, String nombre, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
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
