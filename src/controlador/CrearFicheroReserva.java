package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearFicheroReserva {
	
	public static void sortuFitxeroa() {
		String numeroReserva = "";
		File carpeta = new File("C:/Users/mañana/git/aaaaa/ficherosReserva");
		String[] listado = carpeta.list();
		if (listado == null || listado.length == 0) {
			File fichero = new File("C:/Users/mañana/git/aaaaa/ficherosReserva//reserva0001.txt");
			rellenarFichero(numeroReserva);
			try {
				if (fichero.createNewFile())
					System.out.println("El fichero se ha creado correctamente");
				else
					System.out.println("No ha podido ser creado el fichero");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return;
		} else {
			for (int i = 0; i < listado.length; i++) {
				numeroReserva = listado[i];
			}

			numeroReserva = numeroReserva.substring(7, 11);
			int numeroEntero = Integer.parseInt(numeroReserva);
			numeroEntero = numeroEntero + 1;
			numeroReserva = String.format("%04d", numeroEntero);
			File fichero = new File(
					"C:/Users/mañana/git/aaaaa/ficherosReserva//reserva" + numeroReserva + ".txt");
			rellenarFichero(numeroReserva);
			try {

				if (fichero.createNewFile())
					System.out.println("El fichero se ha creado correctamente");
				else
					System.out.println("No ha podido ser creado el fichero");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return;
		}
	}

	private static void rellenarFichero(String numeroReserva) {
		   FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("C:/Users/mañana/git/aaaaa/ficherosReserva//reserva" + numeroReserva + ".txt");
	            pw = new PrintWriter(fichero);

	           pw.print("             BIDAION             /n"
	           		+ "------------------------------------- /n"
	           		+ "Hotel:                             x /n"
	           		+ "Nº habitaciones:                   x /n"
	           		+ "Entrada                            x /n"
	           		+ "Amaiera                            x /n"
	           		+ "------------------------------------- /n"
	           		+ "Izena                              x /n"
	           		+ "Abizena                            x /n"
	           		+ "NAN                                x /n"
	           		+ "-------------------------------------"
	           		+ "Prezioa + ordaindu                 x /n");

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
