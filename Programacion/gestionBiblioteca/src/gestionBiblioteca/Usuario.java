package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Usuario {
	
	String nombreUsuario, pass, dni, nombreCompleto;
	boolean administrador = false;
	
	
	
	
	public Usuario(String nombreUsuario, String pass, String dni, String nombreCompleto) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
	}




	public Usuario(String nombreUsuario, String pass, String dni, String nombreCompleto, boolean administrador) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.administrador = administrador;
	}
	

	public Usuario() {
		
	}
	

	public String getNombreUsuario() {
		return nombreUsuario;
	}




	public String getPass() {
		return pass;
	}




	public String getDni() {
		return dni;
	}




	public String getNombreCompleto() {
		return nombreCompleto;
	}




	public boolean isAdministrador() {
		return administrador;
	}




	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", pass=" + pass + ", dni=" + dni + ", nombreCompleto="
				+ nombreCompleto + ", administrador=" + administrador + "]";
	}
	
	protected  void mostrarInformacionUsuarios(ArrayList<Usuario> listaUsuarios) {
		System.out.println("Información de los usuarios:");
		for (Usuario usu : listaUsuarios) {
			System.out.println(usu.toString());
		}
	}
	
	protected static void comprobarCredenciales(ArrayList<Usuario> listaUsuarios, Scanner sc ) {
		String nombreUsuario, pass;
		System.out.print("Introduce tu nombre de usuario: ");
		nombreUsuario = sc.next();
		System.out.print("Introduce tu contrseña: ");
		pass = sc.next();
		boolean encontrado = false;
		int i = 0;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			i++;
			if (usu.getNombreUsuario().equals(nombreUsuario) ){
				encontrado = true;
				if (usu.getPass().equals(pass)) {
					System.out.println("Credenciales correctas");
				} else {
					System.out.println("contraseña incorrecta");
				}
			} else {
				System.out.println("usuario incorrecto");
			}
		}
		
	}
	
	
	
	
	
//	protected void altaUsuario(ArrayList<Usuario> listaUsuarios, Usuario usu) {
//		
//		
//		
//	}
	
	



}
