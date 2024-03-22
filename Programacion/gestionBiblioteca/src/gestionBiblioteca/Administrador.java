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
	
	
	protected static void bajaUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios) {
		System.out.print("Introduce el DNI del usuario que desea eliminar: ");
		String dni = sc.next();
		int i = 0;
		boolean encontrado = false, respuestaBool = false;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (usu instanceof Usuario) {
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
