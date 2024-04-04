import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.NodeDimensionsHandler;

public class gestionReserva {

	static ArrayList<Integer> idsReservas = new ArrayList<>();
	static boolean noExisteReserva = false;

	protected static void gestionHabitaciones(Scanner sc, ArrayList<Reserva> listaReservas,
			ArrayList<Habitacion> listaHabitaciones, Usuario usu) {
		int opcion;
		do {
			opcion = Menus.mostrarMenuUsuario(sc);
			switch (opcion) {
			case 1:
				realizarReserva(sc, listaReservas, listaHabitaciones, usu);
				break;
			case 2:
				cancelarReserva(sc, listaReservas, usu);
				break;
			case 3:
				consultarReservaUsuario(sc, listaReservas, usu);
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			}
		} while (opcion != 4);

	}

	protected static void realizarReserva(Scanner sc, ArrayList<Reserva> listaReservas,
			ArrayList<Habitacion> listaHabitaciones, Usuario usu) {
		String nombreHabitacion;
		int i = 0, costeReserva;
		LocalDate primeraNoche;
		int noches;
		boolean problemaDisponibilidad = false;

		gestionHabitaciones.mostrarHabitaciones(listaHabitaciones);

		nombreHabitacion = controlDatos.pedirNombreHabitacion(sc);

		boolean encontrado = false;
		while (i < listaHabitaciones.size() && !encontrado) {
			Habitacion hab = listaHabitaciones.get(i);

			if (hab.getNombreHabitacion().equals(nombreHabitacion)) {
				encontrado = true;
				primeraNoche = controlDatos.pedirPrimerNoche(sc);
				noches = controlDatos.pedirNoches(sc);

				LocalDate fechaReserva = primeraNoche;
				ArrayList<LocalDate> fechasReserva = new ArrayList<>();
				for (int j = 0; j < noches; j++) {
					boolean estadoReserva = comprobarEstadoFechas(listaReservas, fechaReserva, hab);

					if (estadoReserva) {
						System.out.println("Lo sentimos, la fecha " + fechaReserva + " no está disponible.");
						problemaDisponibilidad = true;
						break;
					} else {
						fechasReserva.add(fechaReserva);
					}

					fechaReserva = fechaReserva.plusDays(1);
				}

				if (!problemaDisponibilidad) {
					costeReserva = noches * hab.getPrecioNoche();
					System.out.println("Reserva realizada con éxito para la habitación " + hab.getNombreHabitacion()
							+ " en las fechas seleccionadas.");
					System.out.println("Tendra que abonar " + costeReserva + "€ cuando llegue al establecimiento.");
					Reserva nuevaReserva = new Reserva(nombreHabitacion, usu.getDni(), fechasReserva, costeReserva);
					listaReservas.add(nuevaReserva);

				} else {
					boolean respuestaBool = controlDatos.obtenerRespuestaSiNo(sc, "¿Desea escoger otra fecha?");
					if (respuestaBool) {
						i--;
						encontrado = false;
						problemaDisponibilidad = false;
					} else {
						System.out.println("La reserva no se pudo realizar debido a problemas de disponibilidad.");
					}
				}
			}
			i++;
		}

		if (!encontrado) {
			System.out.println("¡Habitación no encontrada!");
		}
	}

	private static void cancelarReserva(Scanner sc, ArrayList<Reserva> listaReservas, Usuario usu) {
		int idSeleccionado;
		int i = 0;
		boolean respuestaBool, encontrado = false;
		idsReservas = consultarReservaUsuario(sc, listaReservas, usu);

		if (!noExisteReserva) {
			idSeleccionado = controlDatos.pedirOpcion(sc, "Introduce el ID de la reserva que desea cancelar: ");
			if (idsReservas.contains(idSeleccionado)) {
				while (i < listaReservas.size()) {
					Reserva r1 = listaReservas.get(i);
					if (r1.getDniCliente().equals(usu.getDni()) && i == idSeleccionado) {
						respuestaBool = controlDatos.obtenerRespuestaSiNo(sc,
								"Esta seguro que desea cancelar la reserva con id " + idSeleccionado + "?");
						encontrado = true;
						if (respuestaBool) {
							listaReservas.remove(i);
						} else {
							System.out.println("No se borrara nada");
						}

					}

					i++;
				}
			}

		}

		if (!encontrado && !noExisteReserva) {
			System.out.println("El id introducido no es correcto");
		}
	}

	protected static void consultaReservasAdministrador(Scanner sc, ArrayList<Usuario> listaUsuarios,
			ArrayList<Reserva> listaReservas) {
		int opcion;
		do {
			opcion = Menus.mostrarMenuVisualizacionReservasAdministrador(sc);

			switch (opcion) {
			case 1:
				Usuario usu = gestionUsuarios.buscarUsuario(sc, listaUsuarios, Cliente.class);
				if (usu != null) {
					consultarReservaUsuario(sc, listaReservas, usu);
				}

				break;
			case 2:
				consultarReservas(listaReservas);
				break;
			}

		} while (opcion != 3);

	}

	private static ArrayList<Integer> consultarReservaUsuario(Scanner sc, ArrayList<Reserva> listaReservas,
			Usuario usu) {

		boolean existenReservas = false;
		int i = 0;
		while (i < listaReservas.size()) {
			Reserva r1 = listaReservas.get(i);
			if (r1.getDniCliente().equals(usu.getDni())) {
				noExisteReserva = false;
				System.out.println("ID de reserva: " + i);
				System.out.println(r1.toString());
				idsReservas.add(i);
				existenReservas = true;
			}
			i++;
		}

		if (!existenReservas) {
			System.out.println("Vaya parece que todavía no ha hecho ninguna reserva");
			noExisteReserva = true;
		}

		return idsReservas;
	}

	private static void consultarReservas(ArrayList<Reserva> listaReservas) {
		for (Reserva r1 : listaReservas) {
			System.out.println(r1.toString());
		}
	}

	private static boolean comprobarEstadoFechas(ArrayList<Reserva> listaReservas, LocalDate fechaReserva,
			Habitacion hab) {
		for (Reserva r1 : listaReservas) {
			if (r1.getNombreHabitacion().equalsIgnoreCase(hab.getNombreHabitacion())) {
				if (r1.getFechaReservada().contains(fechaReserva)) {

					return true;
				}
			}
		}

		return false;
	}

}
