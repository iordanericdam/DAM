package gestionBiblioteca;

import java.util.Date;

public abstract class Articulo {
	
	protected static int contadorId=0;
	protected Integer id;
	protected String titulo,estado;
	protected final boolean DISPONIBLE=true;
	protected boolean disponible;
	protected Date fechaEntrada;
	
	
	protected Articulo() {
		this.disponible=DISPONIBLE;
		this.fechaEntrada=new Date();
		this.id=contadorId++;
	}
	
	protected Articulo(String titulo, String estado) {
		
		this.titulo = titulo;
		this.estado = estado;
		this.disponible = DISPONIBLE;
		this.fechaEntrada = new Date();
		this.id=contadorId++;

	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	protected Integer getId() {
		return id;
	}

	protected boolean isDisponible() {
		return disponible;
	}

	protected void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Articulo Id Artículo" + id + ", titulo: " + titulo + ", estado: " + estado + ", disponible: " + disponible;
	}
	

}
