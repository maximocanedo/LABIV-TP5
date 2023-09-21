package tp5;

public class Categoria {
	private int id; 
	private String nombre;
	
	public static Categoria NONE = new Categoria(0, "Sin categoría");
	
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return  nombre;
	}
	
}
