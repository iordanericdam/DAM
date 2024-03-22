import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
//		Dentro de este main se le mostrará al usuario un menú con las siguientes opciones:
//
//			Rellenar nombre.
//			Rellenar apellidos.
//			Rellenar DNI.
//			Rellenar e-mail.
//			Finalizar.

		String opcionS, nombre = null, apellidos = null, DNI = null, email = null;
		int opcion;
		boolean datosCompletos = false, nombreCorrecto = false, apellidosCorrecto = false, dniCorrecto = false,
				emailCorrecto = false;
		Scanner sc = new Scanner(System.in);

		do {
			mostrarMenu();
			opcionS = sc.next();
			opcion = comprobarSiNumero(opcionS);

			switch (opcion) {
			case 1:
				do {
					System.out.print("Introduce el nombre: ");
					nombre = sc.next();
					nombreCorrecto = comprobarString(nombre, 3);
				} while (!nombreCorrecto);
				break;
			case 2:
				do {
					sc.nextLine();
					System.out.print("Introduce los apellidos: ");
					apellidos = sc.nextLine();
					apellidosCorrecto = comprobarString(apellidos, 3);
				} while (!apellidosCorrecto);
				break;
			case 3:
				do {
					System.out.print("Introduce el DNI: ");
					DNI = sc.next();
					if (!validarDNI(DNI) && !validarNIE(DNI)) {
						System.out.println("El DNI o NIE introducidos son incorrectos.");
					} else {
						dniCorrecto = true;
					}
				} while (!dniCorrecto);
				break;
			case 4:
				do {
					System.out.print("Introduce el e-mail: ");
					email = sc.next();
					emailCorrecto = comprobarString(email, 10);
				} while (!emailCorrecto);
				break;
			case 5:
				if (comprobarDatos(nombreCorrecto, apellidosCorrecto, dniCorrecto, emailCorrecto) == 0) {
					System.out.println("Has completado correctamente el formulario!!");
					System.out.println("Los datos introducidos son: " +"\n" +"Nombre: "+ nombre + "\n"+  " Apellidos: "+ apellidos + "\n" +  " DNI: "+ DNI + "\n" + " Correo: "+ email);
					datosCompletos = obtenerRespuestaSiNo(sc, "¿Los datos son correctos, desea salir?");
					if (datosCompletos) {
						System.out.println("Gracias, nos vemos pronto");
					}
					break;
				}

			}
		} while (!datosCompletos);

	}

	private static void mostrarMenu() {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║           Menu de Opciones             ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Rellenar nombre.                    ║");
		System.out.println("║ 2. Rellenar apellidos.                 ║");
		System.out.println("║ 3. Rellenar DNI.                       ║");
		System.out.println("║ 4. Relleanr e-mail.                    ║");
		System.out.println("║ 5. Finalizar.                          ║");
		System.out.println("╚════════════════════════════════════════╝");
	}

	private static int comprobarSiNumero(String numeroS) {
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

	private static boolean comprobarString(String variableS, int caracteres) {
		boolean correcto = false;
		if (variableS.length() < caracteres) {
			System.out.println("La longitud debe de ser minimo de " + caracteres + " caracteres");
		} else {
			correcto = true;
		}
		return correcto;

	}

	private static boolean validarDNI(String dni) {
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

	private static boolean validarNIE(String nie) {
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

	private static int comprobarDatos(boolean nombreCorrecto, boolean apellidosCorrecto, boolean dniCorrecto,
			boolean emailCorrecto) {
		int datosCompletos = 0;
		if (!nombreCorrecto) {
			System.out.println("No ha introducido el nombre!");
			datosCompletos += 1;
		}
		if (!apellidosCorrecto) {
			System.out.println("No has introducido los apellidos!");
			datosCompletos += 1;
		}
		if (!dniCorrecto) {
			System.out.println("No has introducido el DNI!");
			datosCompletos += 1;
		}
		if (!emailCorrecto) {
			System.out.println("No has introducido el e-mail!");
			datosCompletos += 1;
		}
		return datosCompletos;
	}

}
