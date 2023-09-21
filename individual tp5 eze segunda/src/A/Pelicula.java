package A;

import A.Categoria;

public class Pelicula {
		Integer ID;
		String nombre;
		Categoria categoria;
		
		public Pelicula(){
			ID= 0;
			this.nombre = "vacio";
			this.categoria = new Categoria("vacio");
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

