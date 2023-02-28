package logica.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import logica.objects.Cliente;
import logica.objects.Premio;
import logica.objects.Ticket;

public abstract class FileUtil {

	public static void loadFileCliente(String nombreFicheroEntrada, List<Cliente> listaCatalogo) {

		String linea;
		String[] datosArticulo = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosArticulo = linea.split("@");
				listaCatalogo.add(new Cliente(datosArticulo[0], datosArticulo[1], datosArticulo[2],
						Float.parseFloat(datosArticulo[3])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public static void loadFilePremio(String nombreFicheroEntrada, List<Premio> listaCatalogo) {

		String linea;
		String[] datosArticulo = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosArticulo = linea.split("@");
				listaCatalogo.add(new Premio(datosArticulo[0], datosArticulo[1], datosArticulo[2]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");

		}
	}

	public static void loadFileTicket(String nombreFicheroEntrada, List<Ticket> listaCatalogo) {

		String linea;
		String[] datosArticulo = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosArticulo = linea.split("@");
				listaCatalogo.add(new Ticket(datosArticulo[0], Float.parseFloat(datosArticulo[1])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	public static void saveToFile(String nombreFicheroSalida, List<Cliente> clientes ){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFicheroSalida));
		        for(Cliente c : clientes){
		        String linea = c.serialize();
		        fichero.write(linea);
		        fichero.write("\n");
		        }
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	  }

}
