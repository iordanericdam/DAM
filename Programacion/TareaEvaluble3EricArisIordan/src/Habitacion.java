import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Habitacion {
	
	int precioNoche;
	String categoria, nombreHabitacion;
	ArrayList<LocalDate> fechaReservada;
	
	
	public Habitacion(int precioNoche, int categoria, String nombreHabitacion, ArrayList<LocalDate> fechaReservada) {
		this.precioNoche = precioNoche;
		this.categoria = asignarCategoria(categoria);
		this.nombreHabitacion = nombreHabitacion;
		this.fechaReservada = fechaReservada;
	}
	
    public void agregarFechaReservada(LocalDate fecha) {
        fechaReservada.add(fecha);
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
    
    protected static void altaHabitacion(Scanner sc, ArrayList<Habitacion> listaHabitaciones){
    	int precioNoche;
    	int categoria;
		String nombreHabitacion;
    	
    	do {
    		System.out.print("Introduce el nombre de la habitacion: ");
    		nombreHabitacion = sc.nextLine();
    	} while (controlDatos.comprobarString(nombreHabitacion, 3));
    	do {
    		categoria = Menus.seleccionarCategoria(sc);
    	} while (categoria != 1 && categoria != 2 && categoria != 3 && categoria != 4);
    	if (categoria !=4) {
    		do {
    			System.out.print("");
    			
    		} while (true);
    	}
    }
    
    @Override
    public String toString() {
        return String.format(
                "Nombre habitacion: %d%n" + "Precio por noche: %d%n" + "Categoría: %s%n"+ "Fechas reservadas: %s%n",
                nombreHabitacion, precioNoche, categoria, fechaReservada.toString());
    }
	

}
