package alquilerVehiculos;

public class Furgoneta extends Vehiculo{
	int PMA, precioFijoPMA = 20;

	public Furgoneta(String matricula, String marca, String modelo, String color, int km, int pMA) {
		super(matricula, marca, modelo, color, km);
		PMA = pMA;
	}

	public Furgoneta(String matricula, String marca, String modelo, String color, int km) {
		super(matricula, marca, modelo, color, km);
	}
	
	public Furgoneta(int pMA) {
		PMA = pMA;
	}


	public int getPMA() {
		return PMA;
	}

	public void setPMA(int pMA) {
		PMA = pMA;
	}
	
	public  String toString() {
		return super.toString() + "\nPMA (Peso maximo autorizado): "+ PMA;
	}

	@Override
	public double calcularPrecio(int dias) {
		return (double) (precioDia * dias + (PMA * precioFijoPMA));
	}

	
	

}
