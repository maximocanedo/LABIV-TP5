package tp5;

public class Categoria {
	Integer ID; 
	String nombre;
	
	public Categoria(Integer iD, String nombre) {
		super();
		ID = iD;
		this.nombre = nombre;
	}
	public Integer getID() {
		return ID;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return  nombre;
	}
	
}
