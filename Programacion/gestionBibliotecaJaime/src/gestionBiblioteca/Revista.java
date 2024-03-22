package gestionBiblioteca;

public class Revista extends Articulo {

	
	protected String genero;
	protected Integer numRevista;
	
	
	protected Revista(String titulo, String estado, String genero, Integer numRevista) {
		super(titulo, estado);
		this.genero = genero;
		this.numRevista = numRevista;
	}


	protected String getGenero() {
		return genero;
	}


	protected void setGenero(String genero) {
		this.genero = genero;
	}


	protected Integer getNumRevista() {
		return numRevista;
	}


	protected void setNumRevista(Integer numRevista) {
		this.numRevista = numRevista;
	}
	
}
