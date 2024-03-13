package alquilerVehiculos;



public abstract class Vehiculo {
	
		String matricula, marca, modelo, color;
		int km, precioDia = 50;

		public Vehiculo(String matricula, String marca, String modelo, String color, int km) {
			this.matricula = matricula;
			this.marca = marca;
			this.modelo = modelo;
			this.color = color;
			this.km = km;
		}
		
		

		public Vehiculo() {
			super();
		}





		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}


		public int getKm() {
			return km;
		}

		public void setKm(int km) {
			this.km = km;
		}

		@Override
		public String toString() {
			return "-----------------------------" +" \nMatrícula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo + "\nColor: " + color
					+ "\nKilometraje: " + km;
		}
		
		public abstract double calcularPrecio(int dias);




	}




