package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

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

		Scanner sc = new Scanner(System.in);
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

//		Creacion de usuarios de administrador
		Administrador admin1 = new Administrador("juan", "juan", "46660198Y", "Juan Gomez");
		listaUsuarios.add((Administrador) admin1);
		Administrador admin2 = new Administrador("edurne", "edurne", "50322180C", "Edurne");
		listaUsuarios.add((Administrador) admin2);

		Usuario usuario1 = new Usuario("alberto", "alberto123", "80560285W", "Alberto Blein");
		listaUsuarios.add(usuario1);
		Usuario usuario2 = new Usuario("david", "david123", "00188202Q", "David Gil");
		listaUsuarios.add(usuario2);

		Usuario usu = new Usuario();

		String nombreUsuario, pass, opcionS;
		int opcion = 0;
		
		do {
			System.out.println("Bienvenido/a a la bibloteca Todo Libros");
			System.out.print("Introduce tu nombre de usuario: ");
			nombreUsuario = sc.nextLine().toLowerCase();
			System.out.print("Introduce tu contrseña: ");
			pass = sc.nextLine();
			int comprobarCredenciales = Administrador.comprobarCredencialesAdmin(listaUsuarios, sc, nombreUsuario, pass);
			switch (comprobarCredenciales) {
			case 1:
				do {
					Administrador.mostrarMenuAdmin();
					opcionS = sc.nextLine();
					opcion = comprobarSiNumero(opcionS);
					switch (opcion) {
					case 1:
						Usuario.altaUsuario(sc, listaUsuarios, usu);
						break;
					case 2:
						Usuario.bajaUsuario(sc, listaUsuarios);
						break;
					case 3:
						Usuario.consultarUsuarios(listaUsuarios);
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					}

				} while (opcion != 7);

				break;
			case -2:
				System.out.println("Contraseña incorrecta");
				break;
			case -1:
				comprobarCredenciales = Usuario.comprobarCredencialesUsuario(listaUsuarios, sc, nombreUsuario, pass);
				switch (comprobarCredenciales) {
				case 1:
					do {
						Usuario.mostrarMenuUsuario();
						opcionS = sc.nextLine();
						opcion = comprobarSiNumero(opcionS);
					} while (opcion !=4);
					
					break;
				case -2:
					System.out.println("Contraseña incorrecta");
					break;
				case -3:
					System.out.println("Usuario incorrecto");
					break;
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
				opcion = 0;
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
