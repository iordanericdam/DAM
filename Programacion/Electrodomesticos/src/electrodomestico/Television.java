package electrodomestico;

public class Television extends Electrodomestico {

	double resolucion;
	boolean sintonizadorTDT;

	final double RESOLUCION = 20 ;
	final boolean SINTONIZADOR_TDT = false;

	public Television() {
		super();
	}

	public Television(double precio, double peso) {
		super();
		this.precioBase = precio;
		this.resolucion = RESOLUCION;
		this.sintonizadorTDT = SINTONIZADOR_TDT;
	}

	public Television(double precio, double peso, String color, char consumo, double resolucion,
			boolean sintonizadorTDT) {
		super(precio, peso, color, consumo);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
		this.precioBase = precio;
	}

	@Override
	protected double precioFinal() {
		double precioFinal = 0;
		
		if (resolucion > 40) {
			precioFinal += (precioBase * 30 ) / 100;
		}
			

		if (sintonizadorTDT) {
			precioFinal += 50;
		}

		return super.precioFinal() +precioFinal ;
	}


	@Override
	public String toString() {
	    return super.toString() + 
	           "   Resolucion: " + resolucion + "\n" +
	           "   SintonizadorTDT: " + sintonizadorTDT  + "\n---------------------------";
	}


}
