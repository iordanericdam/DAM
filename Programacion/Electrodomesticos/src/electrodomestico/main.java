package electrodomestico;

import java.util.ArrayList;




public class main {

	public static void main(String[] args) {
		metodoEjecutable();


	}
	
	protected static void metodoEjecutable() {
		ArrayList<Electrodomestico> listaElectrodomesticos = new ArrayList<>();
		
		Lavadora lavadora = new Lavadora(200, 10, "verde", 'A', 10);
		listaElectrodomesticos.add(lavadora);
		Lavadora lavadora2 = new Lavadora(200, 20, "aa", 'B', 50);
		listaElectrodomesticos.add(lavadora2);
		Lavadora lavadora3 = new Lavadora(200, 60, "verde", 'C', 10);
		listaElectrodomesticos.add(lavadora3);
		Lavadora lavadora4 = new Lavadora(200, 85, "aa", 'D', 50);
		listaElectrodomesticos.add(lavadora4);
		
		System.out.println("Lavadoras: ");
		System.out.println("---------------------------");
		for (Electrodomestico elec : listaElectrodomesticos) {
			if (elec instanceof Lavadora) {
				System.out.println((Lavadora) elec);
				
			}
		}
		
		Television tele = new Television(300, 15, "verde", 'E', 42, true);
		listaElectrodomesticos.add(tele);
		Television tele2 = new Television(300, 20, "azul", 'Ñ', 30, false);
		listaElectrodomesticos.add(tele2);
		Television tele3 = new Television(300, 45, "griz", 'A', 45, true);
		listaElectrodomesticos.add(tele3);
		Television tele4 = new Television(300, 60, "morado", 'B', 65, false);
		listaElectrodomesticos.add(tele4);
		
		System.out.println("Televisiones: ");
		System.out.println("---------------------------");
		for (Electrodomestico elec : listaElectrodomesticos) {
			if (elec instanceof Television) {
				System.out.println((Television) elec);
				
			}
		}
		
		double precioTelevisiones = calcularPrecioTelevisiones(listaElectrodomesticos, tele);
		double precioLavadoras = calcularPrecioLavadoras(listaElectrodomesticos, lavadora);
		System.out.println("┌─────────────────────────────────┐");
        System.out.println("│    Precios Totales              │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println("  Precio de Televisores: " + precioTelevisiones + "€");
        System.out.println("  Precio de Lavadoras  : " + precioLavadoras+ "€");
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│  Precio Total         : " + (precioTelevisiones + precioLavadoras+ "€") + " │");
        System.out.println("└─────────────────────────────────┘");
		
	}
	
	private static double calcularPrecioTelevisiones(ArrayList<Electrodomestico> listaElectromodesmticos, Television tele) {
		double precioCategoria = 0 ;
		for (Electrodomestico elec : listaElectromodesmticos) {
			if (elec instanceof Television) {
				precioCategoria += elec.precioFinal();
			}
			
		}
		return precioCategoria;
	}
	
	private static double calcularPrecioLavadoras(ArrayList<Electrodomestico> listaElectromodesmticos, Lavadora lavadora) {
		double precioCategoria = 0 ;
		for (Electrodomestico elec : listaElectromodesmticos) {
			if (elec instanceof Lavadora) {
				precioCategoria += elec.precioFinal();
			}
			
		}
		return precioCategoria;
	}

}
