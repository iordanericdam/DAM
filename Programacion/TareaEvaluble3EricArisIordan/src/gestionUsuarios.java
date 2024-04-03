import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class gestionUsuarios {
	
	protected static Usuario comprobarCredenciales(ArrayList<Usuario> listaUsuarios, Scanner sc) {
		String nombreUsuario, pass;
		System.out.print("Introdcue el nombre de usario: ");
		nombreUsuario = sc.next();
		System.out.print("Introduce la contraseña: ");
		pass = sc.next();
		boolean encontrado = false;
		int i = 0;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
//			Busco USUARIOS
			if (usu instanceof Cliente) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
					if (usu.getContraseña().equals(pass)) {
						System.out.println("Bienvenid@ " + usu.getNombreCompleto());
						return usu;
					} else {
						System.out.println("Contraseña incorrecta");
					}
				}
//			Busco ADMINISTRADORES

			} else if (usu instanceof Administrador) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
					if (usu.getContraseña().equals(pass)) {
						System.out.println("Bienvenid@ " + usu.getNombreCompleto());
						return usu;
					} else {
						System.out.println("Contraseña incorrecta!!");
					}
				}

			}
			i++;
		}
		if (!encontrado) {
			System.out.println("Usuario no encontrado");
		}
		return null;
	}
	
	protected static void altaUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios,
			Class<? extends Usuario> tipoUsuario) {
		String dni = null, nombreCompleto, email, nombreUsuario, contraseña, passProvisional, fechaNacimientoS;
		int edad;
		boolean entradaCorrecta = false, respuestaBool = false;
		LocalDate fechaNacimiento;

		nombreCompleto = controlDatos.pedirNombreCompleto(sc, tipoUsuario);
		dni = controlDatos.pedirDniNuevo(sc, tipoUsuario, listaUsuarios);
		if (dni != null) {
			fechaNacimiento = controlDatos.pedirFecha(sc, "Por favor, introduce tu fecha de nacimiento (en formato DD/MM/AAAA): ");
			nombreUsuario = controlDatos.pedirNombreUsuario(sc, listaUsuarios);
			email = controlDatos.pedirEmail(sc);
			passProvisional = dni;
			System.out.println("Para iniciar sesion, debereas poner el nombre de usuario y tu dni como contraseña");
			System.out.println("A continuacion tendra que cambiar la contraseña");

			if (tipoUsuario.isAssignableFrom(Cliente.class)) {
				Usuario usu = new Cliente(dni, nombreCompleto, email, nombreUsuario, passProvisional, fechaNacimiento);
				listaUsuarios.add((Cliente) usu);
			} else if (tipoUsuario.isAssignableFrom(Administrador.class)) {
				Usuario usu = new Administrador(dni, nombreCompleto, email, nombreUsuario, passProvisional,
						fechaNacimiento);
				listaUsuarios.add((Administrador) usu);
			}

			Usuario usu = new Cliente(dni, nombreCompleto, email, nombreUsuario, passProvisional, fechaNacimiento);
			listaUsuarios.add((Cliente) usu);

		}
	}

	protected static void bajaUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios,
			Class<? extends Usuario> tipoUsuario) {

		String dni = controlDatos.pedirDni(sc, tipoUsuario);
		int i = 0;
		boolean encontrado = false, respuestaBool = false;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (tipoUsuario.isAssignableFrom(Cliente.class)) {
				encontrado = buscarYeliminarUsuario(usu, listaUsuarios, Cliente.class, dni, sc, i);
			} else if (tipoUsuario.isAssignableFrom(Administrador.class)) {
				encontrado = buscarYeliminarUsuario(usu, listaUsuarios, Administrador.class, dni, sc, i);
			}
			i++;
		}
		if (!encontrado) {
			System.out.println("Usaurio no encontrado");
			sc.nextLine();
		}
	}

	private static boolean buscarYeliminarUsuario(Usuario usu, ArrayList<Usuario> listaUsuarios,
			Class<? extends Usuario> tipoUsuario, String dni, Scanner sc, int i) {
		boolean encontrado = false, respuestaBool;
		if (usu.getDni() != null && usu.getDni().equals(dni)) {
			respuestaBool = controlDatos.obtenerRespuestaSiNo(sc,
					"¿Seguro que dese eliminar a " + usu.getNombreCompleto() + "?");
			sc.nextLine();
			encontrado = true;
			if (respuestaBool) {
				listaUsuarios.remove(i);
			} else {
				System.out.println("Vuelve caundo estes seguro");
			}
		}

		return encontrado;

	}

	protected static void modificarUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios,
			Class<? extends Usuario> tipoUsuario) {
		String dni = controlDatos.pedirDni(sc, tipoUsuario);
		int i = 0;
		boolean encontrado = false;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (tipoUsuario.isAssignableFrom(Cliente.class) && usu instanceof Cliente) {
				encontrado = buscarYmodificarUsuario(usu, listaUsuarios, Cliente.class, dni, sc, i);
			} else if (tipoUsuario.isAssignableFrom(Administrador.class) && usu instanceof Administrador) {
				encontrado = buscarYmodificarUsuario(usu, listaUsuarios, Administrador.class, dni, sc, i);
			}
			i++;
		}
		if (!encontrado) {
			System.out.println("Usaurio no encontrado");
			sc.nextLine();
		}

	}

	private static boolean buscarYmodificarUsuario(Usuario usu, ArrayList<Usuario> listaUsuarios,
			Class<? extends Usuario> tipoUsuario, String dni, Scanner sc, int i) {
		String nombreCompleto, email, nombreUsuario, contraseña;
		LocalDate fechaNacimiento;
		boolean encontrado = false, respuestaBool;
		int opcion;
		if (usu.getDni() != null && usu.getDni().equals(dni)) {
			encontrado = true;
			do {
				System.out.println(usu.toString());
				opcion = Menus.mostrarMenuModificarUsuario(sc);
				switch (opcion) {
				case 1:
					System.out.println("Nombre actual: " + usu.getNombreCompleto());
					nombreCompleto = controlDatos.pedirNombreCompleto(sc, tipoUsuario);
					usu.setNombreCompleto(nombreCompleto);
					break;
				case 2:
					System.out.println("Email actual: " + usu.getEmail());
					email = controlDatos.pedirEmail(sc);
					usu.setEmail(email);
					break;
				case 3:
					System.out.println("Nombre de usuario actual: " + usu.getNombreUsuario());
					nombreUsuario = controlDatos.pedirNombreUsuario(sc, listaUsuarios);
					usu.setNombreUsuario(nombreUsuario);
					break;
				case 4:
					do {
						System.out.print("Introduce una contraseña de minimo 8 caracteres: ");
						contraseña = sc.next();
					} while (!controlDatos.comprobarString(contraseña, 8));
					break;
				case 5:
					fechaNacimiento = controlDatos.pedirFecha(sc, "\"Por favor, introduce tu fecha de nacimiento (en formato DD/MM/AAAA): \"");
					usu.setFechaNacimiento(fechaNacimiento);
					break;
				case 6:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opcion incorrecta :(");
				}

			} while (opcion != 6);
		}

		return encontrado;

	}

	protected static ArrayList<Integer> consultarUsuarios(ArrayList<Usuario> listaUsuarios,
			Class<? extends Usuario> tipoUsuario) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario usu = listaUsuarios.get(i);
			if (tipoUsuario.isInstance(usu)) {
				System.out.println("----------" + tipoUsuario.getSimpleName() + " " + i + "----------");
				System.out.println(usu.toString());
				indices.add(i);
			}
		}
		return indices;
	}
	
//	Administradores
	
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
				gestionUsuarios.altaUsuario(sc, listaUsuarios, tipoUsuario);
				break;
			case 2:
				System.out.println("Baja " + tipoUsuario.getSimpleName() + ":");
				gestionUsuarios.bajaUsuario(sc, listaUsuarios, tipoUsuario);
				break;
			case 3:
				System.out.println("Modificar datos " + tipoUsuario.getSimpleName() + ":");
				gestionUsuarios.modificarUsuario(sc, listaUsuarios, tipoUsuario);
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
