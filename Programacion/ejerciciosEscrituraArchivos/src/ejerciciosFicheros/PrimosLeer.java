package ejerciciosFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrimosLeer {
	
	protected static String leerArchivo(String nombreArchivo) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))){
			String linea;
			while((linea = reader.readLine()) != null) {
				sb.append(linea).append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}


}
