//		Tenéis que realizar un aplicación para llevar a cabo la gestión de la biblioteca. Dicha aplicación podrán usarla dos tipos de usuarios:
//
//			1.- Administradores: Pueden ser varios y sus tareas son:
//
//			Dar de alta usuarios para poder hacer los préstamos.
//			Penalizar a los usuarios si no se devuelven en fecha, de tal manera que durante unos días no podrá llevarse ningún artículo.
//			Dar de alta artículos
//			Dar de baja artículos.
//			Ver los préstamos de un cliente, diferenciando cuales están en activos y cuales no.

//			2.- Usuarios: Podrán hacer las siguientes tareas:
//
//			Hacer un préstamo o varios a la vez.
//			Hacer una devolución o varias a la vez.
//			Ver sus préstamos en activo para ver los días que le quedan para la devolución.
//			Los artículos que puede llevarse el cliente son: libros, revistas y películas (los atributos tenéis que pensarlos).

package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
		Articulo art = new Articulo();

//		Creacion de usuarios de administrador
		Administrador admin1 = new Administrador("admin", "admin", "46660198Y", "Admin");
		listaUsuarios.add((Administrador) admin1);
		Administrador admin2 = new Administrador("edurne", "edurne", "50322180C", "Edurne");
		listaUsuarios.add((Administrador) admin2);

		Usuario usuario1 = new Usuario("eric", "eric", "80560285W", "Eric Iordan", false);
		listaUsuarios.add(usuario1);
		Usuario usuario2 = new Usuario("david", "david", "00188202Q", "David Gil", false);
		listaUsuarios.add(usuario2);

		// Crear libros
		Libro libro1 = new Libro(14, "Español", "Cien años de soledad", true, 4652, "Gabriel García Márquez", 4);
		Libro libro2 = new Libro(21, "Inglés", "To Kill a Mockingbird", true, 36524, "Harper Lee", 12);
		Libro libro3 = new Libro(10, "Francés", "Le Petit Prince", true, 789651, "Antoine de Saint-Exupéry", 5);

		// Crear revistas
		Revista revista1 = new Revista(7, "Español", "National Geographic", true, 112255, "National Geographic Society",
				1);
		Revista revista2 = new Revista(7, "Inglés", "Scientific American", true, 885533, "Springer Nature", 2);
		Revista revista3 = new Revista(7, "Francés", "Paris Match", true, 99966, "Lagarde Family", 6);

		// Crear películas
		Pelicula pelicula1 = new Pelicula(3, "Inglés", "The Shawshank Redemption", true, "Frank Darabont", 5, 6);
		Pelicula pelicula2 = new Pelicula(3, "Español", "El Laberinto del Fauno", true, "Guillermo del Toro", 2, 3);
		Pelicula pelicula3 = new Pelicula(3, "Inglés", "Inception", true, "Christopher Nolan", 4, 55);

		// Añadir los artículos a la lista
		listaArticulos.add(libro1);
		listaArticulos.add(libro2);
		listaArticulos.add(libro3);
		listaArticulos.add(revista1);
		listaArticulos.add(revista2);
		listaArticulos.add(revista3);
		listaArticulos.add(pelicula1);
		listaArticulos.add(pelicula2);
		listaArticulos.add(pelicula3);

		Usuario usu = new Usuario();

		String nombreUsuario, pass, opcionS;
		int opcion = 0;
		System.out.println("Bienvenido/a a la bibloteca Todo Libros");
		do {
//			System.out.println("Recuerda que si es la primera vez que inicia sesion debe poner como contaseña el DNI/NIE en MAYUSCULAS");
			System.out.print("Introduce tu nombre de usuario: ");
			nombreUsuario = sc.nextLine().toLowerCase();
			System.out.print("Introduce tu contrseña: ");
			pass = sc.nextLine();
			usu = Administrador.comprobarCredenciales(listaUsuarios, sc, nombreUsuario, pass);
			if (usu instanceof Administrador) {
				do {
					Administrador.mostrarMenuAdmin();
					System.out.print("Opcion: ");
					opcionS = sc.nextLine();
					opcion = comprobarSiNumero(opcionS);
					switch (opcion) {
					case 1:
						Administrador.altaUsuario(sc, listaUsuarios, usu);
						break;
					case 2:
						Administrador.bajaUsuario(sc, listaUsuarios);
						break;
					case 3:
						Usuario.consultarUsuarios(listaUsuarios);
						break;
					case 4:
						do {
							opcion = Articulo.obtenerTipoArtiuclo(sc);
							if (opcion != 4) {
								Articulo.altaArticulo(opcion, listaArticulos, art, sc);
							}
						} while (opcion != 4);
						break;
					case 5:
						do {
							opcion = Articulo.obtenerTipoArtiuclo(sc);
							if (opcion != 4) {
								Articulo.bajaArticulo(opcion, listaArticulos, sc);
							}
						} while (opcion != 4);
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						do {

						} while (opcion != 4);
						Articulo.consultarArticulos(listaArticulos);
						break;
					}
				} while (opcion != 7);

			} else if (!(usu instanceof Administrador)) {
				try {
					if (usu.isPrimerLogin()) {
						Usuario.primerLogin(sc, usu);
						sc.nextLine();
					}
					do {
						Usuario.mostrarMenuUsuario();
						System.out.print("Opcion: ");
						opcionS = sc.nextLine();
						opcion = comprobarSiNumero(opcionS);
						switch (opcion) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;

						}

					} while (opcion != 4);

				} catch (NullPointerException e) {
				}
			}
		} while (true);
	}

	protected static int comprobarSiNumero(String numeroS) {
		int opcion = 0;
		try {
			opcion = Integer.parseInt(numeroS);
			if (opcion < 0) {
				System.out.println("Debes introducir un número mayor o igual que 0.");
				opcion = -1;
			}
		} catch (Exception e) {
			System.out.println("Debes introducir un numero.");

		}
		return opcion;
	}

	protected static boolean comprobarString(String variableS, int caracteres) {
		boolean correcto = false;
		if (variableS.length() < caracteres) {
			System.out.println("La longitud debe de ser minimo de " + caracteres + " caracteres");
		} else {
			correcto = true;
		}
		return correcto;

	}

	protected static boolean obtenerRespuestaSiNo(Scanner sc, String pregunta) {
		boolean respuesta;
		while (true) {
			System.out.print(pregunta + " (responda con si o no): ");
			char respuestaChar = sc.next().toLowerCase().charAt(0);
			if (respuestaChar == 's') {
				respuesta = true;
				break;
			} else if (respuestaChar == 'n') {
				respuesta = false;
				break;
			} else {
				System.out.println("Por favor, responda con si o no.");
			}
		}
		return respuesta;
	}



}
