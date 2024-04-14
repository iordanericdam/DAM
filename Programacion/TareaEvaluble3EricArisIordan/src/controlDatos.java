import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class controlDatos {
	
	protected static int comprobarSiNumero(String numeroS) {
		int opcion = -1;
		try {
			opcion = Integer.parseInt(numeroS);
			if (opcion < 0) {
				System.out.println("Debes introducir un número mayor o igual que 0.");
				opcion = -1;
			}
		} catch (NumberFormatException e) {
			System.out.println("Debes introducir un numero.");
		} catch (Exception e) {
			
		}
		return opcion;
	}

	protected static boolean comprobarString(String variableS, int caracteres) {
		boolean correcto = false;
		if (variableS.length() < caracteres) {
			System.out.println("La longitud debe de ser minimo de " + caracteres + " caracteres");
		} else {
			correcto = true;
		}
		return correcto;

	}

	protected static boolean obtenerRespuestaSiNo(Scanner sc, String pregunta) {
		boolean respuesta;
		while (true) {
			System.out.print(pregunta + " (responda con si o no): ");
			char respuestaChar = sc.next().toLowerCase().charAt(0);
			if (respuestaChar == 's') {
				respuesta = true;
				break;
			} else if (respuestaChar == 'n') {
				respuesta = false;
				break;
			} else {
				System.out.println("Por favor, responda con si o no.");
			}
		}
		return respuesta;
	}
	
    public static boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".") &&
               email.indexOf('@') > 0 && email.indexOf('@') < email.length() - 1;
    }
	
	protected static  boolean validarDNI(String dni) {
		if (dni == null || dni.length() != 9) {
			return false;
		}

		for (int i = 0; i < 8; i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				return false;
			}
		}

		char letra = Character.toUpperCase(dni.charAt(8));
		if (!Character.isLetter(letra)) {
			return false;
		}

		int numDNI;
		try {
			numDNI = Integer.parseInt(dni.substring(0, 8));
		} catch (NumberFormatException e) {
			return false;
		}

		char letraCalculada = calcularLetra(numDNI);

		if (letra != letraCalculada) {
			return false;
		}

		return true;
	}

	private static char calcularLetra(int numero) {
		String letrasNIE = "TRWAGMYFPDXBNJZSQVHLCKE";
		int indiceLetra = numero % 23;
		return letrasNIE.charAt(indiceLetra);

	}

	protected static boolean validarNIE(String nie) {
		char primeraLetra = nie.charAt(0);
		if (primeraLetra == 'X') {
			nie = "0" + nie.substring(1);
		} else if (primeraLetra == 'Y') {
			nie = "1" + nie.substring(1);
		} else if (primeraLetra == 'Z') {
			nie = "2" + nie.substring(1);
		} else {
			return false;
		}

		if (nie.length() != 9 || !nie.substring(1).matches("\\d{7}[A-Z]")) {
			return false;
		}

		String digitos = nie.substring(0, 8);
		int numNIE = Integer.parseInt(digitos);
		char letraCalculada = calcularLetra(numNIE);
		char letraControl = nie.charAt(8);

		if (letraControl != letraCalculada) {
			return false;
		}

		return true;
	}
	
	protected static String pedirDni(Scanner sc, Class<? extends Usuario> tipoUsuario ) {
		String dni;
		System.out.print("Introduce el DNI del " + tipoUsuario.getSimpleName() + " :");
		dni = sc.next();
		return dni;
		
	}
	
	protected static String pedirNombreCompleto(Scanner sc, Class<? extends Usuario> tipoUsuario ) {
		String nombreCompleto;
		do {
			sc.nextLine();
			System.out.print("Introduce el nombre completo del " + tipoUsuario.getSimpleName() + ": ");
			nombreCompleto = sc.nextLine().toLowerCase();
		} while (!controlDatos.comprobarString(nombreCompleto, 5));
		return nombreCompleto;

	}
	
	protected static String pedirDniNuevo(Scanner sc, Class<? extends Usuario> tipoUsuario, ArrayList<Usuario> listaUsuarios) {
		String dni = null;
		boolean respuestaBool = false;
		do {
			System.out.print("Introduce el DNI o NIE: ");
			dni = sc.next().toUpperCase();
			if (!validarDNI(dni) && !validarNIE(dni)) {
				System.out.println("El DNI o NIE introducidos son incorrectos.");
				respuestaBool = obtenerRespuestaSiNo(sc, "¿Deseas volver a escribirlo?");
				if (!respuestaBool) {
					dni = null;
				}
			} else {
				respuestaBool = false;
			}

			if (comprobarUsaurio(dni, listaUsuarios)) {
				respuestaBool = obtenerRespuestaSiNo(sc, "¿Deseas escribir otro DNI?");
				dni = null;
			}
		} while (respuestaBool);
		
		return dni;
	}
	
	protected static LocalDate pedirFecha(Scanner sc, String pregunta) {
		String fechaS;
		do {
			sc.nextLine();
			System.out.print(pregunta);
			fechaS = sc.nextLine();
		} while (!controlDatos.validarFormatoFecha(fechaS));
		
		return LocalDate.parse(fechaS, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	protected static String pedirNombreUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios) {
		String nombreUsuario;
		do {
			System.out.print("Introduce el nombre de usuario que desearia tener: ");
			nombreUsuario = sc.next().toLowerCase();

			if (comprobarNombreUsuario(nombreUsuario, listaUsuarios)) {
				System.out.println("El nombre de usuario ya esta en el sistema");
			}
		} while (comprobarNombreUsuario(nombreUsuario, listaUsuarios));
		return nombreUsuario;
	}
	
	protected static String	pedirEmail(Scanner sc) {
		String email;
		sc.nextLine();
		do {
			System.out.print("Introduce un email: ");
			email = sc.next().toLowerCase();
		} while (!controlDatos.validarEmail(email));
		return email;
	}
	
	protected static int pedirOpcion(Scanner sc, String pregunta) {
		String opcionS;
		int opcion;
		System.out.print(pregunta);
		opcionS = sc.next();
		opcion = controlDatos.comprobarSiNumero(opcionS);
		return opcion;
	}
	
	
	
	private static boolean comprobarNombreUsuario(String nombreUsuario, ArrayList<Usuario> listaUsuarios) {
		boolean encontrado = false;
		int i = 0;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (usu instanceof Usuario) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
				}
			}
			i++;
		}
		return encontrado;
	}
	
	private static boolean comprobarUsaurio(String dni, ArrayList<Usuario> listaUsuarios) {
		boolean existe = false;
		for (Usuario usu : listaUsuarios) {
			if (usu.getDni() != null && usu.getDni().equals(dni)) {
				System.out.println("El DNI ya se encuentra registrado");
				existe = true;
				break;
			}
		}
		return existe;
	}
	
    public static boolean validarFormatoFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            formatter.parse(fecha);
            return true;
        } catch (DateTimeParseException e) {
        	System.out.println("Formato de fecha incorrecta, formato correcto DD/MM/AAAA");
            return false;
        }
    }
    
