
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario {
	String dni, nombreCompleto, email, nombreUsuario, contraseña;
	LocalDate fechaNacimiento;
	boolean primerLogin = true;

	public Usuario() {
	}

	public Usuario(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña,
			LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(String dni, String nombreCompleto, String email, String nombreUsuario, String contraseña) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public Usuario(String dni, String nombreCompleto, String nombreUsuario, String contraseña) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public Usuario(String nombreCompleto, String nombreUsuario, String contraseña) {
		this.nombreCompleto = nombreCompleto;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean isPrimerLogin() {
		return primerLogin;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setPrimerLogin(boolean primerLogin) {
		this.primerLogin = primerLogin;
	}

	

	

	@Override
	public String toString() {
		return String.format(
				"DNI: %s%n" + "Nombre completo: %s%n" + "Email: %s%n" + "Nombre de usuario: %s%n" 
						+ "Fecha de nacimiento: %s%n",
				dni, nombreCompleto, email, nombreUsuario, fechaNacimiento);
	}

}
