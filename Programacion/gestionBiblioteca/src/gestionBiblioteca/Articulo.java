package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Articulo {
//	libros, revistas y películas (los atributos tenéis que pensarlos).
	int diasParaDevolver = 15;
	String idioma, nombre;
	boolean disponible;

	public Articulo() {
	}

	public Articulo(int diasParaDevolver, String idioma, String nombre, boolean disponible) {
		this.diasParaDevolver = diasParaDevolver;
		this.idioma = idioma;
		this.nombre = nombre;
		this.disponible = disponible;
	}

	public int getDiasParaDevolver() {
		return diasParaDevolver;
	}

	public void setDiasParaDevolver(int diasParaDevolver) {
		this.diasParaDevolver = diasParaDevolver;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	protected static void altaArticulo(int tipo, ArrayList<Articulo> listaArticulos, Articulo art, Scanner sc) {

		String nombre = null, idioma = null, diasParaDevolucionS, ISBNs, autor, eleccionGeneroS, editor, ISSNs,
				eleccionTematicaS, director, clasificacionEdadS;
		boolean disponible = false;
		int diasParaDevolucion = 0, ISBN = 0, genero = 0, ISSN = 0, tematica = 0, clasificacionEdad;

		if (tipo != 4) {
			System.out.print("Introduce el nombre: ");
			nombre = sc.nextLine();
			disponible = main.obtenerRespuestaSiNo(sc, "¿El articulo esta disponible?");
			do {
				System.out.print("¿En cuantos dias se debe devolver? ");
				diasParaDevolucionS = sc.next();
				diasParaDevolucion = main.comprobarSiNumero(diasParaDevolucionS);
				sc.nextLine();
			} while (diasParaDevolucion == 0);

			System.out.print("Introduce el idioma: ");
			idioma = sc.nextLine();
		} else {
			System.out.println("Saliendo...");
		}

		switch (tipo) {
		case 1:
			do {
				System.out.print("Introduce el ISBN del libro: ");
				ISBNs = sc.next();
				ISBN = main.comprobarSiNumero(ISBNs);
				sc.nextLine();
			} while (ISBN == 0);
			System.out.print("Introduce el/los autor/es del libreo: ");
			autor = sc.nextLine();
			do {
				Libro.mostrarMenuGeneros();
				eleccionGeneroS = sc.next();
				genero = main.comprobarSiNumero(eleccionGeneroS);
				sc.nextLine();
			} while (genero == 0);

			art = new Libro(diasParaDevolucion, idioma, nombre, disponible, ISBN, autor, genero);
			listaArticulos.add((Libro) art);
			break;
		case 2:
			do {
				System.out.print("Introduce el ISSN de la revista: ");
				ISSNs = sc.next();
				ISSN = main.comprobarSiNumero(ISSNs);
				sc.nextLine();
			} while (ISSN == 0);
			
			System.out.print("Introduce el/los editor/es de la revista: ");
			editor = sc.nextLine();
			do {
				Libro.mostrarMenuGeneros();
				eleccionTematicaS = sc.next();
				tematica = main.comprobarSiNumero(eleccionTematicaS);
				sc.nextLine();
			} while (tematica == 0);

			art = new Revista(diasParaDevolucion, idioma, nombre, disponible, ISSN, editor, tematica);
			listaArticulos.add((Revista) art);
			break;
		case 3:
			System.out.print("Introduce el nombre del Director/es: ");
			director = sc.nextLine();
			do {
				Pelicula.mostrarMenuGenerosPelicula();
				eleccionGeneroS = sc.next();
				genero = main.comprobarSiNumero(eleccionGeneroS);
				sc.nextLine();
			} while (genero == 0);
			do {
				Pelicula.mostrarMenuClasificacionEdadPelicula();
				clasificacionEdadS = sc.next();
				clasificacionEdad = main.comprobarSiNumero(clasificacionEdadS);
				sc.nextLine();
			} while (clasificacionEdad == 0);
			
			art = new Pelicula(diasParaDevolucion, idioma, nombre, disponible, director, genero, clasificacionEdad);
			listaArticulos.add((Pelicula) art);

			break;

		}

	}

	protected static void mostrarMenuArticulos() {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║             Articulos                      ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║ 1. Libro                                   ║");
		System.out.println("║ 2. Revista                                 ║");
		System.out.println("║ 3. Película                                ║");
		System.out.println("║ 4. Salir                                   ║");
		System.out.println("╚════════════════════════════════════════════╝");
	}

	protected static void consultarArticulos(ArrayList<Articulo> listaArticulos) {
		for (Articulo art : listaArticulos) {
			if (art instanceof Libro) {
				System.out.println(art.toString());
			} else if (art instanceof Revista) {
				System.out.println(art.toString());
			} else if (art instanceof Pelicula) {
				System.out.println(art.toString());
			}
		}

	}
}
