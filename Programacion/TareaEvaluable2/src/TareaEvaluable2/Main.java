package TareaEvaluable2;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		String opcionS, dniEliminar, dniSueldo;
		int opcion = 0;
		final String resp0programadores = "No hay programadores/as en el sistema.";
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		Empleado emp = null;
		Scanner sc = new Scanner(System.in);

		do {
			mostrarMenuPrincipal();
			opcionS = sc.next();
			opcion = comprobarSiNumero(opcionS);
			if (opcion != 0) {
				switch (opcion) {
				case 1:
					System.out.print("Introduce el DNI: ");
					String dni = sc.next().toUpperCase();
					Programador.añadirProgramador(dni, listaEmpleados, sc, emp);
					

					break;
				case 2:
					System.out.print("Introduce el DNI del programador que desea eliminar: ");
					dniEliminar = sc.next().toUpperCase();
					Empleado.eliminarEmpleado(dniEliminar, listaEmpleados, sc);

					break;
				case 3:
					if (!listaEmpleados.isEmpty()) {
						System.out.print("Introduce el DNI del programador al que le desea subir el sueldo: ");
						dniSueldo = sc.next().toUpperCase();
						Empleado.subirSueldo(dniSueldo, listaEmpleados, sc);
					} else {
						System.out.println(resp0programadores);
					}

					break;
				case 4:
					if (!listaEmpleados.isEmpty()) {
						Empleado.mostrarInformacionEmpleados(listaEmpleados);
					} else {
						System.out.println(resp0programadores);
					}

					break;

				default:
					System.out.println("Opción incorrecta, introduzca un numero del 1 al 5.");
					break;
				}

			}

		} while (opcion != 5);

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

	protected static double comprobarSiNumeroDecmales(String numeroS) {
		double opcion = 0;
		try {
			opcion = Double.parseDouble(numeroS);
		} catch (Exception e) {
			System.out.println("Debes introducir SOLO el numero y un . PUNTO para separar los decimales.");

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

	protected static void mostrarMenuPrincipal() {
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║           Menu de opciones            ║");
		System.out.println("╠═══════════════════════════════════════╣");
		System.out.println("║ 1. Dar de alta un programador         ║");
		System.out.println("║ 2. Dar de baja un programador         ║");
		System.out.println("║ 3. Aumentar salario de un programador.║");
		System.out.println("║ 4. Mostrar programadores por pantalla.║");
		System.out.println("║ 5. Salir.                             ║");
		System.out.println("╚═══════════════════════════════════════╝");
	}

}
