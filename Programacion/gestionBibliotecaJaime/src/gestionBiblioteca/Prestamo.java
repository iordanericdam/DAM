package gestionBiblioteca;

import java.util.Calendar;
import java.util.Date;


public class Prestamo {

	protected static int contadorId = 0;
	protected Integer idPrestamo;
	protected Articulo articulo;
	protected Cliente cliente;
	protected Date fechaInicio;
	protected Date fechaLimite;

	protected Prestamo(Articulo articulo, Cliente cliente) {
		this.articulo = articulo;
		this.cliente = cliente;
		this.idPrestamo = contadorId++;
		this.fechaInicio = new Date();
		this.fechaLimite = calcularFecha();

	}

	protected Articulo getArticulo() {
		return articulo;
	}

	protected void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	protected Cliente getCliente() {
		return cliente;
	}

	protected void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected Date getFechaLimite() {
		return fechaLimite;
	}

	protected void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	protected Integer getIdPrestamo() {
		return idPrestamo;
	}

	protected void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	protected Date calcularFecha() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaInicio);
		calendario.add(Calendar.WEEK_OF_YEAR, 2);
		return calendario.getTime();
		
	}

	@Override
	public String toString() {
		return idPrestamo+" "+""+articulo+cliente+ ", Fecha Inicio: " + fechaInicio + ", Fecha Limite: " + fechaLimite;
	}
	
}
