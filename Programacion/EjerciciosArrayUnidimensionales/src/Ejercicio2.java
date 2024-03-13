import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        int personas, mayorMedia = 0, menorMedia = 0;
        double media = 0;

        System.out.println("Vamos a calcular la altura media de tu grupo");

        System.out.println("Cuantas personas tiene tu grupo?");
        personas = sc.nextInt();
        double[] grupo = new double [personas];

        System.out.println("Debes introducir la altura de cada uno, debes usar la , para separar");
        
        for (int i = 0; i<grupo.length; i++){
            System.out.println("Introduce la altura de la "+ (i+1) + " persona");
            grupo[i] = sc.nextDouble();
        }
        System.out.println("Ya yengo las alturas procedo a calcular");
        
        for (double altura : grupo) {
        	media += altura;
        }
        
        media /= grupo.length;
        
        for (double altura : grupo) {
        	if (altura > media) {
        		mayorMedia++;
        	}else {
        		menorMedia++;
        	}
        }
        
        System.out.println("La media es "+ df.format(media));
        System.out.print("Existen "+ mayorMedia + " personas por encima de la media y " + menorMedia +" personas por debajo de la media");
        
        sc.close();

	}

}
