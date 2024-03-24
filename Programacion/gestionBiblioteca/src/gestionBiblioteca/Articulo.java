package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public  class Articulo {
//	libros, revistas y películas (los atributos tenéis que pensarlos).
	final int diasParaDevolver = 15;
	String nombre, idioma;
	
	public Articulo() {
	}

	public Articulo(String nombre,  String idioma) {
		this.nombre = nombre;
		this.idioma = idioma;
	}



	protected static void menuArticulos() {
		System.out.println("╭──────────────── Articulos ────────────────────╮");
        System.out.println("│ 1. Libros.                                    │");
        System.out.println("│ 2. Revistas.                                  │");
        System.out.println("│ 3. Peliculas.                                 │");
        System.out.println("│ 4. Salir                                      │");
        System.out.println("╰───────────────────────────────────────────────╯");

	}
	
	protected static Articulo altaArticuloGenerico(Scanner sc, ArrayList<Articulo> listaArticulos, int tipo) {
		String nombre = null, idioma;
		do {
			System.out.print("Introduce el nombre: ");
			nombre = sc.nextLine();
		} while (!main.comprobarString(nombre, 5));
		do {
			System.out.print("Introduce el idioma: ");
			idioma = sc.nextLine();
		} while (!main.comprobarString(idioma, 4));
		Articulo art = new Articulo(nombre, idioma);
		return art;
	}
}
