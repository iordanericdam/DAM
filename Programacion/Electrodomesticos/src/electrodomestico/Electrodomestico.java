package electrodomestico;

public  class Electrodomestico {

	final double PRECIO_BASE = 100;
	final double PESO = 5;
	final String COLOR = "blanco";
	final char CONSUMO_ENERGETICO = 'F';

	double precioBase, peso;
	String color;
	char consumoEnergetico;

	public Electrodomestico() {
		this.color = COLOR;
		this.precioBase = PRECIO_BASE;
		this.peso = PESO;
		this.consumoEnergetico = CONSUMO_ENERGETICO;
	}

	public Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = COLOR;
		this.consumoEnergetico = CONSUMO_ENERGETICO;
		this.precioBase = precioBase;
	}

	public Electrodomestico(double precioBase, double peso, String color, char consumoEnergetico) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.precioBase = precioBase;

	}

	public double getPRECIO_BASE() {
		return PRECIO_BASE;
	}

	public double getPESO() {
		return PESO;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public char getCONSUMO_ENERGETICO() {
		return CONSUMO_ENERGETICO;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public double getPeso() {
		return peso;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	private char comprobarConsumoEnergetico(char letra) {
		if (letra != 'A' && letra != 'B' && letra != 'C' && letra != 'D' && letra != 'E' && letra != 'F') {
			consumoEnergetico = CONSUMO_ENERGETICO;
		} else {
			consumoEnergetico = letra;
		}
		return consumoEnergetico;
	}

	private String comprobarColor(String color) {
		if (color != "negro" && color != "blanco" && color != "rojo" && color != "azul" && color != "gris") {
			color = COLOR;
		}

		return color;
	}

	protected double precioFinal() {
		double precioFinal = precioBase;

		switch (consumoEnergetico) {
		case 'A':
			precioFinal += 100;
			break;
		case 'B':
			precioFinal += 80;
			break;
		case 'C':
			precioFinal += 60;
			break;
		case 'D':
			precioFinal += 50;
			break;
		case 'E':
			precioFinal += 30;
			break;
		case 'F':
			precioFinal += 10;
			break;
		
		}
		
		if (peso > 0 && peso <= 19) {
			precioFinal += 10;
		} else if (peso >=20 && peso <= 49)  {
			precioFinal += 50;
		} else if (peso >=50 && peso <= 79)  {
			precioFinal += 80;
		} else if (peso >= 80)  {
			precioFinal += 100;
		} 
		

		return precioFinal;

	}

	@Override
	public String toString() {
		double precioFinal = precioFinal();
	    return 
	           "   Precio base: " + precioBase + " €\n" +
	           "   Peso: " + peso + " Kg \n" +
	           "   Color: " + color + "\n" +
	           "   Consumo Energetico: " + consumoEnergetico + "\n" + 
	           "   Precio Final: " + precioFinal + "\n";
	}





}
