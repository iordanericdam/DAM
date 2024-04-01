import java.time.LocalDate;

public class Cliente extends Usuario{
	
	public Cliente() {
	}
	
	public Cliente(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña, LocalDate fechaNacimiento) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña, fechaNacimiento);
	}
	
	public Cliente(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, email, nombreUsuario, contraseña);
	}
	
	public Cliente(String dni, String nombreCompleto, String nombreUsuario, String contraseña) {
		super(dni, nombreCompleto, nombreUsuario, contraseña);
	}

}