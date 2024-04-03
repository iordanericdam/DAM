import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class gestionReserva {
	
	protected static void gestionHabitaciones(Scanner sc, ArrayList<Reserva> listaReservas, ArrayList<Habitacion> listaHabitaciones, Usuario usu) {
		int opcion;
		do {
			opcion = Menus.mostrarMenuUsuario(sc);
			switch (opcion) {
			case 1:
				realizarReserva(sc, listaReservas, listaHabitaciones, usu);
				break;
			case 2:
				cancelarReserva(sc, listaReservas);
				break;
			case 3:
				consultarReserva(sc, listaReservas);
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			}

		} while (opcion != 4);

	}
		
		
	protected static void realizarReserva(Scanner sc, ArrayList<Reserva> listaReservas, ArrayList<Habitacion> listaHabitaciones, Usuario usu) {
        String nombreHabitacion;
        int i = 0;
        LocalDate primeraNoche;
        int noches;
        boolean problemaDisponibilidad = false;
        
        gestionHabitaciones.mostrarHabitaciones(listaHabitaciones);
        
        System.out.println("Introduzca el nombre de la habitación que desea reservar:");
        sc.nextLine();
        nombreHabitacion = sc.nextLine();
        
        boolean encontrado = false;
        while (i < listaHabitaciones.size() && !encontrado) {
            Habitacion hab = listaHabitaciones.get(i);
            
            if (hab.getNombreHabitacion().equals(nombreHabitacion)) {
                encontrado = true;
                primeraNoche = controlDatos.pedirFecha(sc, "Introduzca la fecha de la primera noche que desea reservar, el formato debe ser DD/MM/AAAA: ");
                noches = controlDatos.pedirNoches(sc);
                
                LocalDate fechaReserva = primeraNoche;
                ArrayList<LocalDate> fechasReserva = new ArrayList<>();
                for (int j = 0; j < noches; j++) {
                    boolean estadoReserva = hab.estaReservada(fechaReserva);
                    
                    if (estadoReserva) {
                        System.out.println("Lo sentimos, la fecha " + fechaReserva + " no está disponible.");
                        problemaDisponibilidad = true;
                        break; 
                    } else {
                        System.out.println("Fecha " + fechaReserva + " disponible.");
                        fechasReserva.add(fechaReserva); 
                    }
                    
                    fechaReserva = fechaReserva.plusDays(1);
                }
                
                if (!problemaDisponibilidad) {
                    System.out.println("Reserva realizada con éxito para la habitación " + hab.getNombreHabitacion());
                    Reserva nuevaReserva = new Reserva(nombreHabitacion, usu.getDni(), fechasReserva);
                    listaReservas.add(nuevaReserva);
                    
                    hab.setFechaReservada(fechasReserva);
                } else {
                    boolean respuestaBool = controlDatos.obtenerRespuestaSiNo(sc, "¿Desea escoger otra fecha?");
                    if (respuestaBool){
                    	
                    }
                }
            }
            i++;
        }
        
        if (!encontrado) {
            System.out.println("¡Habitación no encontrada!");
        }
    }
	


	private static void cancelarReserva(Scanner sc, ArrayList<Reserva> listaReservas) {
		// TODO Auto-generated method stub
		
	}

	private static void consultarReserva(Scanner sc, ArrayList<Reserva> listaReservas) {
		// TODO Auto-generated method stub
		
	}

}
