import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * 3. Crear dos matrices de n filas x n columnas y sumar sus valores, los
		 * resultados se deben almacenar en otra matriz. Los valores y el tamaño No,
		 * serán insertados por el usuario. Mostrar las matrices originales y el
		 * resultado.
		 */

		String filasS, columnasS, numeroS, filasS2, columnasS2;
		int filas = 0, columnas = 0, filas2 = 0, columnas2 = 0, numero, filasMayor, columnasMayor, filasMenor,
				columnasMenor;
		int[][] arrayUno, arrayDos, arrayResultados;
		boolean filasCorrecto = false, columnasCorrecto = false, numeroCorrecto = false, filasCorrecto2 = false,
				columnasCorrecto2 = false;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce las FILAS que deseas en la matriz");
			filasS = sc.next();
			try {
				filas = Integer.parseInt(filasS);
				filasCorrecto = true;
			} catch (Exception e) {
				System.out.println("Debe introducir numero/s del 0 al 9");
			}
		} while (!filasCorrecto);

		do {
			try {
				System.out.println("Introduce las COLUMNAS que deseas en la matriz");
				columnasS = sc.next();
				columnas = Integer.parseInt(columnasS);
				columnasCorrecto = true;
			} catch (Exception e) {
				System.out.println("Debe introducir numero/s del 0 al 9");
			}

		} while (!columnasCorrecto);

		arrayUno = new int[filas][columnas];

		System.out.println("Matriz generada correctamente, procedamos a introducir los numeros");
		for (int i = 0; i < arrayUno.length; i++) {
			for (int j = 0; j < arrayUno[i].length; j++) {
				do {
					numeroCorrecto = false;
					System.out.print("Introduza el valor de la posicion i:" + (i + 1) + " j:" + (j + 1) + "  ");
					numeroS = sc.next();
					try {
						numero = Integer.parseInt(numeroS);
						arrayUno[i][j] = numero;
						numeroCorrecto = true;
					} catch (Exception e) {
						System.out.println("Debe introducir numero/s del 0 al 9");
					}
				} while (!numeroCorrecto);

			}
		}

		do {
			System.out.println("Introduce las FILAS que deseas en la segunda matriz");
			filasS2 = sc.next();
			try {
				filas2 = Integer.parseInt(filasS2);
				filasCorrecto2 = true;
			} catch (Exception e) {
				System.out.println("Debe introducir numero/s del 0 al 9");
			}
		} while (!filasCorrecto2);

		do {
			try {
				System.out.println("Introduce las COLUMNAS que deseas en la segunda matriz");
				columnasS2 = sc.next();
				columnas2 = Integer.parseInt(columnasS2);
				columnasCorrecto2 = true;
			} catch (Exception e) {
				System.out.println("Debe introducir numero/s del 0 al 9");
			}

		} while (!columnasCorrecto2);

		arrayDos = new int[filas2][columnas2];
		System.out.println("Debe rellenar la segunda matriz: ");

		for (int i = 0; i < arrayDos.length; i++) {
			for (int j = 0; j < arrayDos[i].length; j++) {
				do {
					numeroCorrecto = false;
					System.out.print("Introduza el valor de la posicion i:" + (i + 1) + " j:" + (j + 1) + "  ");
					numeroS = sc.next();
					try {
						numero = Integer.parseInt(numeroS);
						arrayDos[i][j] = numero;
						numeroCorrecto = true;
					} catch (Exception e) {
						System.out.println("Debe introducir numero/s del 0 al 9");
					}
				} while (!numeroCorrecto);
			}
		}

		System.out.println();

		System.out.println("La primera matriz que ha introducido es esta: ");
		for (int i = 0; i < arrayUno.length; i++) {
			System.out.print("{");
			for (int j = 0; j < arrayUno[i].length; j++) {
				if (j < arrayUno[i].length - 1) {
					System.out.print(arrayUno[i][j] + ",");
				} else {
					System.out.print(arrayUno[i][j]);
				}

			}
			System.out.print("}");
			System.out.println();
		}

		System.out.println("Su segunda matriz se ve asi: ");
		for (int i = 0; i < arrayDos.length; i++) {
			System.out.print("{");
			for (int j = 0; j < arrayDos[i].length; j++) {
				if (j < arrayDos[i].length - 1) {
					System.out.print(arrayDos[i][j] + ",");
				} else {
					System.out.print(arrayDos[i][j]);
				}

			}
			System.out.print("}");
			System.out.println();
		}

		filasMayor = (filas > filas2) ? filas : filas2;
		columnasMayor = (columnas > columnas2) ? columnas : columnas2;

		filasMenor = (filas < filas2) ? filas : filas2;
		columnasMenor = (columnas < columnas2) ? columnas : columnas2;

		arrayResultados = new int[filasMayor][columnasMayor];

		System.out.println("Voy a sumar las dos matrizes");

//		for (int i = 0; i < arrayResultados.length; i++) {
//			for (int j = 0; j < arrayResultados[i].length; j++) {
//				if (j<columnasMenor && i<filasMenor) {
//					arrayResultados[i][j] = arrayUno[i][j] + arrayDos[i][j];
//				} else if(filas<filas2 && columnas<columnas2){
//					arrayResultados[i][j] = arrayDos[i][j];
//				} else if (filas>filas2){
//					arrayResultados[i][j] = arrayUno[i][j];
//				} else if(filas2>filas){
//					arrayResultados[i][j] = arrayDos[i][j];
//				} else {
//					arrayResultados[i][j] = arrayUno[i][j];
//				}
//					
//				
//
//			}
//		}

		for (int i = 0; i < arrayResultados.length; i++) {
			for (int j = 0; j < arrayResultados[i].length; j++) {
				if (j < columnasMenor && i < filasMenor) {
					arrayResultados[i][j] = arrayUno[i][j] + arrayDos[i][j];
				} else if (columnas2>columnas) {
					arrayResultados[i][j] = arrayDos[i][j];
				} else if (filas>filas2 ) {
					arrayResultados[i][j] = arrayUno[i][j];
				} else {
					System.out.println("Hola mundo");
				}
			}
		}

		System.out.println("Los resultados son los siguinetes: ");
		for (int i = 0; i < arrayResultados.length; i++) {
			System.out.print("{");
			for (int j = 0; j < arrayResultados[i].length; j++) {
				if (j < arrayResultados[i].length - 1) {
					System.out.print(arrayResultados[i][j] + ",");
				} else {
					System.out.print(arrayResultados[i][j]);
				}

			}
			System.out.print("}");
			System.out.println();
		}

		sc.close();

	}

}
