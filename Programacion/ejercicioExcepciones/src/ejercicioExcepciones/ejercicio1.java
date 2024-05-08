package ejercicioExcepciones;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		Numeros numeroClase = new Numeros();
		ArrayList<Integer> arrayNumeros = new ArrayList<>();
		String numeroS;
		int numero;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<6;i++) {
			
			do {
				System.out.print("Introduce un numero: ");
				numeroS = sc.next();
				numero = comprobarSiNumero(numeroS, arrayNumeros);
				
			} while (numero == -1);
			if (arrayNumeros.size() >= 6) {
					numeroClase.setNumeros(arrayNumeros);
					System.out.println(numeroClase.toString());
				}
			}
		}
	

	
	private static int comprobarSiNumero(String numeroS, ArrayList<Integer> arrayNumeros) {
		int opcion = -1;
		try {
			opcion = Integer.parseInt(numeroS);
			arrayNumeros.add(opcion);
		} catch (NumberFormatException e) {
			System.out.println("Debes introducir un numero.");
		} 
		return opcion;
	}

}
