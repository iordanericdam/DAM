
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario {
	String dni, nombreCompleto, email, nombreUsuario, contraseña;
	LocalDate fechaNacimiento;
	boolean primerLogin = true;

	public Usuario() {
	}

	public Usuario(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña,
			LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public Usuario(String dni, String nombreCompleto, String nombreUsuario, String contraseña) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public Usuario(String nombreCompleto, String nombreUsuario, String contraseña) {
		this.nombreCompleto = nombreCompleto;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean isPrimerLogin() {
		return primerLogin;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setPrimerLogin(boolean primerLogin) {
		this.primerLogin = primerLogin;
	}

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
			// Utilizo !(usu instanceof Administrador) para separar los usaurios de los
			// administradores ya que todos son usuarios pero no todos son admnistradores.
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
			fechaNacimiento = controlDatos.pedirFecha(sc);
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
		boolean encontrado = false, respuestaBool = false;
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
					fechaNacimiento = controlDatos.pedirFecha(sc);
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

	@Override
	public String toString() {
		return String.format(
				"DNI: %s%n" + "Nombre completo: %s%n" + "Email: %s%n" + "Nombre de usuario: %s%n" 
						+ "Fecha de nacimiento: %s%n",
				dni, nombreCompleto, email, nombreUsuario, fechaNacimiento);
	}

}
