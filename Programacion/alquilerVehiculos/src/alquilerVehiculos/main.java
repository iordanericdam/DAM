package alquilerVehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int precioDia = 50, precioPlazaMicro = 2, precioPMA = 20;
		final double precioCocheDia = 1.5;

		String opcionS, matricula = null;
		int opcion, tipo, dias;
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
		Vehiculo veh = null;

		do {
			mostrarMenuPrincipal();
			System.out.print("Eligue una opcion: ");
			opcionS = sc.next();
			opcion = comprobarSiNumero(opcionS);

			switch (opcion) {
			case 1:
				mostrarTarifas(precioDia, precioPlazaMicro, precioPMA, precioCocheDia);
				break;
			case 2:
				if(!listaVehiculos.isEmpty()) {
					tipo = elegirTipoVeichulo(sc, "¿Que tipo de vehiculo desea alquilar?");
					mostrarVehiculos(listaVehiculos, tipo);
					System.out.println("¿Que vehiculo desea alquilar, escriba la matricula?");
					matricula = sc.next();
					if (main.comprobarMatricula(matricula, listaVehiculos)) {
						System.out.println("¿Cuantos dias desea alquilarlo?");
						dias = sc.nextInt();
						alquilarVehiculo(dias, matricula, veh, listaVehiculos);
					} else {
						System.out.println("Matrcula incorrecta");
					}
				} else {
					System.out.println("No hay vehiculos en el sistema");
				}
				
				break;
			case 3:
				tipo = elegirTipoVeichulo(sc, "¿Que tipo de vehiculo quieres dar de alta?");
				if (tipo != 5) {
					añadirVehiculo(sc, listaVehiculos, tipo, veh);
				} else {
					System.out.println("--------------------------------------------------");
				}
			}

		} while (opcion != 5);
	}

	protected static void mostrarMenuPrincipal() {
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║           Menu de opciones            ║");
		System.out.println("╠═══════════════════════════════════════╣");
		System.out.println("║ 1. Consultar tarifas                  ║");
		System.out.println("║ 2. Calcular presupuesto               ║");
		System.out.println("║ 3. Dar de alta un vehiculo            ║");
		System.out.println("║ 4. Salir.                             ║");
		System.out.println("╚═══════════════════════════════════════╝");
	}

	protected static void mostrarListaVehiculos() {
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║           Lista vehiculos             ║");
		System.out.println("╠═══════════════════════════════════════╣");
		System.out.println("║ 1. Coche                              ║");
		System.out.println("║ 2. Micro-buses                        ║");
		System.out.println("║ 3. Furgoneta de carga                 ║");
		System.out.println("║ 4. Camiones                           ║");
		System.out.println("║ 5. Salir.                             ║");
		System.out.println("╚═══════════════════════════════════════╝");
	}

	protected static void mostrarTarifas(int precioDia, int precioPlazaMicro, int precioPMA, double precioCocheDia) {
		System.out.println("╭────────────────────────────────────────────────╮");
		System.out.println("│                    Tarifas                     │");
		System.out.println("├────────────────────────────────────────────────┤");
		System.out.println("│ Precio por día: " + precioDia + "€                            │");
		System.out.println("│ Precio por plaza y día en coches: " + precioCocheDia + "€         │");
		System.out.println("│ Precio por plaza y día en micro-buses: " + precioPlazaMicro + "€      │");
		System.out.println("│ Precio por PMA en camiones: " + precioPMA + "€                │");
		System.out.println("╰────────────────────────────────────────────────╯");
		System.out.println();
	}

	private static int elegirTipoVeichulo(Scanner sc, String pregunta) {
		int tipo = -1;
		do {
			System.out.println(pregunta);
			mostrarListaVehiculos();
			String opcionS = sc.next();
			tipo = comprobarSiNumero(opcionS);

		} while (tipo != 1 && tipo != 2 && tipo != 3 && tipo != 4 && tipo != 5);
		return tipo;
	}

	protected static boolean comprobarMatricula(String matricula, ArrayList<Vehiculo> listaVehiculos) {
		boolean existe = false;
		for (Vehiculo v1 : listaVehiculos) {
			if (v1.getMatricula().equals(matricula)) {
				existe = true;
				break;
			}

			if (existe) {
				System.out.println("La matricula ya se ha registrado anteriormente");
			}
		}
		return existe;
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

	protected double comprobarSiNumeroDecmales(String numeroS) {

		double opcion = 0;
		try {
			opcion = Double.parseDouble(numeroS);
		} catch (Exception e) {
			System.out.println("Debes introducir SOLO el numero y un . PUNTO para separar los decimales." + e);
		}
		return opcion;
	}

	protected static void mostrarVehiculos(ArrayList<Vehiculo> listaVehiculos, int tipo) {
//		boolean hayDatos = false;
		switch (tipo) {
		case 1:
			System.out.println("Información de los coches:");
			for (Vehiculo vehiculo : listaVehiculos) {
				if (vehiculo instanceof Coche) {
					System.out.println((Coche) vehiculo);
//					hayDatos = true;
				}
			}
			break;
		case 2:
			System.out.println("Información de los micro buses:");
			for (Vehiculo vehiculo : listaVehiculos) {
				if (vehiculo instanceof MicroBus) {
					System.out.println((MicroBus) vehiculo);
				}
			}
			break;
		case 3:
			System.out.println("Información de las furgonetas:");
			for (Vehiculo vehiculo : listaVehiculos) {
				if (vehiculo instanceof Furgoneta)
					System.out.println((Furgoneta) vehiculo);
			}
			break;
		case 4:
			System.out.println("Información de los camiones:");
			for (Vehiculo vehiculo : listaVehiculos) {
				if (vehiculo instanceof Camion)
					System.out.println((Camion) vehiculo);
			}
			break;
		}
	}

	protected static void añadirVehiculo(Scanner sc, ArrayList<Vehiculo> listaVehiculos, int tipo, Vehiculo veh) {
		String matricula, marca, modelo, color, numPlazasS, kmS;
		int numPlazas, km = -1, PMA;
		if (tipo != 5) {
			System.out.print("Introduzca la matricula: ");
			matricula = sc.next().toUpperCase();
			if (!main.comprobarMatricula(matricula, listaVehiculos)) {
				System.out.print("Introduzca la marca: ");
				marca = sc.next();
				System.out.print("Introduzca el modelo: ");
				modelo = sc.next();
				System.out.print("Introduzca el color: ");
				color = sc.next();

				do {
					System.out.print("Introduzca el numero de kilometros: ");
					kmS = sc.next();
					km = comprobarSiNumero(kmS);
				} while (km == 0);

				switch (tipo) {
				case 1:
					do {
						System.out.print("Introduzca el numero de plazas: ");
						numPlazasS = sc.next();
						numPlazas = main.comprobarSiNumero(numPlazasS);
					} while (numPlazas == 0);
					veh = new Coche(matricula, marca, modelo, color, km, numPlazas);
					listaVehiculos.add((Coche) veh);
					break;
				case 2:
					do {
						System.out.print("Introduzca el numero de plazas: ");
						numPlazasS = sc.next();
						numPlazas = main.comprobarSiNumero(numPlazasS);
					} while (numPlazas == 0);
					veh = new MicroBus(matricula, marca, modelo, color, km, numPlazas);
					listaVehiculos.add((MicroBus) veh);
					break;
				case 3:
					System.out.print("Introduzca el PMA de la furgoneta: ");
					String PMAS = sc.next();
					PMA = comprobarSiNumero(PMAS);
					veh = new Furgoneta(matricula, marca, modelo, color, km, PMA);
					listaVehiculos.add((Furgoneta) veh);
					break;
				case 4:
					System.out.print("Introduzca el PMA de la furgoneta: ");
					PMAS = sc.next();
					PMA = comprobarSiNumero(PMAS);
					veh = new Camion(matricula, marca, modelo, color, km, PMA);
					listaVehiculos.add((Camion) veh);
					break;
				}
			}

		}

	}

	private static void alquilarVehiculo(int dias, String matricula, Vehiculo veh, ArrayList<Vehiculo> listaVehiculos) {
		for (Vehiculo v1 : listaVehiculos) {
			if (v1.getMatricula().equals(matricula)) {
				double precioAlquiler = v1.calcularPrecio(dias);
				System.out.println(precioAlquiler);
				break;
			} else {
				System.out.println("Parece que ha habido un error");
			}

		}

	}

}
