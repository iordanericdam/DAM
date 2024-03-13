package alquilerVehiculos;

public class MicroBus extends Vehiculo{
	
	int numPlazas;
	final double precioPlaza = 2;

	public MicroBus(String matricula, String marca, String modelo, String color, int km) {
		super(matricula, marca, modelo, color, km);
	}
	
	
	
	public MicroBus(String matricula, String marca, String modelo, String color, int km, int numPlazas) {
		super(matricula, marca, modelo, color, km);
		this.numPlazas = numPlazas;
	}
	
	public MicroBus(int numPlazas) {
		this.numPlazas = numPlazas;
	}



	public int getNumPlazas() {
		return numPlazas;
	}



	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}



	public  String toString() {
		return super.toString() + "\nNumero de plazas: "+ numPlazas;
	}



	@Override
	public double calcularPrecio(int dias) {
		return (double) (precioDia * dias + (numPlazas * precioPlaza));
	}

}
