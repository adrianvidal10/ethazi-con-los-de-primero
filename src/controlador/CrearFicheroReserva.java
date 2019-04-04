package controlador;

import java.io.File;
import java.io.IOException;

public class CrearFicheroReserva {
	
	public static void main(String[] args) {
		String numeroReserva = "";
		File carpeta = new File("c:/Users/mañana.ORD30/git/repository/OstatuG5/ficherosReserva");
		String[] listado = carpeta.list();
		if (listado == null || listado.length == 0) {
			File fichero = new File("c:/Users/mañana.ORD30/git/repository/OstatuG5/ficherosReserva/reserva0001.txt");
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
					"c:/Users/mañana.ORD30/git/repository/OstatuG5/ficherosReserva/reserva" + numeroReserva + ".txt");
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
}
