import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dni = null, dniBorrar, dniModificar, dniModificarNotas;
        int opcion, opcionModificar = 0;
        char letra;
        String pregAgregarDni, pregEliminarDni;
        final int FILAS = 100, COLUMNAS = 9;
        boolean agregarDni, pregElimarDniBool, dniValido;
        String[][] alumnos = new String[FILAS][COLUMNAS];
        Scanner sc = new Scanner(System.in);



        do {
            System.out.println("\nMenu de opciones");
            System.out.println("1- Agregar usuario");
            System.out.println("2- Eliminar usuario");
            System.out.println("3- Modificar usuario");
            System.out.println("4- Introducir/Modificar notas");
            System.out.println("5- Ver todos los alumnos");
            System.out.println("6- Salir");

            letra = sc.next().toLowerCase().charAt(0);
            opcion = Character.getNumericValue(letra);

            switch (opcion) {
                case 1:
                    do {
                        agregarDni = false;
                        new ComprobarDni(dni);
                        System.out.println(dni);
                        for (int i = 0; i < FILAS; i++) {
                            if (!Objects.equals(alumnos[i][0], dni)) {
                                if (alumnos[i][0] == null || agregarDni) {
                                    alumnos[i][0] = dni;
                                    System.out.println("Introduce el Nombre");
                                    alumnos[i][1] = sc.next().toLowerCase();
                                    System.out.println("Introduce los Apellidos");
                                    alumnos[i][2] = sc.next().toLowerCase();
                                    i = FILAS;
                                    agregarDni = true;
                                }
                            } else {
                                System.out.println("El Dni ya esta en la base de datos");
                                break;
                            }
                        }
                        if (!agregarDni){
                            System.out.println("Desea introducir otro DNI?");
                            pregAgregarDni = sc.next().toLowerCase();
                            String primerCaracterPregAgregarDni = Character.toString(pregAgregarDni.charAt(0));
                            switch (primerCaracterPregAgregarDni){
                                case "s":
                                    break;
                                case "n":
                                    agregarDni = true;
                                    break;
                                default:
                                    System.out.println("Debe escribir s o n");
                            }
                        }
                    }while (!agregarDni);
                    break;

                case 2:
                    pregElimarDniBool = false;
                    System.out.println("Introduce el DNI del usuario que desea eliminiar");
                    dniBorrar = sc.next().toLowerCase();
                    for (int i = 0; i < FILAS; i++) {
                        if (alumnos[i][0]!= null && Objects.equals(alumnos[i][0], dniBorrar)) {
                            System.out.println("Esta apunto de eliminar al alumno "+alumnos[i][0]+" " +alumnos[i][1]+", "+alumnos[i][2]);
                            System.out.println("Esta seguro/a que desea continuar?");
                            do {
                                pregEliminarDni = sc.next().toLowerCase();
                                String primerCaracterPregEliminarDni = Character.toString(pregEliminarDni.charAt(0));
                                switch (primerCaracterPregEliminarDni){
                                    case "s":
                                        alumnos[i][0] = null;
                                        System.out.println("Alumno eliminado correctamente");
                                        pregElimarDniBool = true;
                                        break;
                                    case "n":
                                        System.out.println("Operacion cancelada");
                                        pregElimarDniBool = true;
                                        break;
                                    default:
                                        System.out.println("Debe escribir si o no");
                                }
                            } while (!pregElimarDniBool);

                            break;
                        }
                    }
                    if (!pregElimarDniBool){
                        System.out.println("El DNI no esta en la base de datos");
                    }
                    break;
                case 3:
                    System.out.println("Introduce el DNI del usuario que desea modificar");
                    dniModificar = sc.next().toLowerCase();
                    for (int i = 0; i < FILAS; i++) {
                    do {

                            if (alumnos[i][0]!= null && Objects.equals(alumnos[i][0], dniModificar)) {
                                System.out.println("Opciones para modificar");
                                System.out.println(" 1- Modificar Nombre");
                                System.out.println(" 2- Modificar Apellidos");
                                System.out.println(" 3- Salir");
                                opcionModificar = sc.nextInt();
                                switch (opcionModificar){
                                    case 1:
                                        System.out.println("El Nombre actual es "+alumnos[i][1] + " escribe el nuevo NOMBRE");
                                        alumnos[i][1] = sc.next().toLowerCase();
                                        break;
                                    case 2:
                                        System.out.println("Los apellidos actuales son "+alumnos[i][2] + " escribe los nuevos APELLIDOS");
                                        alumnos[i][2] = sc.next().toLowerCase();
                                        break;
                                    case 3:
                                        break;
                                }
                            }
                        } while (opcionModificar != 3);
                    }
                    break;
                case 4:
                    System.out.println("Introduce el DNI del alumno al que deseas poner notas");
                    dniModificarNotas = sc.next().toLowerCase();
                    for (int i = 0; i < FILAS; i++) {
                        do {
                            if ( alumnos[i][0]!= null && Objects.equals(alumnos[i][0], dniModificarNotas)) {
                                System.out.println("Las notas del usuario " + alumnos[i][1] + " "+ alumnos[i][2] + " son: ");
                                System.out.println("Programacion: "+ alumnos[i][3]);
                                System.out.println("ENTRONOS: "+ alumnos[i][4]);
                                System.out.println("BD: "+ alumnos[i][5]);
                                System.out.println("MARCAS: "+ alumnos[i][6]);
                                System.out.println("FOL: "+ alumnos[i][7]);
                                System.out.println("SISTEMAS: "+ alumnos[i][8]);

                                System.out.println();
                                System.out.println("Opciones para poner notas");
                                System.out.println(" 1- Introducir/Modificar nota de Programacion");
                                System.out.println(" 2- Introducir/Modificar nota de ENTRONOS");
                                System.out.println(" 3- Introducir/Modificar nota de BD");
                                System.out.println(" 4- Introducir/Modificar nota de MARCAS");
                                System.out.println(" 5- Introducir/Modificar nota de FOL");
                                System.out.println(" 6- Introducir/Modificar nota de SISTEMAS");
                                System.out.println(" 7- Salir");
                                opcionModificar = sc.nextInt();
                                switch (opcionModificar){
                                    case 1:
                                        System.out.println("Nota de PROGRAMACION para el usuario "+alumnos[i][1]);
                                        alumnos[i][3] = sc.next().toLowerCase();
                                        break;
                                    case 2:
                                        System.out.println("Nota de ENTRONOS para el usuario "+alumnos[i][1]);
                                        alumnos[i][4] = sc.next().toLowerCase();
                                        break;
                                    case 3:
                                        System.out.println("Nota de BD para el usuario "+alumnos[i][1]);
                                        alumnos[i][5] = sc.next().toLowerCase();
                                        break;
                                    case 4:
                                        System.out.println("Nota de MARCAS para el usuario "+alumnos[i][1]);
                                        alumnos[i][6] = sc.next().toLowerCase();
                                        break;
                                    case 5:
                                        System.out.println("Nota de FOL para el usuario "+alumnos[i][1]);
                                        alumnos[i][7] = sc.next().toLowerCase();
                                        break;
                                    case 6:
                                        System.out.println("Nota de SISTEMAS para el usuario "+alumnos[i][1]);
                                        alumnos[i][8] = sc.next().toLowerCase();
                                        break;
                                    case 7:
                                        break;
                                }
                            }
                        } while (opcionModificar != 7);
                    }
                    break;
                case 5:
                    System.out.print("|");
                    for (int i = 0; i < alumnos.length; i++) {
                        for (int j=0; j<alumnos[i].length; j++){
                            if (alumnos[i][0] != null) {
                                if (alumnos[i][j] == null || alumnos[i][j].isEmpty()) {
                                    System.out.print(alumnos[i][j]+ " |");
                                }else {
                                    System.out.print(alumnos[i][j].substring(0, 1).toUpperCase() + alumnos[i][j].substring(1).toLowerCase() + " |");
                                }
                                if (j + 1 >= alumnos[i].length) {
                                    System.out.println();
                                }
                            }
                        }
                    }
            }

        }while (opcion != 6);
    }
}