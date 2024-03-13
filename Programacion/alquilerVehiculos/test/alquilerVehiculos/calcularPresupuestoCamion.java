package alquilerVehiculos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calcularPresupuestoCamion {

	@Test
    public void testCalcularPrecio() {
        Vehiculo vehCamion = new Camion(500);
        assertEquals(10090, vehCamion.calcularPrecio(1));
        assertEquals(10140, vehCamion.calcularPrecio(2));
        
        vehCamion = new Camion(250);
        assertEquals(5090, vehCamion.calcularPrecio(1));
        assertEquals(5140, vehCamion.calcularPrecio(2));
        

    }

}
