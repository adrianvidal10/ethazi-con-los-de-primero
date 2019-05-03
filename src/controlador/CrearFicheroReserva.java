package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearFicheroReserva {
	
	public static void sortuFitxeroa() throws IOException {
		String numeroReserva = "0001";
		File carpeta = new File("C:\\Users\\mañana.ORD30\\git\\ethazi-con-los-de-primero\\ficherosReserva");
		String[] listado = carpeta.list();
		if (listado == null || listado.length == 0) {
			FileWriter fichero = new FileWriter("C:\\Users\\mañana.ORD30\\git\\ethazi-con-los-de-primero\\ficherosReserva\\reserva0001.txt");
			rellenarFichero(numeroReserva, fichero);
			return;
		} else {
			for (int i = 0; i < listado.length; i++) {
				numeroReserva = listado[i];
			}

			numeroReserva = numeroReserva.substring(7, 11);
			int numeroEntero = Integer.parseInt(numeroReserva);
			numeroEntero = numeroEntero + 1;
			numeroReserva = String.format("%04d", numeroEntero);
			FileWriter fichero = new FileWriter(
					"C:\\Users\\mañana.ORD30\\git\\ethazi-con-los-de-primero\\ficherosReserva\\reserva" + numeroReserva + ".txt");
			rellenarFichero(numeroReserva, fichero);
			return;
		}
	}

	private static void rellenarFichero(String numeroReserva, FileWriter fichero) {
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("C:\\Users\\mañana.ORD30\\git\\ethazi-con-los-de-primero\\ficherosReserva\\reserva" + numeroReserva + ".txt");
	            pw = new PrintWriter(fichero);

	           pw.print("----------"
	        		+ "    BIDAION     "
	           		+ "---------- \r\n"
	           		+ "Hotel:                             x \r\n"
	           		+ "Nº habitaciones:                   x \r\n"
	           		+ "Entrada                            x \r\n"
	           		+ "Amaiera                            x \r\n"
	           		+ "------------------------------------- \r\n"
	           		+ "Izena                              x \r\n"
	           		+ "Abizena                            x \r\n"
	           		+ "NAN                                x \r\n"
	           		+ "------------------------------------- \r\n"
	           		+ "Prezioa                            x \r\n"
	           		+ "Ordainketa                         x \r\n");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
}
