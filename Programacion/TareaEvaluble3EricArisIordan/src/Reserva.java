import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
	
	String nombreHabitacion, dniCliente;
	ArrayList<LocalDate> fechaReservada;
	
	
	public Reserva(String nombreHabitacion, String dniCliente, ArrayList<LocalDate> fechaReservada) {
		this.nombreHabitacion = nombreHabitacion;
		this.dniCliente = dniCliente;
		this.fechaReservada = fechaReservada;
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
	
	
	
	
	

}
