package ejerciciosEscrituraArchivosTeoria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		escribirArchivo("archivo.txt", "Esto es una prueba1");
		escribirArchivo("archivo.txt", "Esto es una prueba2");
		System.out.println(leerArchivo("archivo.txt"));
		borrarContenidoArchivo("archivo.txt");
		System.out.println("Contenido despues de borrar: ");
		System.out.println(leerArchivo("archivo.txt"));
	}
	
	
	protected static void escribirArchivo(String nombreArchivo, String contenido) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))){
			writer.write(contenido);
			 writer.newLine();
			System.out.println("Se ha escrito correctamente");
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
