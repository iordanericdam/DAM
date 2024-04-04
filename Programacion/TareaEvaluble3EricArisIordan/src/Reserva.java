import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
	
	String nombreHabitacion, dniCliente;
	ArrayList<LocalDate> fechaReservada;
	int costeReserva;
	static final int MAX_DIAS_RESERVA = 60;
	
	
	public Reserva(String nombreHabitacion, String dniCliente, ArrayList<LocalDate> fechaReservada, int costeReserva) {
		this.nombreHabitacion = nombreHabitacion;
		this.dniCliente = dniCliente;
		this.fechaReservada = fechaReservada;
		this.costeReserva = costeReserva;
	}


	public String getNombreHabitacion() {
		return nombreHabitacion;
	}


	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
	}


	public String getDniCliente() {
		return dniCliente;
	}


	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}


	public ArrayList<LocalDate> getFechaReservada() {
		return fechaReservada;
	}


	public void agregarFechaReservada(LocalDate fecha) {
        fechaReservada.add(fecha);
    }


	@Override
	public String toString() {
		return String.format("DNI del cliente: %s%n"+"Nombre habitacion: %s%n"+ "Fechas reservadas: %s%n" + "Coste reserva: %d%n", dniCliente, nombreHabitacion, fechaReservada, costeReserva);
	}
	
	
	
	
	
	
	

}
