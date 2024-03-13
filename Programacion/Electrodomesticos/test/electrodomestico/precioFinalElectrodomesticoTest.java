package electrodomestico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class precioFinalElectrodomesticoTest {

	@Test
	public void testPrecioFinal() {
        Electrodomestico elec = new Electrodomestico(100, 70, "blanco",'A');
        assertEquals(280, elec.precioBase);
        Electrodomestico elec1 = new Electrodomestico(120, 22, "blanco",'B');
        assertEquals(250, elec1.precioBase);
        Electrodomestico elec2 = new Electrodomestico(150, 50, "blanco",'C');
        assertEquals(290, elec2.precioBase);
        Electrodomestico elec3 = new Electrodomestico(300, 89, "blanco",'D');
        assertEquals(450, elec3.precioBase);
        Electrodomestico elec4 = new Electrodomestico(450, 10, "blanco",'E');
        assertEquals(490, elec4.precioBase);
        Electrodomestico elec5 = new Electrodomestico(490, 80, "blanco",'F');
        assertEquals(600, elec5.precioBase);
        

    }

}
