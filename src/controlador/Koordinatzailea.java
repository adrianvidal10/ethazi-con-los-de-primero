package controlador;

import modelo.*;
import vista.*;

public class Koordinatzailea {
	//Atributuak:
	private LoginPantaila PantailaLogin;
	private Ordainketa PantailaOrdainketa;
	
	
	//Bistaratzeko pantailak:
	//LOGIN:
	/**
	 * LOGIN Jframea esartzeko.
	 * 
	 * @return
	 */
	public LoginPantaila getMiVentanaRegistro() {
		return PantailaLogin;
	}
	/**
	 * LOGIN pantaila esartzen du.
	 * 
	 * @param miVentanaRegistro
	 */
	public void setMiVentanaRegistro(LoginPantaila miVentanaRegistro) {
		this.PantailaLogin = miVentanaRegistro;
	}

	// ******************
	/**
	 * Login pantaila aurkeztekoa dago.
	 */
	public void mostrarVentanaLogin() {
		//VENTANA PRINTZIPALA.setVisible(false);
		PantailaLogin.setVisible(true);
	}
	//ORDAINKETA:
	/**
	 * ORDAINKETA pantaila esartzen du.
	 * 
	 * @param nireordainketa
	 */
	public void setordainketa(Ordainketa nireordainketa) {
		this.PantailaOrdainketa = nireordainketa;
	}

	/**
	 * ORDAINKETA pantaila erakusteko.
	 */
	public void mostrarVentanaOrdainketa() {
		//VENTANA PRINTZIPALA.setVisible(false);
		PantailaLogin.setVisible(false);
		PantailaOrdainketa.setVisible(true);
	}
	
	public static double borobilduDirua(double zerga) {
		// Zenbakien lehengo 2 dezimaletara borobiltzen ditu
		int p_ente = (int) zerga;
		double zerga1;
		zerga1 = zerga - p_ente;
		// System.out.println(zerga);
		while (zerga1 < 100) {
			zerga1 = zerga1 * 10;
		}
		zerga1 = zerga1 / 10;
		// System.out.println(zerga);
		double zbkia1 = Math.round(zerga1);
		// System.out.println(zbkia1);
		int zbkia2 = (int) zbkia1;
		// System.out.println(zbkia2);
		String katea = String.valueOf(p_ente);
		String katea1 = String.valueOf(zbkia2);
		// String-a erabiltzen du lehenengo dezimala 0 behar izaterakoan
		if (zerga < 0.10) {
			katea = katea + "." + "0" + katea1 + "0";
		} else {
			katea = katea + "." + katea1;
		}

		double doble = Double.parseDouble(katea);
		return doble;
	}
	
	public void ordainketaPantaila() {
		//Aurreko pantailak false egin.
		String dirua;
		dirua = "50";
		Double zenbakia = Double.parseDouble(dirua);
		PantailaOrdainketa.bidalidirua(String.valueOf(zenbakia));
		//idatxiTxt();
	}


}

