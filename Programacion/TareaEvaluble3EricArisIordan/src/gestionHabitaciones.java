import java.util.ArrayList;
import java.util.Scanner;

public class gestionHabitaciones {

	protected static void altaHabitacion(Scanner sc, ArrayList<Habitacion> listaHabitaciones) {
		int precioNoche;
		int categoria;
		String nombreHabitacion;
		
		nombreHabitacion = controlDatos.pedirNombreHabitacion(sc);
		categoria = controlDatos.pedirCategoria(sc);
		
		if (categoria != 4) {
			precioNoche = controlDatos.pedirPrecioNoche(sc);
			Habitacion hab = new Habitacion(precioNoche, categoria, nombreHabitacion);
			listaHabitaciones.add(hab);
		}
	}

	protected static void bajaHabitacion(Scanner sc, ArrayList<Habitacion> listaHabitaciones) {
		String nombreHabitacion;
		int i = 0;
		
		nombreHabitacion = controlDatos.pedirNombreHabitacion(sc);
		boolean encontrado = false;
		while (i < listaHabitaciones.size() && !encontrado) {
			Habitacion hab = listaHabitaciones.get(i);
			
			if (hab.getNombreHabitacion().equals(nombreHabitacion)) {
				encontrado = true;
				boolean respuestabool = controlDatos.obtenerRespuestaSiNo(sc, "Esta seguro que desea borrar la habitacion "+ hab.getNombreHabitacion() + "?");
				if(respuestabool) {
					listaHabitaciones.remove(i);
				} else {
					System.out.println("No se borra nada");
				}
			}
			
			i++;
		}
		if (!encontrado) {
			System.out.println("Usaurio no encontrado");
			sc.nextLine();
		}

	}
	
	protected static void modificarHabitacion(Scanner sc, ArrayList<Habitacion> listaHabitaciones) {
		String nombreHabitacion;
		int i = 0, opcion = 0, categoria, precioNoche;
		
		gestionHabitaciones.mostrarHabitaciones(listaHabitaciones);
		nombreHabitacion = controlDatos.pedirNombreHabitacion(sc);
		boolean encontrado = false;
		while (i < listaHabitaciones.size() && !encontrado) {
			Habitacion hab = listaHabitaciones.get(i);
			
			if (hab.getNombreHabitacion().equals(nombreHabitacion)) {
				encontrado = true;
				
				do {
					opcion = Menus.mostrarMenuModificarHabitacion(sc);
					switch (opcion) {
					case 1:
						System.out.println("Categoria de la habitacion: " + hab.getCategoria());
						categoria = controlDatos.pedirCategoria(sc);
						hab.setCategoria(categoria);
						break;
					case 2:
						System.out.println("Precio por noche de la habitacion: "+ hab.getPrecioNoche());
						precioNoche = controlDatos.pedirPrecioNoche(sc);
						hab.setPrecioNoche(precioNoche);
						break;
					case 3:
						System.out.println("Saliendo...");
						break;
					
					}
				} while (opcion != 3);
				
			}
			
			i++;
		}
		if (!encontrado) {
			System.out.println("Habitacion no encontrada");
			sc.nextLine();
		}

	}

	protected static void gestionHabitaciones(Scanner sc, ArrayList<Habitacion> listaHabitaciones) {
		int opcion;
		do {
			opcion = Menus.mostrarMenuGestionHabitacion(sc);
			switch (opcion) {
			case 1:
				altaHabitacion(sc, listaHabitaciones);
				break;
			case 2:
				bajaHabitacion(sc, listaHabitaciones);
				break;
			case 3:
				modificarHabitacion(sc, listaHabitaciones);
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			}

		} while (opcion != 4);

	}

	protected static void mostrarHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		for (Habitacion habitacion : listaHabitaciones) {
			System.out.println(habitacion.toString());
		}
	}

	
}
