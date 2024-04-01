package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Administrador extends Usuario {

	protected static int contadorId = 0;
	protected String nombre, apellidos;
	protected Integer idAdministrador, infraccionesGeneradas;

	protected Administrador(String nombreUsuario, String contraseña, String nombre, String apellidos) {
		super(nombreUsuario, contraseña);
		this.idAdministrador = contadorId++;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.infraccionesGeneradas = 0;
	}

	protected Administrador(String nombreUsuario, String contraseña) {
		super(nombreUsuario, contraseña);
		this.idAdministrador = contadorId++;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected void añadirUsuario(boolean administrador, String nombre, String apellidos, String nombreUsuario,
			String contraseña, ArrayList<Usuario> usuarios) {

		Usuario user;
		if (administrador) {
			user = new Administrador(nombreUsuario, contraseña, nombre, apellidos);
			usuarios.add(user);
			System.out.println("Administrador añadido con éxito.");

		} else {
			user = new Cliente(nombreUsuario, contraseña, nombre, apellidos);
			usuarios.add(user);
			System.out.println("Cliente añadido con éxito.");
		}

	}

	protected void añadirArticulo(ArrayList<Articulo> articulos, Scanner sc) {
		String titulo, estado, autor, editorial, isbn, genero, opcionArticulo;
		int año, numRevista;
		boolean salir = false;

		System.out.println("Qué desea añadir (Libro/Pelicula/Revista): ");
		opcionArticulo = sc.next().toLowerCase();
		switch (opcionArticulo) {
		case "libro":
			System.out.println("Título: ");
			titulo = sc.next();
			System.out.println("Estado: ");
			estado = sc.next();
			System.out.println("Autor: ");
			autor = sc.next();
			System.out.println("Editorial: ");
			editorial = sc.nextLine();
			System.out.println("ISBN: ");
			isbn = sc.next();

			Libro libro = new Libro(titulo, estado, autor, editorial, isbn);
			articulos.add(libro);
			break;

		case "pelicula":
			System.out.println("Título: ");
			titulo = sc.next();
			System.out.println("Estado: ");
			estado = sc.next();
			System.out.println("Género: ");
			genero = sc.next();
			System.out.println("Año: ");
			año = sc.nextInt();

			Pelicula pelicula = new Pelicula(titulo, estado, genero, año);
			articulos.add(pelicula);
			break;

		case "revista":
			System.out.println("Título: ");
			titulo = sc.next();
			System.out.println("Estado: ");
			estado = sc.next();
			System.out.println("Género: ");
			genero = sc.next();
			System.out.println("Año: ");
			numRevista = sc.nextInt();

			Revista revista = new Revista(titulo, estado, genero, numRevista);
			articulos.add(revista);
			break;
			
		default:
			System.out.println("Error, inténtelo de nuevo, por favor.");
			break;

		}

	}

	protected void penalizacion(ArrayList<Usuario> usuarios, Scanner sc) {
		for (Usuario usuario : usuarios) {
			if (usuario instanceof Cliente) {
				System.out.println(usuario.toString());
			}
		}

		System.out.println("Dime el id, del cliente que deseas penalizar: ");
		int idCliente = sc.nextInt();
		for (Usuario usuario : usuarios) {
			Cliente usuarioElegido = (Cliente) usuario;
			if (usuarioElegido.getIdCliente().equals(idCliente)) {
				usuarioElegido.setPenalizado(true);
				this.infraccionesGeneradas++;
				System.out.println("Cliente con id: " + idCliente + " ha sido penalizado.");

			}
		}
		System.out.println("No se encontró ningún cliente con ID " + idCliente);
	}

	protected void eliminarArticulo(ArrayList<Articulo> articulos, Scanner sc) {
		int idArticulo;
		for (Articulo articulo : articulos) {
			System.out.println(articulo.toString());
		}
		idArticulo = sc.nextInt();
		Iterator<Articulo> iterador = articulos.iterator();
		while (iterador.hasNext()) {
			Articulo articulo = iterador.next();
			if (articulo.getId().equals(idArticulo)) {
				iterador.remove();
				System.out.println("El artículo con ID: " + idArticulo + ", ha sido eliminado correctamente.");
			}
		}

	}
}
