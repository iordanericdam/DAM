package gestionBiblioteca;

public class Pelicula  extends Articulo{
	
	String director, genero, clasificacionEdad;

	public Pelicula(int diasParaDevolver, String idioma, String nombre, boolean disponible, String director, int genero, int clasificacionEdad) {
		super(diasParaDevolver, idioma, nombre, disponible);
		this.director = director;
		this.genero = convertirNumeroAGeneroPelicula(genero);
		this.clasificacionEdad = convertirNumeroAClasificacionEdad(clasificacionEdad);
	}
	
	public Pelicula() {
		
	}
	
	protected static void mostrarMenuGenerosPelicula() {
	    System.out.println("╔════════════════════════════════════════════╗");
	    System.out.println("║           Menú de Géneros de Películas      ║");
	    System.out.println("╠════════════════════════════════════════════╣");
	    System.out.println("║ 1. Acción                                   ║");
	    System.out.println("║ 2. Aventura                                 ║");
	    System.out.println("║ 3. Comedia                                  ║");
	    System.out.println("║ 4. Drama                                    ║");
	    System.out.println("║ 5. Fantasía                                 ║");
	    System.out.println("║ 6. Terror                                   ║");
	    System.out.println("║ 7. Ciencia ficción                          ║");
	    System.out.println("║ 8. Romance                                  ║");
	    System.out.println("║ 9. Documental                               ║");
	    System.out.println("║ 10. Animación                               ║");
	    System.out.println("║ 11. Muscial                                 ║");
	    System.out.println("║ 12. Misterio                                ║");
	    System.out.println("║ 13. Suspense                                ║");
	    System.out.println("║ 14. Crimen                                  ║");
	    System.out.println("╚════════════════════════════════════════════╝");
	}

	
	protected static void mostrarMenuClasificacionEdadPelicula() {
	    System.out.println("╔════════════════════════════════════════════╗");
	    System.out.println("║      Menú de Clasificaciones de Películas   ║");
	    System.out.println("╠════════════════════════════════════════════╣");
	    System.out.println("║ 1. G (Apta para todos los públicos)        ║");
	    System.out.println("║ 2. PG (Sugiere la guía de los padres)      ║");
	    System.out.println("║ 3. PG-13 (No recomendada para menores de 13 años) ║");
	    System.out.println("║ 4. R (Restringida, menores de 17 años requieren acompañamiento de un adulto) ║");
	    System.out.println("║ 5. NC-17 (Prohibida para menores de 17 años)║");
	    System.out.println("╚════════════════════════════════════════════╝");
	}
	
	
	protected static String convertirNumeroAClasificacionEdad(int numClasificacion) {
	    switch (numClasificacion) {
	        case 1:
	            return "G (Apta para todos los públicos)";
	        case 2:
	            return "PG (Sugiere la guía de los padres)";
	        case 3:
	            return "PG-13 (No recomendada para menores de 13 años)";
	        case 4:
	            return "R (Restringida, menores de 17 años requieren acompañamiento de un adulto)";
	        case 5:
	            return "NC-17 (Prohibida para menores de 17 años)";
	        default:
	            return "Otro";
	    }
	}

	protected static String convertirNumeroAGeneroPelicula(int numGenero) {
	    switch (numGenero) {
	        case 1:
	            return "Acción";
	        case 2:
	            return "Aventura";
	        case 3:
	            return "Comedia";
	        case 4:
	            return "Drama";
	        case 5:
	            return "Fantasía";
	        case 6:
	            return "Terror";
	        case 7:
	            return "Ciencia ficción";
	        case 8:
	            return "Romance";
	        case 9:
	            return "Documental";
	        case 10:
	            return "Animación";
	        case 11:
	            return "Musical";
	        case 12:
	            return "Misterio";
	        case 13:
	            return "Suspense";
	        case 14:
	            return "Crimen";
	        default:
	            return "Otro";
	    }
	}
	
	
    @Override
    public String toString() {
        return String.format("---------Pelicula------------- %n" + 
        		        	 "Nombre: %s%n" +
                             "Director: %s%n" +
                             "Género: %s%n" +
                             "Clasificación por Edad: %s%n" +
                             "Idioma: %s%n" +
                             "Días para devolver: %d%n" +
                             "Disponible: %s%n",
                             getNombre(), director, genero, clasificacionEdad, getIdioma(), getDiasParaDevolver(), isDisponible() ? "Sí" : "No");
    }



	
	
	
}
