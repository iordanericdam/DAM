package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	protected String usuario,contraseña;
	protected boolean salir=false;
	protected int opcion=0;

	
	public void mostrarLogin(){
		
		 System.out.println("=====================================");
	     System.out.println("|        Bienvenido a la gestión    |");
	     System.out.println("|             de biblioteca         |");
	     System.out.println("=====================================");	
	}
	
	
	public void menuUsuario(){
			
       System.out.println("\n=========== Menú Usuario ===========");
       System.out.println("|  1. Hacer préstamo                 |");
       System.out.println("|  2. Hacer devolución               |");
       System.out.println("|  3. Ver préstamos activos          |");
       System.out.println("|  4. Login                          |");
       System.out.println("|  0. Salir                          |");
       System.out.println("=====================================");
       System.out.print("Seleccione una opción: ");			
	}
	
	
	public void menuAdmin(){
		
		System.out.println("\n======= Menú Administrador ======");
       System.out.println("|  1. Dar de alta usuario          |");
       System.out.println("|  2. Penalizar usuario            |");
       System.out.println("|  3. Añadir artículo              |");
       System.out.println("|  4. Eliminar artículo            |");
       System.out.println("|  5. Ver Préstamos                |");
       System.out.println("|  6. Login                        |");
       System.out.println("|  0. Salir                        |");
       System.out.println("===================================");
       System.out.print("Seleccione una opción: ");		
	}
	
	
	protected void iniciarSesion(Scanner sc,ArrayList<Prestamo> prestamos,ArrayList<Usuario> usuarios,ArrayList<Articulo> articulos) {
		String nombre,apellido,nombreUsuario,passwd;
		do {
			Usuario usuarioCorrecto=null;
			mostrarLogin();
			System.out.println("Usuario: ");
			usuario = sc.nextLine();
			System.out.println("Contraseña: ");
			contraseña = sc.nextLine();
			
			
			for(Usuario user : usuarios) {
				
				if(user.getNombreUsuario().equals(usuario)&&user.getContraseña().equals(contraseña)) {
					usuarioCorrecto=user;
					
					break;
				} 
			}			
	
			if (usuarioCorrecto!=null) {
				
				if (usuarioCorrecto instanceof Administrador) {
					Administrador admin = (Administrador) usuarioCorrecto;
				    System.out.print("Bienvenido Administrador: "+usuarioCorrecto.getNombreUsuario());		
				
					do {
						menuAdmin();
						opcion=sc.nextInt();
						switch(opcion) {
						
							case 0:
								salir=true;
								break;
							case 1: // dar alta usuario
								
								boolean administrador=false;
								System.out.println("¿Desea añadir un admnistrador o un cliente?: ");
								String opcionUser=sc.next().toLowerCase();
								System.out.println("Nombre: ");
								nombre = sc.next();
								System.out.println("Apellidos: ");
								apellido = sc.next();
								System.out.println("Username: ");
								nombreUsuario = sc.next();
								System.out.println("Contraseña: ");
								passwd = sc.next();
								if (opcionUser.equals("administrador"))administrador=true;
								admin.añadirUsuario(administrador,nombre,apellido,nombreUsuario,passwd,usuarios);
								break;
								
							case 2: // penalizar usuario
								
								admin.penalizacion(usuarios, sc);
								
								break;
								
							case 3: // Añadir articulo							
								admin.añadirArticulo(articulos, sc);							
								break;
								
							case 4:
								admin.eliminarArticulo(articulos, sc);
								break;
								
							case 5:
								for (Prestamo prestamo:prestamos) {
									System.out.println(prestamo.toString());
								}
								break;
								
							case 6:
								sc.nextLine();
								iniciarSesion(sc, prestamos, usuarios, articulos);
								break;
							default:
								System.out.println("Opción no válida");
								break;
						
						}
					
					}while(!salir);
					
				} else if (usuarioCorrecto instanceof Cliente) {
					Cliente user = (Cliente)usuarioCorrecto;
					System.out.print("Bienvenido Cliente: "+usuarioCorrecto.getNombreUsuario());		
					menuUsuario();
					opcion=sc.nextInt();
					do {
						menuUsuario();
						opcion=sc.nextInt();
						switch(opcion) {
							
							case 0:
								salir=true;
								break;
							case 1:
								user.realizarPrestamo(articulos, prestamos,sc);
								
								break;
							case 2:
								user.devolucionArticulo(articulos, prestamos, sc);
								break;
							case 3:
								for (Prestamo prestamo : prestamos) {
									if (prestamo.getCliente().equals(user)) {
										System.out.println(prestamo.toString());
									}
								}	
								break;
							case 4:
								iniciarSesion(sc, prestamos, usuarios, articulos);
								break;
							default:
								System.out.println("Opción no válida");
								break;
							
							}
					}while(!salir);
				}	
			}		
			System.out.println("1. Login."); 
			System.out.println("2. Salir."); 
			int optionFinal=sc.nextInt();
			if(optionFinal==2)salir=true;			
		}while (!salir);
	
	}

}
