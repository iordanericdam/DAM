package gestionBiblioteca;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		ArrayList<Prestamo> prestamos = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<Articulo> articulos = new ArrayList<>();
		String usuario,contraseña;
		boolean salir=false;
		int opcion=0;
		
		
		/**Voy a crear varios objetos de cada clase para q no tenga q ir creando uno a uno (Se podría hacer perfectamente). **/
		
		Administrador admin = new Administrador("admin","1234");
		
		Cliente c1 = new Cliente("jsas","1234","Jaime","Salvador");
		Cliente c2 = new Cliente("frod","1111","Fernando","Rodríguez");
		Cliente c3 = new Cliente("pepem","1122","Pepe","Muñíz");
		
		Libro lib1 = new Libro ("Falcó","Bueno","Arturo Pérez Reverte","Anaya","12345678");
		Libro lib2 = new Libro ("El problema Final","Bueno","Arturo Pérez Reverte","Alfaguara","12345452");
		Pelicula pel1 = new Pelicula ("Memorias de África","Bueno","Drama",1985);
		Revista rev1 = new Revista ("Hola","Bueno","Corazón",103);
		
		Prestamo pres1 = new Prestamo(lib1,c1);
		Prestamo pres2 = new Prestamo(pel1,c2);
		

		
		usuarios.add(admin);
		usuarios.add(c1);
		usuarios.add(c2);
		usuarios.add(c3);
		articulos.add(lib1);
		articulos.add(lib2);
		articulos.add(pel1);
		articulos.add(rev1);
		prestamos.add(pres1);
		prestamos.add(pres2);
		
        do {
            menu.iniciarSesion(sc, prestamos, usuarios, articulos);
            
            System.out.println("¿Desea salir del programa? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                salir = true;
            }
        } while (!salir);

	}


}
