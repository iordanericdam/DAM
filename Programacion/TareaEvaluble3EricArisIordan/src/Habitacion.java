import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Habitacion {
	
	int precioNoche;
	static final int PRECIOMINIMONOCHE = 50;
	String categoria, nombreHabitacion;
	ArrayList<LocalDate> fechaReservada;
	
	
	public Habitacion(int precioNoche, int categoria, String nombreHabitacion, ArrayList<LocalDate> fechaReservada) {
		this.precioNoche = precioNoche;
		this.categoria = asignarCategoria(categoria);
		this.nombreHabitacion = nombreHabitacion;
		this.fechaReservada = fechaReservada;
	}
	
	public Habitacion(int precioNoche, int categoria, String nombreHabitacion) {
		this.precioNoche = precioNoche;
		this.categoria = asignarCategoria(categoria);
		this.nombreHabitacion = nombreHabitacion;
	}
	
    public String getNombreHabitacion() {
		return nombreHabitacion;
	}
    
	public int getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = asignarCategoria(categoria);
	}

	public ArrayList<LocalDate> getFechaReservada() {
		return fechaReservada;
	}

	public void setFechaReservada(ArrayList<LocalDate> fechaReservada) {
		this.fechaReservada = fechaReservada;
	}

	public static int getPreciominimonoche() {
		return PRECIOMINIMONOCHE;
	}

	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
	}
	
	protected boolean estaReservada(LocalDate fecha) {
	        if (fechaReservada != null) {
	            return fechaReservada.contains(fecha);
	        } else {
	            return false; 
	        }
	    }
    


    
    private String asignarCategoria(int categoria) {
    	if (categoria != 4) {
    		switch (categoria) {
        	case 1:
        		return "Individual";
			case 2:
        		return "Doble";
			case 3:
        		return "Familiar";	
        	
        	}
    	}
    	
		return null;
    	
    }
    

    
    @Override
    public String toString() {
        String fechaReservadaString = fechaReservada != null ? fechaReservada.toString() : "Todavía no hay reservas";
        return String.format(
                "Nombre habitacion: %s%n" + "Precio por noche: %d%n" + "Categoría: %s%n"+ "Fechas reservadas: %s%n",
                nombreHabitacion, precioNoche, categoria, fechaReservadaString);
    }
	

}
