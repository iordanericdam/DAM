import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String opcionS, nombreUsuario, contraseña;
		int opcion;

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
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
		
		do {
			Usuario usu = Usuario.comprobarCredenciales(listaUsuarios, sc);
			if (usu  instanceof Cliente) {
				do {
					opcion = Menus.mostrarMenuUsuario(sc);
					switch (opcion) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						System.out.println("Saliendo...");
						break;	
					}
				} while (opcion != 4);

			} else if (usu instanceof Administrador) {
				do {
					opcion = Menus.mostrarMenuAdmin(sc);
					switch (opcion) {
					case 1:
						Administrador.gestionUsuarios(sc, listaUsuarios);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						System.out.println("Saliendo...");
						break;
					case 6:
						Usuario.consultarUsuarios(listaUsuarios, Cliente.class);
						break;
					case 7:
						Usuario.consultarUsuarios(listaUsuarios, Administrador.class);
						break;	
					default:
						System.out.println("Opcion no valida");
						break;
					}
				} while (opcion != 4);

			}
		} while (true);

	}

}
