package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

	String nombreUsuario, pass, dni, nombreCompleto;
	boolean primerLogin = true;

	public Usuario(String nombreUsuario, String pass, String dni, String nombreCompleto) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
	}
	
	public Usuario(String nombreUsuario, String pass, String dni, String nombreCompleto, boolean primerLogin) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.primerLogin = primerLogin;
	}
	
	

	public void setPass(String pass) {
		this.pass = pass;
	}



	public boolean isPrimerLogin() {
		return primerLogin;
	}

	public void setPrimerLogin(boolean primerLogin) {
		this.primerLogin = primerLogin;
	}

	public Usuario() {

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getPass() {
		return pass;
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	@Override
	public String toString() {
		return  "-----------------------"+ "\n" + "Nombre de usuario: " + nombreUsuario +"\n" +"Contraseña: " + pass +"\n"+ "DNI/NIE: " + dni +"\n"+ "Nombre completo: "
				+ nombreCompleto;
	}

	
	
	protected static void primerLogin(Scanner sc, Usuario usu) {
		boolean passCorrecta;
		System.out.println("Para continuar primero debes cambiar la contraseña (debe tener minimo 8 caracteres): ");
		do {
			String passUsaurio = sc.next();
			passCorrecta = main.comprobarString(passUsaurio, 8);
			if (passCorrecta) {
				usu.setPass(passUsaurio);
				usu.primerLogin = false;
			}
		} while (!passCorrecta);

	}

	protected void mostrarInformacionUsuarios(ArrayList<Usuario> listaUsuarios) {
		System.out.println("Información de los usuarios:");
		for (Usuario usu : listaUsuarios) {
			System.out.println(usu.toString());
		}
	}

	protected static boolean comprobarNombreUsuario(String nombreUsuario, ArrayList<Usuario> listaUsuarios) {
		boolean encontrado = false;
		int i = 0;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (usu instanceof Usuario) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
				}
			}
			i++;
		}
		return encontrado;

	}

	protected static boolean validarDNI(String dni) {
		if (dni == null || dni.length() != 9) {
			return false;
		}

		for (int i = 0; i < 8; i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				return false;
			}
		}

		char letra = Character.toUpperCase(dni.charAt(8));
		if (!Character.isLetter(letra)) {
			return false;
		}

		int numDNI;
		try {
			numDNI = Integer.parseInt(dni.substring(0, 8));
		} catch (NumberFormatException e) {
			return false;
		}

		char letraCalculada = calcularLetra(numDNI);

		if (letra != letraCalculada) {
			return false;
		}

		return true;
	}

	private static char calcularLetra(int numero) {
		String letrasNIE = "TRWAGMYFPDXBNJZSQVHLCKE";
		int indiceLetra = numero % 23;
		return letrasNIE.charAt(indiceLetra);

	}

	protected static boolean validarNIE(String nie) {
		char primeraLetra = nie.charAt(0);
		if (primeraLetra == 'X') {
			nie = "0" + nie.substring(1);
		} else if (primeraLetra == 'Y') {
			nie = "1" + nie.substring(1);
		} else if (primeraLetra == 'Z') {
			nie = "2" + nie.substring(1);
		} else {
			return false;
		}

		if (nie.length() != 9 || !nie.substring(1).matches("\\d{7}[A-Z]")) {
			return false;
		}

		String digitos = nie.substring(0, 8);
		int numNIE = Integer.parseInt(digitos);
		char letraCalculada = calcularLetra(numNIE);
		char letraControl = nie.charAt(8);

		if (letraControl != letraCalculada) {
			return false;
		}

		return true;
	}

	protected static boolean comprobarUsaurio(String dni, ArrayList<Usuario> listaEmpleados) {
		boolean existe = false;
		for (Usuario usu : listaEmpleados) {
			if (usu.getDni().equals(dni)) {
				System.out.println("El DNI ya se encuentra registrado");
				existe = true;
				break;
			}
		}
		return existe;
	}

	protected static void consultarUsuarios(ArrayList<Usuario> listaUsuarios) {
		for (Usuario usu : listaUsuarios) {
			if (!(usu instanceof Administrador)) {
				System.out.println(usu.toString());
			} 
		}

	}

	protected static void mostrarMenuUsuario() {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║           Menu de Usaurio              ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Hacer prestamo/s.                   ║");
		System.out.println("║ 2. Devolver libro/s.                   ║");
		System.out.println("║ 3. Consultar prestamos.                ║");
		System.out.println("║ 4. Cerrar sesion.                      ║");
		System.out.println("╚════════════════════════════════════════╝");
	}

}
