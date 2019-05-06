package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CrearFicheroReserva {
	
	public static void sortuFitxeroa(JFileChooser fileChooser) throws IOException {
		String numeroReserva = "0001";
		File carpeta = new File(fileChooser.getSelectedFile(), "");
		String[] listado = carpeta.list();
		try {
			if (listado == null || listado.length == 0) {
				FileWriter fichero = new FileWriter(fileChooser.getSelectedFile()+ "\\" + "reserva0001.txt");
				rellenarFichero(numeroReserva, fichero, fileChooser);
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
						fileChooser.getSelectedFile() +"\\reserva" + numeroReserva + ".txt");
				rellenarFichero(numeroReserva, fichero, fileChooser);
				return;
			}
		}catch (Exception e) {
			String direc = carpeta.getAbsoluteFile().getParent();
			FileWriter fichero = new FileWriter(direc+ "\\" + "reserva0001.txt");
			int numAleatorio = (int)Math.floor(Math.random()*(1 -999)+999);
			numeroReserva = Integer.toString(numAleatorio);
			rellenarFichero(numeroReserva, fichero, fileChooser);
			JOptionPane.showMessageDialog(null, "Faktura " + fileChooser.getSelectedFile() + "-an sortu da."
					, "Mensaje Informativo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void rellenarFichero(String numeroReserva, FileWriter fichero, JFileChooser fileChooser) {
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(fileChooser.getSelectedFile() + "\\reserva" +numeroReserva + ".txt");
	            pw = new PrintWriter(fichero);

	           pw.print("----------"
	        		+ "    BIDAION     "
	           		+ "---------- \r\n"
	           		+ "Hotel:                             x \r\n"
	           		+ "N� habitaciones:                   x \r\n"
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
