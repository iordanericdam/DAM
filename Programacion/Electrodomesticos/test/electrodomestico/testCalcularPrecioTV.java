package electrodomestico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testCalcularPrecioTV {

	@Test
	public void testPrecioFinal() {
        Television tele = new Television(150, 50, "blanco",'C', 41, false);
        assertEquals(377, tele.precioBase);
        Television tele2 = new Television(150, 50, "blanco",'C', 39, false);
        assertEquals(290, tele2.precioBase);
        
        Television tele3 = new Television(390, 44, "blanco",'C', 20, false);
        assertEquals(500, tele3.precioBase);
        Television tele4 = new Television(390, 44, "blanco",'C', 20, true);
        assertEquals(550, tele4.precioBase);
	}

}
