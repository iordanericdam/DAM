import java.util.Scanner;

public class ComprobarDni {
    public ComprobarDni(String dni) {
        String letraDni, numerosDni;
        final char[] comprobante = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','W','V','H','L','C','K','E'};
        int calculo;
        char letra;
        boolean dniValido=false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduce el DNI");
            dni = sc.next();
            numerosDni = dni.substring(0,8);
            letraDni = dni.substring(8).toUpperCase();
            int numDni = Integer.parseInt(numerosDni);

            calculo = numDni % 23;
            letra = comprobante[calculo];

            if (String.valueOf(letra).equals(letraDni)){
                System.out.println("El DNI es correcto");
                dniValido = true;
            } else {
                System.out.println("El Dni es incorrecto, revise la ortografia");
            }
        } while (!dniValido);

    }

    public static void main(String[] args) {

    }
}
