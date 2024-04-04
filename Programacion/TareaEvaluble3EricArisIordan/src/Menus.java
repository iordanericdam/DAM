import java.util.Scanner;

public abstract class Menus {
	
	protected static int mostrarMenuUsuario(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║           Menu de Usaurio              ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Realizar reserva.                   ║");
		System.out.println("║ 2. Cancelar reserva.                   ║");
		System.out.println("║ 3. Consultar reservas.                 ║");
		System.out.println("║ 4. Cerrar sesion.                      ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuAdmin(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║           Menu de Administrador        ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Gestion usuarios.                   ║");
		System.out.println("║ 2. Gestion habitaciones.               ║");
		System.out.println("║ 3. Ver reservas.                       ║");
		System.out.println("║ 4. Cerrar sesion.                      ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuGestionUsuarios(Scanner sc) {
		System.out.println("╔══════════════════════════════════════════╗");
		System.out.println("║           Cliente o Administrador        ║");
		System.out.println("╠══════════════════════════════════════════╣");
		System.out.println("║ 1. Gestion clientes.                     ║");
		System.out.println("║ 2. Gestion administradores.              ║");
		System.out.println("║ 3. Salir.                                ║");
		System.out.println("╚══════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuVisualizacionReservasAdministrador(Scanner sc) {
		System.out.println("╔═══════════════════════════════════════════════╗");
		System.out.println("║                 Reservas                      ║");
		System.out.println("╠═══════════════════════════════════════════════╣");
		System.out.println("║ 1. Reserva de un usuario.                     ║");
		System.out.println("║ 2. Todas las reservas.                        ║");
		System.out.println("║ 3. Salir.                                     ║");
		System.out.println("╚═══════════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuGestionClientes(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║                 Clientes               ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Alta clientes.                      ║");
		System.out.println("║ 2. Baja clientes.                      ║");
		System.out.println("║ 3. Modificar clientes.                 ║");        
		System.out.println("║ 4. Salir.                              ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	
	protected static int seleccionarCategoria(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║                 Clientes               ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Individual.                         ║");
		System.out.println("║ 2. Doble.                              ║");
		System.out.println("║ 3. Familiar.                           ║");        
		System.out.println("║ 4. Salir.                              ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuGestionHabitaciones(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║                 Clientes               ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Alta habitacion.                    ║");
		System.out.println("║ 2. Baja habitacion.                    ║");
		System.out.println("║ 3. Modificar habitacion.               ║");        
		System.out.println("║ 4. Salir.                              ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuModificarUsuario(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║                Modificar               ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Cambiar nombre.                     ║");
		System.out.println("║ 2. Modificar email.                    ║");
		System.out.println("║ 3. Cambiar nombre de usuario.          ║");
		System.out.println("║ 4. Cambiar contraseña.                 ║");
		System.out.println("║ 5. Cambiar fecha nacimiento.           ║");
		System.out.println("║ 6. Salir.                              ║"); 
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Introduce la opcion que desea modificar: ");
	}
	
	protected static int mostrarMenuModificarHabitacion(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║                Modificar               ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Cambiar categoria.                  ║");
		System.out.println("║ 2. Cambiar precio por noche.           ║");
		System.out.println("║ 3. Salir.                              ║"); 
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Introduce la opcion que desea modificar: ");
	}
	
	protected static int mostrarMenuGestionAdministradores(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║             Administradores            ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Alta administradores.               ║");
		System.out.println("║ 2. Baja administradores.               ║");
		System.out.println("║ 3. Modificar administradores.          ║");        
		System.out.println("║ 4. Salir.                              ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuGestionHabitacion(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║              Habitaciones              ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Alta habitacion.                    ║");
		System.out.println("║ 2. Baja habitacion.                    ║");
		System.out.println("║ 3. Modificar habitacion.               ║");        
		System.out.println("║ 4. Salir.                              ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	


}
