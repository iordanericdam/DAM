import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
		Scanner sc = new Scanner(System.in);
		
		
		creacionObjetos(listaUsuarios, listaReservas, listaHabitaciones);
		

		
		do {
			Usuario usu = gestionUsuarios.comprobarCredenciales(listaUsuarios, sc);
			if (usu  instanceof Cliente) {
				if (usu.isPrimerLogin()) {
					Cliente.primerLogin(sc, usu);
					sc.nextLine();
				}
				gestionReserva.gestionHabitaciones(sc, listaReservas, listaHabitaciones, usu);

			} else if (usu instanceof Administrador) {
				gestionUsuarios.gestionAdministrador(sc, listaUsuarios, listaHabitaciones, listaReservas);

			}
		} while (true);

	}
	
	
	
	
	
	
	
	protected static void creacionObjetos(ArrayList<Usuario> listaUsuarios, ArrayList<Reserva> listaReservas, ArrayList<Habitacion> listaHabitaciones) {

		
		Administrador admin1 = new Administrador("71677091Y", "Eric Aris Iordan", "eericarisiordan@gmail.com", "admin",
				"admin");
		listaUsuarios.add((Administrador) admin1);
		Administrador admin2 = new Administrador("43851358H","Administrador2", "admin2", "adminadmin");
		listaUsuarios.add((Administrador) admin2);

		Usuario usu1 = new Cliente("85058845S", "Fermin Rivas Romero", "mqfgwse5j@journalism.com", "fermin",
				"fermin", false);
		listaUsuarios.add(usu1);
		Usuario usu2 = new Cliente("95558590F", "Juan Jose Menendez Ferrero", "o8dcuozu@lycos.nl", "juan",
				"juan", false);
		listaUsuarios.add(usu2);
		
		ArrayList<LocalDate> fechasReserva = new ArrayList<>();
        fechasReserva.add(LocalDate.of(2024, 4, 10)); 
        fechasReserva.add(LocalDate.of(2024, 4, 11));

        Reserva r1 = new Reserva("valencia", "85058845S", fechasReserva, 180);
        listaReservas.add(r1);
        
        Habitacion hab1 = new Habitacion(90, 2, "valencia");
        listaHabitaciones.add(hab1);
        
        Habitacion hab2 = new Habitacion(50, 1, "marvella");
        listaHabitaciones.add(hab2);
        
        Habitacion hab3 = new Habitacion(120, 1, "madrid");
        listaHabitaciones.add(hab3);
	}
	
    

}
