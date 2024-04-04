import java.time.LocalDate;
import java.util.Scanner;


public class Cliente extends Usuario{
	
	
	public Cliente(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña, LocalDate fechaNacimiento) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña, fechaNacimiento);
	}
	
	public Cliente(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña);
	}
	
	public Cliente(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña, boolean primerLogin) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña, primerLogin);
	}
	
	public Cliente(String dni, String nombreCompleto, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, nombreUsuario, contraseña);
	}
	
	protected static void primerLogin(Scanner sc, Usuario usu) {
		boolean contraseñaCorrecta;
		System.out.println("Para continuar primero debes cambiar la contraseña (debe tener minimo 8 caracteres): ");
		do {
			String passUsaurio = sc.next();
			contraseñaCorrecta = controlDatos.comprobarString(passUsaurio, 8);
			if (contraseñaCorrecta) {
				usu.setContraseña(passUsaurio);
				usu.primerLogin = false;
			}
		} while (!contraseñaCorrecta);

	}

}