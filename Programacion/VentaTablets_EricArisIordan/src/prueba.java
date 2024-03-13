import java.util.Scanner;

public class prueba {

	public static void main(String[] args) {
		String nombre, apellidos;
		Scanner consola=new Scanner(System.in);
		
		System.out.print("Dime tu nombre: ");
		nombre = consola.nextLine();
		System.out.print("Dime tus apellidos: ");
		apellidos = consola.nextLine();
		
		System.out.println(nombre + apellidos);
		

	}

}
