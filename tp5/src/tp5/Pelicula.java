package tp5;

public class Pelicula {
	Integer ID;
	String nombre;
	Categoria categoria;
	
	Pelicula(){
		
	}
	
	public Pelicula(Integer iD, String nombre, Categoria categoria) {
		ID = iD;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return  ID + ". [" + categoria.toString() + "] "+ nombre;
	}
	
}
