import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        final int[] array = new int[10];
        int cero = 0, positivo = 0, negativo = 0;
        System.out.println("Debe introducir "+array.length+ " numeros");

        for (int i = 0; i<array.length; i++){
            System.out.println("Introduzca el "+(i+1) + " numero");
            array[i] = sc.nextInt();
        }

        System.out.println("Ya tenememos los "+array.length+ " numeros");

        for (int j : array) {
            if (j > 0) {
                positivo++;
            } else if (j < 0) {
                negativo++;

            } else {
                cero++;
            }
        }

        System.out.println("En los numeros que has introducido hay "+positivo + " numeros positivos, "+ negativo + " numeros negativos y " + cero + " ceros" );

        sc.close();

	}

}
