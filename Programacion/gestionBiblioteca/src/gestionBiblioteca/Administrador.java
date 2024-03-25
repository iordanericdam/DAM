package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {
	
	public Administrador(String nombreUsuario, String pass, String dni, String nombreCompleto) {
		super(nombreUsuario, pass, dni, nombreCompleto);
	}
	
	
	protected static void mostrarMenuAdmin() {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║           Menu de Administrador        ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Dar de alta un usuario.             ║");
		System.out.println("║ 2. Dar de baja un usuario.             ║");
		System.out.println("║ 3. Penalizar usuarios.                 ║");
		System.out.println("║ 4. Dar de alta un articulo.            ║");
		System.out.println("║ 5. Dar de baja un articulo.            ║");
		System.out.println("║ 6. Consultar prestamos.                ║");
		System.out.println("║ 7. Cerrar sesion.                      ║");
		System.out.println("╚════════════════════════════════════════╝");
	}
	
	
	protected static Usuario comprobarCredenciales(ArrayList<Usuario> listaUsuarios, Scanner sc,
			String nombreUsuario, String pass) {
		boolean encontrado = false;
		int i = 0, respuesta = 0;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			//Utilizo !(usu instanceof Administrador) para separar los usaurios de los administradores ya que todos son usuarios.
//			Busco USUARIOS
			if (!(usu instanceof Administrador)) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
					if (usu.getPass().equals(pass)) {
						System.out.println("Bienvenid@ " + usu.getNombreCompleto());
						return usu;
					} else {
						System.out.println("Contraseña incorrecta");
					}
				} 
//			Busco ADMINISTRADORES
			} else if(usu instanceof Administrador ) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
					if (usu.getPass().equals(pass)) {
						System.out.println("Bienvenid@ " + usu.getNombreCompleto());
						return usu;
					} else {
						System.out.println("Contraseña incorrecta!!");
					}
				} else {
					respuesta = -3;
				}
				
			}
			i++;
		}
		if (respuesta == -3) {
			System.out.println("Usuario no encontrado");
		}
		return null;
	}
	
	protected static void altaUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios, Usuario usu) {
		String nombreCompleto, dni, passProvisional, nombreUsuario;
		boolean entradaCorrecta = false, respuestaBool = false;

		do {
			System.out.print("Introduce el nombre completo: ");
			nombreCompleto = sc.nextLine();
		} while (!main.comprobarString(nombreCompleto, 5));
		do {
			System.out.print("Introduce el DNI o NIE: ");
			dni = sc.next().toUpperCase();

			if (!validarDNI(dni) && !validarNIE(dni)) {
				System.out.println("El DNI o NIE introducidos son incorrectos.");
				respuestaBool = main.obtenerRespuestaSiNo(sc, "¿Deseas volver a escribirlo?");
			} else {
				respuestaBool = false;
				entradaCorrecta = true;
			}

			if (comprobarUsaurio(dni, listaUsuarios)) {
				respuestaBool = main.obtenerRespuestaSiNo(sc, "¿Deseas escribir otro DNI?");
				entradaCorrecta = false;
			}

			sc.nextLine();
		} while (respuestaBool);

		if (entradaCorrecta) {
			do {
				System.out.print("Introduce el nombre de usuario que desearia tener: ");
				nombreUsuario = sc.next().toLowerCase();

				if (Usuario.comprobarNombreUsuario(nombreUsuario, listaUsuarios)) {
					System.out.println("El nombre de usuario ya esta en el sistema");
				}
				sc.nextLine();

			} while (Usuario.comprobarNombreUsuario(nombreUsuario, listaUsuarios));

			passProvisional = dni;
			System.out.println("Para iniciar sesion, debereas poner el nombre de usuario y tu dni como contraseña");
			System.out.println("A continuacion tendra que cambiar la contraseña");

			usu = new Usuario(nombreUsuario, passProvisional, dni, nombreCompleto);
			listaUsuarios.add(usu);

		}

	}
	

	
	
	protected static void bajaUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios) {
		String dni;
		System.out.print("Introduce el DNI del usuario que desea eliminar: ");
		dni = sc.nextLine();
		int i = 0;
		boolean encontrado = false, respuestaBool = false;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (!(usu instanceof Administrador)) {
				if (usu.getDni().equals(dni)) {
					respuestaBool = main.obtenerRespuestaSiNo(sc,
							"¿Seguro que dese eliminar a " + usu.getNombreCompleto() + "?");
					encontrado = true;
					if (respuestaBool) {
						listaUsuarios.remove(i);
					} else {
						System.out.println("Vuelve caundo estes seguro");
					}
				}

			}
			sc.nextLine();
			i++;
		} 
		
		if (!encontrado) {
			System.out.println("Usaurio no encontrado");
		}
	}
	
	

}
