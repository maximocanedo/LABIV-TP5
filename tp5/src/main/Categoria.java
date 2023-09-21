package main;

public class Categoria {
	
	private int id;
	private String nombre;
	public static Categoria SIN_CATEGORIA = new Categoria(0, "Sin categor�a");
	public static Categoria SELECCIONE_CATEGORIA = new Categoria(-1, "Seleccione una categor�a");
	public static Categoria TERROR = new Categoria(1, "Terror");
	public static Categoria ACCION = new Categoria(2, "Acci�n");
	public static Categoria SUSPENSO = new Categoria(3, "Suspenso");
	public static Categoria ROMANTICA = new Categoria(4, "Rom�ntica");
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
}
