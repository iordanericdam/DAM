import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

	public Administrador() {
	}

	public Administrador(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña,
			LocalDate fechaNacimiento) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña, fechaNacimiento);
	}
	
	public Administrador(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña);
	}

	public Administrador(String dni, String nombreCompleto, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, nombreUsuario, contraseña);
	}

	protected static void gestionUsuarios(Scanner sc, ArrayList<Usuario> listaUsuarios) {
		String opcionS;
		int opcion, tipo = 0;
		do {
			tipo = elegirAdminCliente(sc);
			switch (tipo) {
			case 1:
				gestionClientesOAdministradores(sc, Cliente.class, listaUsuarios);
				break;
			case 2:
				gestionClientesOAdministradores(sc, Administrador.class, listaUsuarios);
				break;
			case 3:
				System.out.println("Saliendo...");
				break;
			}
		} while (tipo != 3);
	}

	private static void gestionClientesOAdministradores(Scanner sc, Class<? extends Usuario> tipoUsuario, ArrayList<Usuario> listaUsuarios) {
		String opcionS;
		int opcion = 0;
		do {
			if (tipoUsuario.isAssignableFrom(Cliente.class)) {
				 opcion = Menus.mostrarMenuGestionClientes(sc);
			} else if (tipoUsuario.isAssignableFrom(Administrador.class)){
				opcion = Menus.mostrarMenuGestionAdministradores(sc);
			}
			switch (opcion) {
			case 1:
				System.out.println("Alta " + tipoUsuario.getSimpleName() + ":");
				Usuario.altaUsuario(sc, listaUsuarios, tipoUsuario);
				break;
			case 2:
				System.out.println("Baja " + tipoUsuario.getSimpleName() + ":");
				Usuario.bajaUsuario(sc, listaUsuarios, tipoUsuario);
				break;
			case 3:
				System.out.println("Modificar datos " + tipoUsuario.getSimpleName() + ":");
				Usuario.modificarUsuario(sc, listaUsuarios, tipoUsuario);
				break;
			case 4:
				System.out.println("Saliendo...");
				break;

			}
		} while (opcion != 4);

	}

	private static int elegirAdminCliente(Scanner sc) {
		String opcionS;
		int opcion = 0;
		do {
			opcion = Menus.mostrarMenuGestionUsuarios(sc);
			if (opcion == 1 || opcion == 2 || opcion == 3)
				return opcion;
		} while (opcion != 3 && opcion != 2 && opcion != 1);
		return 0;
	}

}
