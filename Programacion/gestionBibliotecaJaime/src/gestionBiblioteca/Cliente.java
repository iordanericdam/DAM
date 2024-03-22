package gestionBiblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Cliente extends Usuario {
	
	protected static int contadorId=0;
	protected String nombre,apellidos;
	protected Integer idCliente,numPrestamos;
	protected Boolean penalizado;
	
	
	protected Cliente(String nombreUsuario, String contraseña, String nombre, String apellidos) {
		super(nombreUsuario, contraseña);
		this.idCliente=contadorId++;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.numPrestamos=0;
		this.penalizado=false;
		
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
	
	protected Integer getIdCliente() {
		return idCliente;
	}
	
	protected Boolean getPenalizado() {
		return penalizado;
	}

	protected void setPenalizado(Boolean penalizado) {
		this.penalizado = penalizado;
	}

	
	
	protected void realizarPrestamo(ArrayList<Articulo>articulos,ArrayList<Prestamo>prestamos,Scanner sc) {
		
		
		for(Articulo articulo : articulos) {
			System.out.println(articulo.toString());
		}
		System.out.println("ID Articulo: ");
		int idArticulo=sc.nextInt();
		if(this.getPenalizado().FALSE) {
			for(Articulo articulo : articulos) {
				
				if(articulo.getId().equals(idArticulo)) {
					
					if(articulo.isDisponible()) {
						articulo.setDisponible(false);
						Prestamo prestamo = new Prestamo(articulo,this);
						prestamos.add(prestamo);
						numPrestamos++;
						System.out.println("El artículo "+articulo.getTitulo()+", lo tiene disponible hasta el día: "+prestamo.getFechaLimite());
					}
				}			
			}System.out.println("El artículo no se encuentra disponible.");
			
		}else {
			System.out.println("El cliente se encuentra penalizado.");
		}
	}
	
	
	
	
	
	protected void devolucionArticulo(ArrayList<Articulo>articulos,ArrayList<Prestamo>prestamos,Scanner sc) {
		for(Prestamo prestamo : prestamos) {
			System.out.println(prestamo.toString());
		}
		System.out.println("ID Prestamo: ");
		int idPrestamo=sc.nextInt();
		Iterator<Prestamo> iterador = prestamos.iterator();
		while(iterador.hasNext()) {
			Prestamo prestamo = iterador.next();
			if (prestamo.getIdPrestamo().equals(idPrestamo)) {
				Articulo articulo = prestamo.getArticulo();
				Cliente cliente = prestamo.getCliente();
				articulo.setDisponible(true);
				cliente.setPenalizado(false);
				iterador.remove();
				System.out.println("El artículo del préstamo: "+prestamo.getIdPrestamo()+" ha sido devuelto correctamente, gracias.");
			}
		}
	
	}

	@Override
	public String toString() {
		return "Cliente Nombre: " + nombre + ", Apellidos: " + apellidos + ", id Cliente: " + idCliente + ", Prestamos:"
				+ numPrestamos + ", penalizado:" + penalizado + "]";
	}

	
	
	
	
	
	

	
}








