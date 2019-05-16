package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.Bezeroa;

public class CrearFicheroReserva {

	public void sortuFitxeroa(String ordainketa, double kenketa, Koordinatzailea micoordinador, JFileChooser fileChooser) throws IOException {
		String numeroReserva = "0001";
		File carpeta = new File(fileChooser.getSelectedFile(), "");
		String[] listado = carpeta.list();
		try {
			if (listado == null || listado.length == 0) {
				FileWriter fichero = new FileWriter(fileChooser.getSelectedFile() + "\\" + "reserva0001.txt");
				rellenarFichero(ordainketa, kenketa, micoordinador, numeroReserva, fichero, fileChooser);
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
						fileChooser.getSelectedFile() + "\\reserva" + numeroReserva + ".txt");
				rellenarFichero(ordainketa, kenketa, micoordinador, numeroReserva, fichero, fileChooser);
				return;
			}
		} catch (Exception e) {
			String direc = carpeta.getAbsoluteFile().getParent();
			FileWriter fichero = new FileWriter(direc + "\\" + "reserva0001.txt");
			int numAleatorio = (int) Math.floor(Math.random() * (1 - 999) + 999);
			numeroReserva = Integer.toString(numAleatorio);
			rellenarFichero(ordainketa, kenketa, micoordinador, numeroReserva, fichero, fileChooser);
			JOptionPane.showMessageDialog(null, "Faktura " + fileChooser.getSelectedFile() + "-an sortu da.",
					"Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void rellenarFichero(String ordainketa, double kenketa, Koordinatzailea micoordinador, String numeroReserva, FileWriter fichero, JFileChooser fileChooser) {
		PrintWriter pw = null;
		Reserva miReserva = micoordinador.getReserva();
		Bezeroa bezero = micoordinador.getBezero();
		String erreserbaAmaiera = new SimpleDateFormat("dd/MM/yyyy").format( miReserva.getAmaiData() );
		String erreserbaHasiera = new SimpleDateFormat("dd/MM/yyyy").format( miReserva.getHasiData() );
		String prezioa = Double.toString(miReserva.getPrezioa());
		String nick = miReserva.getNick();
		String OstaIzena = micoordinador.bidaliOstatuIzena();
		String izena = bezero.getIzena();
		String abizena = bezero.getLehenAbizena();
		String NAN = bezero.getDni();
		String ordainduta = ordainketa;
		double bueltak = kenketa;
		int spinnerBalorea = micoordinador.bidaliSpinnerBalorea();

		
		try {
			fichero = new FileWriter(fileChooser.getSelectedFile() + "\\reserva" + numeroReserva + ".txt");
			pw = new PrintWriter(fichero);

			pw.print("----------    BIDAION     ---------- \r\n"
					+ "Hotel:                             "+ OstaIzena +" \r\n"
					+ "Nº habitaciones:                   "+ spinnerBalorea +" \r\n"
					+ "Hasiera                            " + erreserbaHasiera + " \r\n"
					+ "Amaiera                            " + erreserbaAmaiera + " \r\n"
					+ "------------------------------------- \r\n"
					+ "Erabiltzaile                       " + nick +" \r\n" 
					+ "Izena                              " + izena + " \r\n" 
					+ "Abizena                            " + abizena + " \r\n"
					+ "NAN                                " + NAN + " \r\n"
					+ "------------------------------------- \r\n"
					+ "Bueltak                            " + Math.abs(bueltak) + " \r\n"
					+ "Prezioa                            " + prezioa + "€ \r\n"); 


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
