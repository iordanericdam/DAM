package ejerciciosFicheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrimosEscribir {
	
	
	
	
	
	
    protected static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
	
	protected static void escribirNumerosPrimos(String nombreArchivo, int cantidad) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))){
			int numero = 2;
			int cantidadEncontrados = 0;
				while (cantidadEncontrados < cantidad) {
					if (esPrimo(numero)) {
						writer.write(Integer.toString(numero));
						writer.append(",");
						cantidadEncontrados++;
					}
					numero++;
				}

			 writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static void borrarContenidoArchivo(String nombreArchivo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))){
			writer.write("");
			 writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
