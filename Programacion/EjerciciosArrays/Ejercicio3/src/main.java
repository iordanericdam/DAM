import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char dni[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','W','V','H','L','C','K','E'};
		int calculo;
		char letra = 'a';
		String dniUsuario;
		
		System.out.println("Dime tu dni sin letra");
		dniUsuario = sc.next();
		
		int numDniUsuario = Integer.parseInt(dniUsuario);
		
		
		
		calculo = numDniUsuario % 23;
		
		letra = dni[calculo];
		
		System.out.print("Tu letra es la "+ letra + " por lo cual tu DNI es " + dniUsuario + letra);
	}

}
