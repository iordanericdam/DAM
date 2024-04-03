import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String opcionS, nombreUsuario, contraseña;
		int opcion;

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
		Scanner sc = new Scanner(System.in);
		
//		Creacion de usuarios de administrador
		Administrador admin1 = new Administrador("71677091Y", "Eric Aris Iordan", "eericarisiordan@gmail.com", "admin",
				"admin");
		listaUsuarios.add((Administrador) admin1);
		Administrador admin2 = new Administrador("43851358H","Administrador2", "admin2", "adminadmin");
		listaUsuarios.add((Administrador) admin2);

		Usuario usu1 = new Cliente("85058845S", "Fermin Rivas Romero", "mqfgwse5j@journalism.com", "fermin",
				"fermin");
		listaUsuarios.add(usu1);
		Usuario usu2 = new Cliente("95558590F", "Juan Jose Menendez Ferrero", "o8dcuozu@lycos.nl", "Juan",
				"juan");
		listaUsuarios.add(usu2);
		
		ArrayList<LocalDate> fechasReserva = new ArrayList<>();
        fechasReserva.add(LocalDate.of(2024, 4, 10)); // Ejemplo de fecha reservada
        fechasReserva.add(LocalDate.of(2024, 4, 15)); // Ejemplo de fecha reservada

        Reserva r1 = new Reserva("España", "85058845S", fechasReserva);
        listaReservas.add(r1);
        
        Habitacion hab1 = new Habitacion(90, 2, "españa", null);
        listaHabitaciones.add(hab1);
		
		do {
			Usuario usu = gestionUsuarios.comprobarCredenciales(listaUsuarios, sc);
			if (usu  instanceof Cliente) {
				
				gestionReserva.gestionHabitaciones(sc, listaReservas, listaHabitaciones, usu);

			} else if (usu instanceof Administrador) {
				do {
					opcion = Menus.mostrarMenuAdmin(sc);
					switch (opcion) {
					case 1:
						gestionUsuarios.gestionUsuarios(sc, listaUsuarios);
						break;
					case 2:
						gestionHabitaciones.gestionHabitaciones(sc, listaHabitaciones);
						break;
					case 3:
						break;
					case 4:
						System.out.println("Saliendo...");
						break;
					case 6:
						System.out.println();
						gestionHabitaciones.mostrarHabitaciones(listaHabitaciones);
						break;
//					case 7:
//						Usuario.consultarUsuarios(listaUsuarios, Administrador.class);
//						break;	
					default:
						System.out.println("Opcion no valida");
						break;
					}
				} while (opcion != 4);

			}
		} while (true);

	}
	
    

}
