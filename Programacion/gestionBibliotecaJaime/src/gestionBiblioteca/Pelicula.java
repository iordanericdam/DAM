package gestionBiblioteca;

public class Pelicula extends Articulo {

	protected String genero;
	protected Integer año;
	
	
	protected Pelicula(String titulo, String estado, String genero, Integer año) {
		super(titulo, estado);
		this.genero = genero;
		this.año = año;
	}


	protected String getGenero() {
		return genero;
	}


	protected void setGenero(String genero) {
		this.genero = genero;
	}


	protected Integer getAño() {
		return año;
	}


	protected void setAño(Integer año) {
		this.año = año;
	}
	
	
	
}
