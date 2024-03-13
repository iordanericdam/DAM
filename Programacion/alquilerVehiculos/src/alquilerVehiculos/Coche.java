package alquilerVehiculos;

	public class Coche extends Vehiculo{
		
		int numPlazas;
		final double precioPlaza = 1.5;
	
		public Coche(String matricula, String marca, String modelo, String color, int km) {
			super(matricula, marca, modelo, color, km);
			
		}
		
		
		public Coche(String matricula, String marca, String modelo, String color, int km, int numPlazas) {
			super(matricula, marca, modelo, color, km);
			this.numPlazas = numPlazas;
		}
		
		
		
		public Coche(int numPlazas) {
			this.numPlazas = numPlazas;
		}


		public int getNumPlazas() {
			return numPlazas;
		}


		public void setNumPlazas(int numPlazas) {
			this.numPlazas = numPlazas;
		}


		@Override
		public  String toString() {
			return super.toString() + "\nNumero de plazas: "+ numPlazas;
		}


		@Override
		public double calcularPrecio(int dias) {
			return (double) (precioDia * dias + (numPlazas * precioPlaza) * dias);
			
		}
		

		
	}