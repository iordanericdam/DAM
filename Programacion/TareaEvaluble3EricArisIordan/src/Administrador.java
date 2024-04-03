import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

	public Administrador() {
	}

	public Administrador(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña,
			LocalDate fechaNacimiento) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña, fechaNacimiento);
	}
	
	public Administrador(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña);
	}

	public Administrador(String dni, String nombreCompleto, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, nombreUsuario, contraseña);
	}

	

}
