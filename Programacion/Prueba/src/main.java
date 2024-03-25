import java.util.Scanner;

public class main {

    public static void main(String[] args) {
    	int diasParaDevolucion = 0;
		do {
			System.out.print("¿En cuantos dias se debe devolver?");
			Scanner sc = new Scanner(System.in);
			String diasParaDevolucionS = sc .next();
			diasParaDevolucion = comprobarSiNumero(diasParaDevolucionS);
			
		} while (diasParaDevolucion == 0);
    }
    
    protected static int comprobarSiNumero(String diasParaDevolucionS) {
		int opcion = 0;
		try {
			opcion = Integer.parseInt(diasParaDevolucionS);
			if (opcion < 0) {
				System.out.println("Debes introducir un número mayor o igual que 0.");
				opcion = 0;
			}
		} catch (Exception e) {
			System.out.println("Debes introducir un numero.");

		}
		return opcion;
	}
    
}