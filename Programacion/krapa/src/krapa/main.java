package krapa;

import java.util.Objects;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		int opcion = 78, usuarios = 0, opcionUsuarios = 78;
		String opcionS, usuariosS, opcionUsuariosS, nombre;
		boolean usuariosC = false;
		Scanner sc = new Scanner(System.in);
		String[] usuariosArray = new String[100];

		System.out.println("Bienvenido a krapa una app de gestion de gastos");
		do {
			System.out.println("Cuantos usuarios desea introducir de momento? ");
			usuariosS = sc.next();

			try {
				usuarios = Integer.parseInt(usuariosS);
				usuariosC = true;
			} catch (Exception e) {
				System.out.println("Primero debes introducir el numero de usuarios, utilizando numeros del 0 al 9");
			}
		} while (!usuariosC);


		for (int i = 0; i < usuarios; i++) {
			System.out.println("Introduce el nombre del " + (i + 1) + " usuario");
			nombre = sc.next().toLowerCase();
			usuariosArray[i] = nombre;
		}

		System.out.print("Ya tenemos los usuarios, que deseas hacer?, eligue una opcion escribiendo el numero");

		do {
			System.out.println("Menu de opciones: ");
			System.out.println("1- Agregar gasto");
			System.out.println("2- Eliminar gasto");
			System.out.println("3- ¿Quien debe a quien?");
			System.out.println("4- Gestion usuarios");
			System.out.println("5- Salir");

			opcionS = sc.next();
			try {
				opcion = Integer.parseInt(opcionS);
				switch (opcion) {
				case 1:
					System.out.println("Esta es la opcion 1");

					break;
				case 2:
					System.out.println("Esta es la opcion 2");

					break;
				case 3:
					System.out.println("Esta es la opcion 3");

					break;

				case 4:
					do {
						opcionUsuarios = 0;
						System.out.println("Gestion de usuarios: ");
						System.out.println("1- Agregar otro usuario");
						System.out.println("2- Modificar usuario");
						System.out.println("3- Eliminar usuario");
						System.out.println("4- Salir");

						opcionUsuariosS = sc.next();
						try {
							opcionUsuarios = Integer.parseInt(opcionUsuariosS);
							switch (opcionUsuarios) {
							case 1:
								System.out.println("Introduce el nombre del usuario que desea añadir: ");
								nombre = sc.next();
								
								for (int i = 0;i<usuariosArray.length;i++) {
									if (Objects.equals(usuariosArray[i], nombre)){
										System.out.print("primer iF");
										if (usuariosArray[i] == null){
											
											usuariosArray[i] = nombre;
											System.out.print("SEGUNDO iF");
											i = usuariosArray.length;
										}
										
										
									} else {
										System.out.println("EL nombre ya esta en la lista");
									}
									
								}
								
								break;
							case 2:
								System.out.println("Esta es la opcion 2");

								break;
							case 3:
								System.out.println("Esta es la opcion 3");

								break;
							case 5:
								for (int i=0;i<usuariosArray.length;i++) {
									System.out.println(usuariosArray[i]);
								}

								break;
							case 4:
								System.out.println("Volvemos al menu principal");

								break;
							default:
								System.out.println("Opcion no valida, por favor introduzca un numero del 1 al 4");

								break;
							}
						} catch (Exception e) {
							System.out.println("Debes eleguir una opcion de la 0 a la 4, introduce solo el numero");
						}

					} while (opcionUsuarios != 4);

					break;
				case 5:
					System.out.println("Salimos, nos vemos pronto...");
					break;
				default:
					System.out.println("Opcion no valida, por favor introduzca un numero del 1 al 5");
					break;

				}
			} catch (Exception e) {
				System.out.println("Debes eleguir una opcion de la 0 a la X, introduce solo el numero");
			}

		} while (opcion != 5);

	}

}
