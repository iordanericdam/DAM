package ejercicioExcepciones;
public class ejercicio2 {
    public static double media(int n, int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío");
        }
        
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += array[i];
        }
        
        return (double)suma / n;
    }
    
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {10,20,50,100};
        int[] array3 = {};
        
        try {
            System.out.println("La media del array1 es: " + media(array1.length, array1));
            System.out.println("La media del array2 es: " + media(array2.length, array2));
            System.out.println("La media del array3 es: " + media(array3.length, array3));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
