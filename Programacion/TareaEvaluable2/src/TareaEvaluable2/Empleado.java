package TareaEvaluable2;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Empleado {
	
	protected String nombre, dni;
	protected int edad;
	protected boolean casado;
	protected double salario;
	
	
	
	public Empleado() {
	}



	public Empleado(String nombre, String dni, int edad, boolean casado) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.casado = casado;
	}
	

	public Empleado(String nombre, String dni, int edad, double salario) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.salario = salario;
	}



	protected String getNombre() {
		return nombre;
	}



	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}



	protected String getDni() {
		return dni;
	}



	protected void setDni(String dni) {
		this.dni = dni;
	}



	protected int getEdad() {
		return edad;
	}



	protected void setEdad(int edad) {
		this.edad = edad;
	}



	protected boolean isCasado() {
		return casado;
	}



	protected void setCasado(boolean casado) {
		this.casado = casado;
	}



	protected double getSalario() {
		return salario;
	}



	protected void setSalario(double salario) {
		this.salario = salario;
	}



	@Override
	public String toString() {
	    return "\n---------------------------"+
	    	    "\nNombre: " + nombre +
	    		"\nDNI: " + dni +
	           "\nEdad: " + edad + 
	           "\nCasado: " + (casado ? "Sí" : "No") + 
	           "\nSalario: " + salario + "€";
	         
	}
	
	protected static boolean validarDNI(String dni) {
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
	
	protected static void introducirEstadoCivil(Empleado emp, Scanner sc) {
		boolean casadoBool;
		char casadoS;
		do {
			casadoBool = false;
			System.out.print("¿Está casado/a? Responda con si o no: ");
			casadoS = sc.next().toLowerCase().charAt(0);
			if (casadoS == 's') {
				emp.setCasado(true);
				casadoBool = true;
			} else if (casadoS == 'n') {
				emp.setCasado(false);
				casadoBool = true;
			} else {
				System.out.println("Debes escribir si o no");
			}
		} while (!casadoBool);
	}
	
	protected void subirSueldo(double cantidad) {
		double subida;
		 subida = salario * (cantidad / 100);
		 salario += subida;
		 System.out.println("Cada mes cobrara "+ subida +"€ de mas, es decir: "+ salario+ "€");
	}
	
	protected static void eliminarEmpleado(String dniEliminar, ArrayList<Empleado> listaEmpleados, Scanner sc) {
		int indiceAEliminar = -1;
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getDni().equals(dniEliminar)) {
				indiceAEliminar = i;
				boolean respuestaBool = Main.obtenerRespuestaSiNo(sc,
						"¿Estas seguro que quiere eliminar a " + listaEmpleados.get(i).getNombre() + "?");
				if (respuestaBool && indiceAEliminar != -1) {
					listaEmpleados.remove(indiceAEliminar);
				}
				break;
			}
		}
		if (indiceAEliminar == -1) {
			System.out.println("No se a encontrado a ningun programador con el DNI " + dniEliminar);
		}
	}
	
	protected static void mostrarInformacionEmpleados(ArrayList<Empleado> listaEmpleados) {
		System.out.println("Información de los programadores:");
		for (Empleado emp : listaEmpleados) {
			System.out.println(emp.toString());
		}
	}
	
	protected static boolean comprobarEmpleado(String dni, ArrayList<Empleado> listaEmpleados) {
		boolean existe = false;
		for (Empleado emp : listaEmpleados) {
			if (emp.getDni().equals(dni)) {
				System.out.println("El DNI ya se encuentra registrado");
				existe = true;
				break;
			}
		}
		return existe;
	}
	
	protected static void subirSueldo(String dniSueldo, ArrayList<Empleado> listaEmpleados, Scanner sc) {
		String cantidadS;
		boolean encontrado = false;
		double cantidad = 0;

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getDni().equals(dniSueldo)) {
				encontrado = true;
				do {
					System.out.print(
							"¿Que porcentaje desea subir el sueldo a " + listaEmpleados.get(i).getNombre() + "? ");
					cantidadS = sc.next();
					cantidad = Main.comprobarSiNumeroDecmales(cantidadS);
				} while (cantidad <= 0);

				boolean respuestaBool = Main.obtenerRespuestaSiNo(sc, "¿Estas seguro que quiere subirle el sueldo a "
						+ listaEmpleados.get(i).getNombre() + " un " + cantidad + "%?");
				if (respuestaBool) {
					listaEmpleados.get(i).subirSueldo(cantidad);
				}

			}
		}

		if (!encontrado) {
			System.out.println("No se a encontrado a ningun programador con el DNI " + dniSueldo);
		}

	}

}
