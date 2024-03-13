package alquilerVehiculos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class calcularPresupuestoCoche {
	
    @Test
    public void testCalcularPrecio() {

        Vehiculo vehCoche = new Coche(1);
        assertEquals(51.5, vehCoche.calcularPrecio(1));
        assertEquals(103, vehCoche.calcularPrecio(2));
        Vehiculo vehCoche2 = new Coche(2);
        assertEquals(53, vehCoche2.calcularPrecio(1));
        assertEquals(106, vehCoche2.calcularPrecio(2));
        
    }
}
