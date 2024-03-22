package gestionBiblioteca;

public class Libro extends Articulo {
	
	protected String autor,editorial,isbn;
	
	protected Libro(String titulo, String estado, String autor, String editorial, String isbn) {
		super(titulo, estado );
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
	}

	protected String getAutor() {
		return autor;
	}

	protected void setAutor(String autor) {
		this.autor = autor;
	}

	protected String getEditorial() {
		return editorial;
	}

	protected void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	protected String getIsbn() {
		return isbn;
	}

	protected void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
	
}
