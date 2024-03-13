package alquilerVehiculos;

public class Camion extends Vehiculo{
	int PMA, precioFijoPMA = 20, precioFijoCamion;
	

	public Camion(String matricula, String marca, String modelo, String color, int km, int pMA) {
		super(matricula, marca, modelo, color, km);
		PMA = pMA;
	}
	


	public Camion(int pMA) {
		PMA = pMA;
	}






	@Override
	public String toString() {
		return super.toString() + "\nPMA (Peso maximo autorizado): "+ PMA;
	}

	@Override
	public double calcularPrecio(int dias) {
		return (double) (precioDia * dias + (20*PMA)+40);
	}
	
	

}
