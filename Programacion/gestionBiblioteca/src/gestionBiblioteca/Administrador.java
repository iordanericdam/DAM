package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {
	
	public Administrador(String nombreUsuario, String pass, String dni, String nombreCompleto) {
		super(nombreUsuario, pass, dni, nombreCompleto);
	}
	
	
	protected static int comprobarCredencialesAdmin(ArrayList<Usuario> listaUsuarios, Scanner sc, String nombreUsuario,
			String pass) {
		int i = 0, respuesta = 0;
		boolean encontrado = false;

		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (usu instanceof Administrador) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
					if (usu.getPass().equals(pass)) {
						return 1;
					} else {
						respuesta = -2;
					}
				}
			} else {
				respuesta = -1;
			}

			i++;

		}
		return respuesta;

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
	
	

}
