import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*
		 * 2. Crear una matriz de 5 filas y n columnas (se pide al usuario). Rellenarlo
		 * con números aleatorios entre 0 y 10.
		 */

		int columnas = 0;
		String columnasS;
		boolean columnasCorrecto = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Introduce las columnas que desea tener la matriz: ");
			columnasS = sc.next();
			try {
				columnas = Integer.parseInt(columnasS);
				columnasCorrecto = true;
			} catch (Exception e) {
				System.out.println("Debes introducir numero/s del 0 al 0");
			}
		}while (!columnasCorrecto);

		int[][] array = new int[5][columnas];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) Math.floor(Math.random() * 10 + 1);
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print("{");
			for (int j = 0; j < array[i].length; j++) {
				if (j < array[i].length - 1) {
					System.out.print(array[i][j] + ",");
				} else {
					System.out.print(array[i][j]);
				}

			}
			System.out.print("}");
			System.out.println();
		}
		sc.close();
	}

}
