package cuentaBancariaV2;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String opcionS, nombre, apellidos, dni, passUsuario = null, pass, pass2, cantidadS;
		double cantidad = 0;
		final double CantidadMinima = 20;
		int opcion = 0;
		boolean inputValidoB = false, passCorrectaB = false, samePass = false, cuentaEncontrada = false, dniCorrecto;
		Scanner sc = new Scanner(System.in);
		ArrayList <Cuenta> Cuentas = new ArrayList <Cuenta> ();
		
		 
		
		do {
			menuPrincipal();
			opcionS = sc.next();
			opcion = comprobarOpcion(opcionS, opcion);

			switch (opcion) {
			case 1:
				sc.nextLine();
				System.out.print("Bienvenido al banco CajaUrbana, ¿cual es su nombre?: ");
				do {
					nombre = sc.nextLine().toLowerCase();
					inputValidoB = Cuenta.inputValido(nombre, inputValidoB);

				} while (!inputValidoB);
				System.out.print("¿Cuales son/es su apellido?: ");
				do {
					apellidos = sc.nextLine().toLowerCase();
					inputValidoB = Cuenta.inputValido(apellidos, inputValidoB);

				} while (!inputValidoB);
				System.out.print("Bienvenido " + nombre + " " + apellidos + ". Escriba su DNI/NIE con letra: ");
				dniCorrecto = false;
				do {
					dni = sc.nextLine().toLowerCase();
					 if (validarDNI(dni)) {
						 System.out.println("El DNI es válido.");
					 		dniCorrecto = true;
						 
					 }else {
				        	System.out.println("El DNI no es válido.");
				        }        
				} while (!dniCorrecto);
				
				System.out.println(
						"Para crear una cuenta en nuestro banco debe introducir un minimo de " + CantidadMinima + "€");
				do {
					System.out.println("¿Cuanto desea introducir en su cuenta?: ");
					cantidadS = sc.next();
					cantidad = comprobarcantidad(cantidadS, cantidad);

					if (cantidad < 20) {
						System.out.println("La cantidad debe ser igual o mayor que " + CantidadMinima + "€");
					}
				} while (cantidad < 20);
				System.out.print("Lo tenemos!, por ultimo crea una contraseña, esta deberatener minimo 8 caracteres: ");
				do {
					if (!samePass) {
						System.out.println("Crea una contraseña, esta deberatener minimo 8 caracteres");
					}

					do {
						pass = sc.next();
						passCorrectaB = Cuenta.passValidaLongitud(pass, passCorrectaB);
					} while (!passCorrectaB);
					System.out.println("Vuelve ha introducir la misma contraseña");
					do {
						pass2 = sc.next();
						passCorrectaB = Cuenta.passValidaLongitud(pass2, passCorrectaB);
					} while (!passCorrectaB);

					if (pass.equals(pass2)) {
						passUsuario = pass2;
						samePass = true;
					} else {
						System.out.println("Las contraseñas no coinicden vuelva a probar");
					}

				} while (!samePass);
				
		        Cuenta Cuenta = new Cuenta(nombre, apellidos, dni, passUsuario ,cantidad);

		        String ibanAsignado = Cuenta.asignarIban();

		        if (ibanAsignado != null) {
		            System.out.println("Se asignó el IBAN: " + ibanAsignado);
		            Cuenta.setIban(ibanAsignado);
		        } else {
		            System.out.println("No hay IBAN disponible en este momento.");
		        }
		        
		        Cuentas.add(Cuenta);
				break;
			case 2:
				sc.nextLine();
				System.out.println("Bienvenid@ de vuelta, para entrar en su cuenta primero debe registrarse, para ello escriba su dni: ");
				dni = sc.nextLine().toLowerCase();
				
				 for (int i = 0; i < Cuentas.size(); i++) {
				        Cuenta cuenta1 = Cuentas.get(i);
				        if(cuenta1.getDni().equals(dni)){
				        	System.out.println("Introduzca su contraseña señ@r "+ cuenta1.getApellidos());
				        	cuentaEncontrada = true;
				        	pass = sc.next();
				        	if (cuenta1.getPassUsuario().equals(pass)) {
				        		System.out.println("HAS ENTRADO A TU CUENTA!");

				        		do {
				        			menuUsuario();
					        		opcionS = sc.next();
					    			opcion = comprobarOpcion(opcionS, opcion);
					    			
					    			switch(opcion) {
					    			case 1:
					    				cantidad =0;
					    				System.out.println("¿Cuanto desea ingresar?: ");
					    				cantidadS = sc.next();
										cantidad = comprobarcantidad(cantidadS, cantidad);
					    				cuenta1.ingresarDinero(cantidad);
					    				break;
					    			case 2:
					    				cantidad =0;
					    				System.out.println("¿Cuanto desea sacar?");
					    				cantidadS = sc.next();
										cantidad = comprobarcantidad(cantidadS, cantidad);
					    				cuenta1.sacarDinero(cantidad);
					    				break;
					    			case 3:
					    				System.out.println("Este es su saldo: "+ cuenta1.getSaldo() + "€");
					    				break;
					    				
					    			case 4:
					    				System.out.println("Hasta la proxima");
					    				break;
					    			default:
					    				System.out.println("No has introducido un numero valido");
					    			
					    			}
				        		} while (opcion!=4);
				        		
				        		
				        	} else {
				        		System.out.println("Contraseña incorrecta");
				        	}
				        	
				        }
				        
				 }
				 
				 if (!cuentaEncontrada) {
					 System.out.println("Su cuenta no se encuentra en la base de datos, puede darse de alta pulsando la opcion 1");
				 }
				
				break;
			case 4:
				 System.out.println("Información de las cuentas creadas:");

				    for (int i = 0; i < Cuentas.size(); i++) {
				        Cuenta cuenta1 = Cuentas.get(i);

				        System.out.println("Cuenta " + (i + 1) + ":");
				        System.out.println("Nombre: " + cuenta1.getNombre());
				        System.out.println("Apellidos: " + cuenta1.getApellidos());
				        System.out.println("DNI: " + cuenta1.getDni());
				        System.out.println("Saldo: " + cuenta1.getSaldo());
				        System.out.println("IBAN: " + cuenta1.getIban());
				        System.out.println("------------------------");
				    }
				    break;
				    
			}

		} while (opcion != 3);
		
		sc.close();

	}

	public static void menuPrincipal() {
		System.out.println("1- Dar de alta una cuenta");
		System.out.println("2- Entrar a mi cuenta");
		System.out.println("3- Salir");

	}
	
	public static void menuUsuario() {
		System.out.println("1- Ingresar dinero");
		System.out.println("2- Sacar dinero");
		System.out.println("3- Comprobar saldo");
		System.out.println("4- Salir");

	}

	public static int comprobarOpcion(String opcionS, int opcion) {
		try {
			opcion = Integer.parseInt(opcionS);
		} catch (Exception e) {
			System.out.println("La opcion que has introducido no es un numero");
		}

		return opcion;
	}
	
	public static double comprobarcantidad(String cantidadS, double cantidad) {
		try {
			cantidad = Double.parseDouble(cantidadS);
		} catch (Exception e) {
			System.out.println("La cantidad debe estar en numeros y con un . PUNTO como separador (si tiene)");
		}

		return cantidad;
	}
	
	protected static boolean validarDNI(String dni) {
        if (dni == null || dni.length() != 9)
            return false;


        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i)))
                return false;
        }

        char letra = Character.toUpperCase(dni.charAt(8));
        if (!Character.isLetter(letra))
            return false;

        int numDNI = Integer.parseInt(dni.substring(0, 8));

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numDNI % 23;

        return letra == letras.charAt(resto);
    }

}
