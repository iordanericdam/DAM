package alquilerVehiculos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calcularPresupuestoMicroBus {

	@Test
    public void testCalcularPrecio() {
		//Plazas
        Vehiculo vehCoche = new MicroBus(1);
        assertEquals(52, vehCoche.calcularPrecio(1));
        assertEquals(102, vehCoche.calcularPrecio(2));
        Vehiculo vehCoche2 = new MicroBus(2);
        assertEquals(54, vehCoche2.calcularPrecio(1));
        assertEquals(104, vehCoche2.calcularPrecio(2));
        
    }

}
