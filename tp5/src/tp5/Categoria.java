package tp5;

public class Categoria {
	private int id; 
	private String nombre;
	
	public static Categoria SIN_CATEGORIA = new Categoria(0, "Sin categoría");
	public static Categoria SELECCIONE_CATEGORIA = new Categoria(-1, "Seleccione una categoría");
	public static Categoria TERROR = new Categoria(1, "Terror");
	public static Categoria ACCION = new Categoria(2, "Acción");
	public static Categoria SUSPENSO = new Categoria(3, "Suspenso");
	public static Categoria ROMANTICA = new Categoria(4, "Romántica");
	public static Categoria[] CATEGORIAS = new Categoria[] {
			SELECCIONE_CATEGORIA,
			TERROR,
			ACCION,
			SUSPENSO,
			ROMANTICA
	};
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
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
