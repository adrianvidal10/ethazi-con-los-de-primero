package controlador;

import modelo.*;
import vista.*;

public class Koordinatzailea {
	// Atributuak:
	private LoginPantaila PantailaLogin;
	private Ordainketa PantailaOrdainketa;
	private DatuakErakutsi PantailaDatuakErakutsi;
	// Bistaratzeko pantailak:
	// LOGIN:
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
		// VENTANA PRINTZIPALA.setVisible(false);
		PantailaLogin.setVisible(true);
	}

	// ORDAINKETA:
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
		// VENTANA PRINTZIPALA.setVisible(false);
		PantailaLogin.setVisible(false);
		PantailaOrdainketa.setVisible(true);
	}
	
	public DatuakErakutsi getDatuakErakutsi() {
		return PantailaDatuakErakutsi;
	}

	/**
	 * DatuakErakutsi pantaila esartzen du.
	 * 
	 * @param miVentanaRegistro
	 */
	public void setDatuakErakutsi(DatuakErakutsi PantailaDatuakErakutsi) {
		this.PantailaDatuakErakutsi = PantailaDatuakErakutsi;
	}

	// ******************
	/**
	 * Login pantaila aurkeztekoa dago.
	 */
	public void mostrarPantailaDatuakErakutsi() {
		// VENTANA PRINTZIPALA.setVisible(false);
		PantailaDatuakErakutsi.setVisible(true);
	}
	
	public double borobilduDirua(double dirua) {
		double emaitza = Math.round(dirua * 100.0) / 100.0;
		return emaitza;
	}

	public void ordainketaPantaila() {
		// Aurreko pantailak false egin.
		String dirua;
		dirua = "50";
		Double zenbakia = Double.parseDouble(dirua);
		PantailaOrdainketa.bidalidirua(String.valueOf(zenbakia));
		// idatxiTxt();
	}

}
