package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Prestamo {

	int diaPrestamo;
	String dniUsuario, PKarticulo;
	boolean devuelto = false;

	public Prestamo(int diaPrestamo, String PKarticulo, String dniUsuario) {
		this.diaPrestamo = diaPrestamo;
		this.PKarticulo = PKarticulo;
		this.dniUsuario = dniUsuario;
	}

	public Prestamo() {
	}

	public int getDiaPrestamo() {
		return diaPrestamo;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public String getPKarticulo() {
		return PKarticulo;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	protected static void realizarPrestamo(Scanner sc, Usuario usu, ArrayList<Articulo> listaArticulos,
			Class<? extends Articulo> tipoArticulo, ArrayList<Prestamo> listaPrestamos) {
		int indiceMayor = -1, indiceMenor = 0, diaActual = -1;
		String dni, PKarticulo;
		for (int i = 0; i < listaArticulos.size(); i++) {
			Articulo art = listaArticulos.get(i);
			if (tipoArticulo.isInstance(art)) {
				if (art.isDisponible()) {

					System.out.println("----------" + tipoArticulo.getSimpleName() + " " + i + "----------");
					System.out.println(art.toString());
					indiceMayor = i;
					indiceMenor++;
				}
			}
			if (i == (listaArticulos.size() - 1) && indiceMayor != -1) {
				System.out.print("Introduce el numero del/de la " + tipoArticulo.getSimpleName().toLowerCase()
						+ " que desea llevarse prestado: ");
				String opcionS = sc.next();
				sc.nextLine();
				int opcion = main.comprobarSiNumero(opcionS);
				if (opcion != -1 && opcion <= indiceMayor && opcion >= (indiceMayor - indiceMenor) + 1) {
					art = listaArticulos.get(opcion);
					sc.nextLine();
					boolean respuestaBool = main.obtenerRespuestaSiNo(sc, "¿Está seguro que desea llevarse el "
							+ tipoArticulo.getSimpleName().toLowerCase() + " " + art.getNombre() + "?");
					if (respuestaBool) {

						art.setDisponible(false);
						dni = usu.getDni();
						PKarticulo = art.getNombre();
						sc.nextLine();
						do {
							System.out.println("Introduce el dia actual: ");
							String diaActualS = sc.next();
							diaActual = main.comprobarSiNumero(diaActualS);
							sc.nextLine();
						} while (diaActual == -1);

						System.out.println(
								"Tiene " + art.getDiasParaDevolver() + " dias para devolverlo, sino sera penalizado.");
						Prestamo p1 = new Prestamo(diaActual, PKarticulo, dni);
						listaPrestamos.add(p1);
						System.out.println("El/La " + tipoArticulo.getSimpleName().toLowerCase()
								+ " ha sido prestado correctamente.");
					} else {
						System.out.println(
								"Cancelando prestamo de " + tipoArticulo.getSimpleName().toLowerCase() + "...");
					}
				} else {
					System.out.println("El número introducido no es una opción válida.");
				}
			}
		}

		if (indiceMayor == -1) {
			System.out.println("Actualmente no hay " + tipoArticulo.getSimpleName().toLowerCase() + "s en el sistema.");
		}

	}

	protected static void devolverPrestamo(ArrayList<Prestamo> listaPrestamos, ArrayList<Articulo> listaArticulos,
			Usuario usu, Scanner sc) {
		int indiceMayor = -1, indiceMenor = 0;
		for (int i = 0; i < listaPrestamos.size(); i++) {
			Prestamo pres = listaPrestamos.get(i);
			if (pres.getDniUsuario().equals(usu.getDni())) {
				System.out.println("---------- Prestamo" + " " + i + "----------");
				System.out.println(pres.toString());
				indiceMayor = i;
				indiceMenor++;

				if (i == (listaPrestamos.size() - 1) && indiceMayor != -1) {
					System.out.print("Introduce el numero del prestamo que desea devolver: ");
					String opcionS = sc.next();
					sc.nextLine();
					int opcion = main.comprobarSiNumero(opcionS);
					if (opcion != -1 && opcion <= indiceMayor && opcion >= (indiceMayor - indiceMenor) + 1) {
						boolean respuestaBool = main.obtenerRespuestaSiNo(sc,
								"¿Está seguro que desea devolver " + pres.getPKarticulo() + "?");
						if (respuestaBool) {
							pres.setDevuelto(true);

							for (Articulo art : listaArticulos) {
								if (art.getNombre().equals(pres.getPKarticulo())) {
									art.disponible = true;
								}
							}

						} else {
							System.out.println("Cancelando...");
						}
					}

				}

			}
		}

	}

	protected static void consultarPrestamosALL(ArrayList<Prestamo> listaPrestamos) {
		for (Prestamo pres : listaPrestamos) {
			System.out.println(pres.toString());
		}

	}

	protected static void consultarPrestamosUsuario(ArrayList<Prestamo> listaPrestamos, Usuario usu) {
		for (Prestamo pres : listaPrestamos) {
			if (pres.getDniUsuario().equals(usu.getDni())) {
				System.out.println(pres.toString());
			}

		}

	}
	
	protected static void consultarPrestamosUsuarioActivos(ArrayList<Prestamo> listaPrestamos, Usuario usu) {
		for (Prestamo pres : listaPrestamos) {
			if (pres.getDniUsuario().equals(usu.getDni())) {
				if (!pres.isDevuelto()) {
					System.out.println(pres.toString());
				}
			}
		}
	}
	
	protected static void mostrarPrestamosMenu() {
	    System.out.println("╔═══════════════════════════╗");
	    System.out.println("║           Prestamos       ║");
	    System.out.println("╠═══════════════════════════╣");
	    System.out.println("║ 1. Activos                ║");
	    System.out.println("║ 2. Todos                  ║");
	    System.out.println("║ 3. Salir                  ║");
	    System.out.println("╚═══════════════════════════╝");
	}

	@Override
	public String toString() {
		return String.format(
				"Dia del prestamo: %d%n" + "DNI del usuario; %s%n" + "Articulo prestado: %s%n" + "Esta devuelo: %s%n",
				getDiaPrestamo(), getDniUsuario(), getPKarticulo(), isDevuelto() ? "Sí" : "No");

	}

}
