package electrodomestico;

public final class Lavadora extends Electrodomestico{
	
	double carga;
	final double CARGA = 5;
	
	public Lavadora() {
		super();
	}
	
	public Lavadora(double precio, double peso) {
		super();
		this.precioBase = precio;
		this.carga = CARGA;
	}
	
	public Lavadora(double precio, double peso, String color, char consumo, double carga) {
		super(precio, peso, color, consumo);
		this.carga = carga;
		this.precioBase = precio;
	}
	
	public double getCarga() {
		return carga;
	}

	public double getCARGA() {
		return CARGA;
	}
	
	
	
	@Override
	protected double precioFinal() {
		double precioFinal = 0;
		
		
		
		if (carga >= 30) {
			precioFinal += 50;
			
		}
		
        return super.precioFinal() + precioFinal ;
    }

	

	@Override
	public String toString() {
	    return super.toString()  +
	           "   Carga: " + carga + " Kg\n"
	            + "\n---------------------------";
	}

	

	
	
	

}
