package A;

public class Categoria {
	
	String nombre;
	
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return  nombre;
	}
	
}

