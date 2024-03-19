package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Usuario> listaUsuarios= new ArrayList<Usuario>();
		Usuario admin1 = new Usuario("eric", "Eric123", "X9114660J", "Eric Iordan", true);
		listaUsuarios.add(admin1);
		Usuario admin2 = new Usuario("edurne", "edurne123", "50322180C", "Edurne", true);
		listaUsuarios.add(admin2);
		
		
		String nombreUsuario, pass;
		
		
//		Usuario.mostrarInformacionUsuarios(listaUsuarios);
		
		
		System.out.println("Bienvenido/a a la bibloteca Todo Libros");
		
		Usuario.comprobarCredenciales(listaUsuarios, sc );
		
		
		
		
		
		
		
		
		
		
	}
	


	

}
