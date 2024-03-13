// Clase Vehiculo común para Coche y Furgoneta

import java.util.ArrayList;
import java.util.Scanner;

class Vehiculo {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected String color;
    protected int numPlazas;
    protected int km;

    // Constructor y métodos comunes
}

// Clase Coche, subclase de Vehiculo
class Coche extends Vehiculo {
    // Constructor y métodos específicos de Coche
}

// Clase Furgoneta, subclase de Vehiculo
class Furgoneta extends Vehiculo {
    private int PMA; // Atributo específico de Furgoneta

    // Constructor y métodos específicos de Furgoneta
}

// Clase principal
public class test2 {
    protected static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        // Añadir un coche
        añadirVehiculo(listaVehiculos);

        // Añadir una furgoneta
        añadirFurgoneta(listaVehiculos);

        // Mostrar los vehículos agregados
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(vehiculo);
        }
    }

    // Método genérico para añadir un vehículo
    protected static void añadirVehiculo(ArrayList<Vehiculo> listaVehiculos) {
        String matricula, marca, modelo, color, numPlazasS, kmS;
        int numPlazas, km;

        System.out.print("Introduzca la matricula: ");
        matricula = scanner.next();
        // Añade lógica para comprobar si ya existe la matrícula y gestionarla si es necesario
        // ...

        System.out.print("Introduzca la marca: ");
        marca = scanner.next();
        System.out.print("Introduzca el modelo: ");
        modelo = scanner.next();
        System.out.print("Introduzca el color: ");
        color = scanner.next();
        do {
            System.out.print("Introduzca el número de plazas: ");
            numPlazasS = scanner.next();
            numPlazas = Integer.parseInt(numPlazasS);
        } while (numPlazas <= 0);

        do {
            System.out.print("Introduzca el número de kilometros del vehículo: ");
            kmS = scanner.next();
            km = Integer.parseInt(kmS);
        } while (km <= 0);

        Coche coche = new Coche(matricula, marca, modelo, color, numPlazas, km);
        listaVehiculos.add(coche);
    }

    // Método específico para añadir una furgoneta
    protected static void añadirFurgoneta(ArrayList<Vehiculo> listaVehiculos) {
        añadirVehiculo(listaVehiculos); // Solicita y almacena los atributos comunes
        System.out.print("Introduzca el PMA (Peso Máximo Autorizado) de la furgoneta: ");
        int PMA = scanner.nextInt();

        // Obtén la última furgoneta añadida (que es el último elemento de la lista)
        Furgoneta furgoneta = (Furgoneta) listaVehiculos.get(listaVehiculos.size() - 1);
        furgoneta.setPMA(PMA); // Establece el PMA específico de la furgoneta
    }
}
