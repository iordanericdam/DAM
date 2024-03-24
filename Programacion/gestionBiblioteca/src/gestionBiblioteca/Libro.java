package gestionBiblioteca;

import java.util.Scanner;

public class Libro extends Articulo{
	
	String editorial, tapaDura, ISBN, edadLecutra;

	public Libro(String editorial, String tapaDura, String iSBN, String edadLecutra) {
		super();
		this.editorial = editorial;
		this.tapaDura = tapaDura;
		ISBN = iSBN;
		this.edadLecutra = edadLecutra;
	}
	
	
	protected void altaLibro(Scanner sc, Articulo art) {
		do {
			System.out.println("Introduce la editorial");
			editorial = sc.nextLine();
		} while (!main.comprobarString(editorial, 3));
		
		

	}
	
	

}
