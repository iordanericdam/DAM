
public class Ejercicio1 {

	public static void main(String[] args) {
		/*
		 * 1. Crear una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla en forma de matriz.
		 */
		int[][] array = { {1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("Matriz:");
        for (int i =0; i<array.length;i++){
            System.out.print("{");
            for (int j =0; j<array[i].length;j++){
                if (j<2){
                    System.out.print(array[i][j] + ",");
                } else {
                    System.out.print(array[i][j]);
                }

            }
            System.out.print("}");
            System.out.println();
        }

	}

}