//    Habitacion
    
    protected static String pedirNombreHabitacion(Scanner sc) {

		String nombreHabitacion;
		do {
			System.out.print("Introduce el nombre de la habitacion: ");
			sc.nextLine();
			nombreHabitacion = sc.nextLine().toLowerCase();
		} while (!controlDatos.comprobarString(nombreHabitacion, 3));
		
		
		return nombreHabitacion;
	}
    
	protected static LocalDate pedirPrimerNoche(Scanner sc) {
		LocalDate primeraNoche, fechaDelSistema = LocalDate.now(), fechaMaxima;
		boolean fechaCorrecta = false;
		fechaMaxima = fechaDelSistema.plusDays(Reserva.MAX_DIAS_RESERVA);
		do {
			primeraNoche = controlDatos.pedirFecha(sc, "Introduzca la fecha de la primera noche que desea reservar, el formato debe ser DD/MM/AAAA: ");
			if (!primeraNoche.isBefore(fechaDelSistema)) {
                fechaCorrecta = true;
            } else {
            	System.out.println("La fecha ingresada debe ser posterior a la fecha del sistema.");
            	 fechaCorrecta = false;
            }
			
			if (primeraNoche.isBefore(fechaMaxima) && fechaCorrecta){
				fechaCorrecta = true;
			} else if (primeraNoche.isAfter(fechaMaxima)){
				System.out.println("No se permiten reservas superiores a " + Reserva.MAX_DIAS_RESERVA +" dias");
				fechaCorrecta = false;
			}
			
		} while (!fechaCorrecta);
		
		
		return primeraNoche;
		
	}
	
	protected static int pedirCategoria(Scanner sc) {
		int categoria;
		do {
			categoria = Menus.seleccionarCategoria(sc);
		} while (categoria != 1 && categoria != 2 && categoria != 3 && categoria != 4);
		return categoria;
	}
	
	protected static int pedirPrecioNoche(Scanner sc) {
		int numero;
		do {
			numero = controlDatos.pedirOpcion(sc, "Introduce el precio por noche de la habitacion: ");
			if (numero < Habitacion.PRECIOMINIMONOCHE) {
				System.out.println("El precio minimo por noche establecido es de "+ Habitacion.PRECIOMINIMONOCHE+"€" );
			}
		} while (numero < 50);
		
		return numero;
		
	}
	
	protected static int pedirNoches(Scanner sc) {
		int numero;
		
		do {
			numero = controlDatos.pedirOpcion(sc, "Introduce el numero de noches que desea reservar: ");
			if (numero > 10) {
				System.out.println("No es posible reservar mas de 10 noches seguidas");
				numero = -1;
			}
		} while (numero < 0);
		
		return numero;
		
	}
	
	


}
