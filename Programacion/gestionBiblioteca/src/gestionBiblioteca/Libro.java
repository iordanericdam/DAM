package gestionBiblioteca;

public class Libro extends Articulo {
	
	int ISBN;
	String genero;
	String autor;
	
	
	public Libro(int diasParaDevolver, String idioma, String nombre, boolean disponible, int iSBN, String autor, int genero) {
		super(diasParaDevolver, idioma, nombre, disponible);
		ISBN = iSBN;
		this.autor = autor;
		this.genero = obtenerNombreGenero(genero);
	}
	
	public Libro() {
		
	}
	
	
	
	
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	protected static void mostrarMenuGeneros() {
	    System.out.println("╔════════════════════════════════════════════╗");
	    System.out.println("║             Menú de Géneros de Libros      ║");
	    System.out.println("╠════════════════════════════════════════════╣");
	    System.out.println("║ 1. Acción                                  ║");
	    System.out.println("║ 2. Misterio                                ║");
	    System.out.println("║ 3. Ciencia Ficción                         ║");
	    System.out.println("║ 4. Fantasía                                ║");
	    System.out.println("║ 5. Romance                                 ║");
	    System.out.println("║ 6. Terror                                  ║");
	    System.out.println("║ 7. Otro                                    ║");
	    System.out.println("╚════════════════════════════════════════════╝");
	}
	
	private String obtenerNombreGenero(int genero) {
		switch (genero) {
		case 1:
            return "Acción";
        case 2:
            return "Misterio";
        case 3:
            return "Ciencia Ficción";
        case 4:
            return "Fantasía";
        case 5:
            return "Romance";
        case 6:
            return "Terror";
        default:
            return "Otro";
		
		}
	}
	
	
    @Override
    public String toString() {
        return String.format("Nombre: %s%n" +
                             "ISBN: %d%n" +
                             "Autor: %s%n" +
                             "Género: %s%n" +
                             "Idioma: %s%n" +
                             "Días para devolver: %d%n" +
                             "Disponible: %s%n",
                             getNombre(), ISBN, autor, genero, getIdioma(), getDiasParaDevolver(), isDisponible() ? "Sí" : "No");
    }
	
}
