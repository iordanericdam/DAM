import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Habitacion {
	
	int precioNoche;
	static final int PRECIOMINIMONOCHE = 50;
	String categoria, nombreHabitacion;
	
	
	public Habitacion(int precioNoche, int categoria, String nombreHabitacion) {
		this.precioNoche = precioNoche;
		this.categoria = asignarCategoria(categoria);
		this.nombreHabitacion = nombreHabitacion;
	}
	
	public Habitacion() {
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


	public static int getPreciominimonoche() {
		return PRECIOMINIMONOCHE;
	}

	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
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
        return String.format(
                "Nombre habitacion: %s%n" + "Precio por noche: %d%n" + "Categoría: %s%n",
                nombreHabitacion, precioNoche, categoria);
    }
	

}
