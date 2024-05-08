package ejerciciosFicheros;

public class Main {

	public static void main(String[] args) {
		
		final String archivo = "primos.txt";
		
		PrimosEscribir.borrarContenidoArchivo(archivo);
		PrimosEscribir.escribirNumerosPrimos(archivo, 500);
		System.out.println(PrimosLeer.leerArchivo(archivo));
		

	}

}
