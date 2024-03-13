package TareaEvaluable2;

import java.util.ArrayList;
import java.util.Scanner;

public final class Programador extends Empleado {

	int lineasDeCodigoPorHora;
	String lenguajeDominante, categoria;
	static int EDADMINIMA = 18;
	static int EDADMAXIMA = 45;
	
	public Programador() {
		
	}

	protected Programador(String nombre, String dni, int edad, boolean casado, int lineasDeCodigoPorHora, String lenguajeDominante){
		super(nombre, dni, edad, casado);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
		
	}
	
	protected Programador(String nombre, String dni, int edad, boolean casado ){
		super(nombre, dni, edad, casado);
	}
	

	protected int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}

	protected void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}

	protected String getLenguajeDominante() {
		return lenguajeDominante;
	}

	protected void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}

	protected String getCategoria() {
		return categoria;
	}

	protected void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	protected static boolean edadValida(int edad, int edadMinima, int edadMaxima) {
		boolean correcto = false;
		if (edad > 0) {
			if (edad < edadMinima) {
				System.out.println("El programador no puede tener menos de " + edadMinima + " años");
			} else if (edad > edadMaxima) {
				System.out.println("El programador no puede tener mas de " + edadMaxima + " años");
			} else {
				correcto = true;
			}
		}
		return correcto;

	}
	
	protected void asignarCategoria() {
	    if (edad <= 21) {
	        categoria = "principiante";
	    } else if (edad >= 22 && edad <= 35) {
	        categoria = "intermedio";
	    } else {
	        categoria = "senior";
	    }
	    asignarSalario();
	}
	
	protected void asignarSalario() {
		if(getCategoria().equals("principiante")) {
			setSalario(1500);
			} else if (getCategoria().equals("intermedio")) {
				setSalario(2000);
			} else {
				setSalario(2500);
		}
	}
	
	protected static void añadirProgramador(String dni, ArrayList<Empleado> listaEmpleados, Scanner sc, Empleado emp) {
		String nombre, edadS, lineasDeCodigoPorHoraS, lenguajeDominante;
		int edad, lineasDeCodigoPorHora;
		if (Empleado.validarDNI(dni) || Empleado.validarNIE(dni) ) {
			if (!Empleado.comprobarEmpleado(dni, listaEmpleados)) {
				sc.nextLine();
				do {
					System.out.print("Introduce el nombre y apellidos: ");
					nombre = sc.nextLine();
				} while (!Main.comprobarString(nombre, 5));

				do {
					System.out.print("Introduce la edad: ");
					edadS = sc.next();
					edad = Main.comprobarSiNumero(edadS);
					if (Programador.edadValida(edad, EDADMINIMA, EDADMAXIMA)) {
						do {
							System.out.print("Introduce las lineas de codigo por hora: ");
							lineasDeCodigoPorHoraS = sc.next();
							lineasDeCodigoPorHora = Main.comprobarSiNumero(lineasDeCodigoPorHoraS);
						} while (lineasDeCodigoPorHora == 0);
						sc.nextLine();
						do {
							System.out.print("Introduce el lenguaje dominante: ");
							lenguajeDominante = sc.nextLine();
						} while (!Main.comprobarString(lenguajeDominante, 1));

						emp = new Programador(nombre, dni, edad, false, lineasDeCodigoPorHora,
								lenguajeDominante);
						((Programador) emp).asignarCategoria();
						Empleado.introducirEstadoCivil(emp, sc);
						listaEmpleados.add((Programador)emp);
					}
				} while (edad == 0);
			}
		} else {
			System.out.println("El DNI/NIE son incorrectos");
		}
	};

	@Override
	public String toString() {
	    return super.toString() +
	           "\nCategoría: " + categoria + 
	           "\nLíneas de código por hora: " + lineasDeCodigoPorHora + 
	           "\nLenguaje dominante: " + lenguajeDominante +
	           "\n---------------------------"; 
	}
}
