package gestionBiblioteca;

public class Usuarios {
	String nombreUsuario, pass, nombreCompleto, dni, email;

	public Usuarios() {
		
	}
	
	public Usuarios(String nombreUsuario, String pass, String nombreCompleto, String dni, String email) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
