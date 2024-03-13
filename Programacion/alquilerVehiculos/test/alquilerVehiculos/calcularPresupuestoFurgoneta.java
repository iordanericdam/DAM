package alquilerVehiculos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calcularPresupuestoFurgoneta {

	@Test
	public void testCalcularPrecio() {
		//Plazas
        Vehiculo vehCoche = new Furgoneta(1);
        assertEquals(70, vehCoche.calcularPrecio(1));
        assertEquals(120, vehCoche.calcularPrecio(2));
        Vehiculo vehCoche2 = new Furgoneta(2);
        assertEquals(90, vehCoche2.calcularPrecio(1));
        assertEquals(140, vehCoche2.calcularPrecio(2));
        
    }

}
