package controlador;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import modelo.*;
import vista.*;

public class Koordinatzailea {
	// Atributuak:
	private LoginPantaila PantailaLogin;
	private Ordainketa PantailaOrdainketa;
	private DatuakErakutsi PantailaDatuakErakutsi;
	private ErregistruPantaila PantailaErregistru;

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
		PantailaErregistru.setVisible(false);
		PantailaOrdainketa.setVisible(false);
		PantailaDatuakErakutsi.setVisible(false);
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
		PantailaErregistru.setVisible(false);
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
		PantailaOrdainketa.dispose();
	}

	/*
	 * Erregistru Pantaila.
	 */
	public void setPantailaErregistru(ErregistruPantaila Erregistru) {
		this.PantailaErregistru = Erregistru;
	}

	public ErregistruPantaila PantailaErregistru() {
		return PantailaErregistru;
	}

	public void mostrarPantailaErregistru() {
		this.PantailaErregistru.setVisible(true);
	}

	public void logueatzekoBotoiak() {
		PantailaErregistru.setVisible(false);
		PantailaLogin.setVisible(true);
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

	public ArrayList<Hotela> bidaliSelectHotelak(String herria) {
		Kontsultak kon = new Kontsultak();
		return kon.mandarhotel(herria);

	}

	public void balidatuInsert(String zenbakiak, String letra, String Izena, String Abizena, String sexua,
			String passwd1, String passwd2) {

		int kontagailua = 0;
		int kontagailua2 = 0;
		Boolean NAN;
		Boolean IZENA;
		Boolean ABIZENA;
		Boolean PASAHITZAK;
		Boolean SEXUA;
		Boolean Txertatu;
		ArrayList<String> gordedatuak = new ArrayList();
		ArrayList<String> pasahitzak = new ArrayList();
		String Nan;
		String data;

		System.out.println(zenbakiak);
		System.out.println(letra);
		NAN = balidatuNan(zenbakiak, letra);
		System.out.println("Nan balidatzean " + NAN);
		Izena = PantailaErregistru.balidatuIzena();
		System.out.println(Izena);
		IZENA = balidatuIzena(Izena);
		Abizena = PantailaErregistru.balidatuAbizena();
		ABIZENA = balidatuAbizena(Abizena);
		System.out.println(ABIZENA);
		pasahitzak = PantailaErregistru.balidatuPasahitza();
		for (String p : pasahitzak) {
			if (kontagailua2 == 0) {
				passwd1 = p;
			}
			if (kontagailua2 == 1) {
				passwd2 = p;
			}
			kontagailua2++;
		}
		System.out.println(passwd1);
		System.out.println(passwd2);
		PASAHITZAK = balidatuPasahitzak(passwd1, passwd2);
		sexua = PantailaErregistru.erakutsiSexua();
		System.out.println(sexua);
		SEXUA = balidatuSexua(sexua);
		sexua = sexua.toUpperCase();
		data = PantailaErregistru.ateradata();
		System.out.println(data);

		if (NAN == true && IZENA == true && ABIZENA == true && PASAHITZAK == true && SEXUA == true
				&& data.length() != 0) {

			Nan = zenbakiak + letra;
			PantailaErregistru.balidatuLogina("Bazaude datu basean");
			PantailaErregistru.youshouldpass();

			/*
			 * Txertatu = Bezeroa.konprobatuDatuBasea(Nan); if (Txertatu == true) {
			 * PantailaErregistru.balidatuLogina("Bazaude datu basean"); }
			 * 
			 * else { PantailaErregistru.youshouldpass();
			 * 
			 * 
			 * // Bezeroa bezeroa = new Bezeroa(Nan,Izena,Abizena,data,sexua,passwd1);
			 * //Bezeroa.txertatuBezeroa( bezeroa);
			 * 
			 * System.out.println("Te estas registrando"); //}
			 */

		}

	}

	/**
	 * Desenkriptatzeko metodoa da, MD5-rekin.
	 * 
	 * @param input
	 * @return
	 */
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sexuaren eremua balidatzen du.
	 * 
	 * @param sexua
	 * @return
	 */
	public Boolean balidatuSexua(String sexua) {
		boolean erabakia = true;

		sexua = sexua.toUpperCase();
		String Gizona = "G";
		String Emakumea = "E";
		if (sexua.length() == 1 && sexua.equals(Gizona) || sexua.equals(Emakumea)) {
			PantailaErregistru.balidatuSexua("ONDO");

		} else {
			PantailaErregistru.balidatuSexua("Letra errorea");
			erabakia = false;

		}

		return erabakia;
	}

	/**
	 * Pasahitzaren eremua balidatzen du.
	 * 
	 * @param passwd
	 * @param passwd2
	 * @return
	 */
	public boolean balidatuPasahitzak(String passwd, String passwd2) {
		Boolean erabakia = false;
		if (!passwd.equals(passwd2)) {
			PantailaErregistru.erakutsiErrorea5("Pasahitzak ezberdinak");
			erabakia = false;
		}

		else {

			for (int i = 0; i < passwd.length(); i++) {
				if (Character.isUpperCase(passwd.charAt(i))) {
					erabakia = true;
				}

			}
			if (passwd.length() > 50) {
				erabakia = false;
			}
			if (erabakia == false) {
				PantailaErregistru.erakutsiErrorea5("Karaktere bat gutxienez larria eta n<50");
			}
			if (erabakia == true) {
				PantailaErregistru.erakutsiErrorea5("ONDO");
			}
		}

		return erabakia;
	}

	/**
	 * Abizena balidatzeko metodoa da.
	 * 
	 * @param Abizena
	 * @return
	 */
	public Boolean balidatuAbizena(String Abizena) {
		Boolean erabakia = true;
		try {
			char lehena = Abizena.charAt(0);
			if (Abizena.length() < 100) {
				if (!Character.isUpperCase(lehena)) {
					PantailaErregistru.erakutsiErrorea4("Lehengo letra mayuscula ");
					erabakia = false;

				} else {
					PantailaErregistru.erakutsiErrorea4("ONDO");

				}

			} else {
				PantailaErregistru.erakutsiErrorea4("Letra gehiegi");
				erabakia = false;

			}

		} catch (Exception e) {
			erabakia = false;
			PantailaErregistru.erakutsiErrorea4("Eremu hutsa");

		}
		return erabakia;

	}

	/**
	 * Izenaren eremua balidatzen du.
	 * 
	 * @param izena
	 * @return
	 */
	public Boolean balidatuIzena(String izena) {
		Boolean erabakia = true;
		try {
			char lehena = izena.charAt(0);
			if (izena.length() < 50) {
				if (!Character.isUpperCase(lehena)) {
					PantailaErregistru.erakutsiErrorea3("Lehengo letra mayuscula ");
					erabakia = false;

				} else {
					PantailaErregistru.erakutsiErrorea3("ONDO");

				}

			} else {
				PantailaErregistru.erakutsiErrorea3("Letra gehiegi");
				erabakia = false;

			}
		} catch (Exception e) {
			PantailaErregistru.erakutsiErrorea3("Eremu Hutsa");
			erabakia = false;

		}

		return erabakia;
	}

	/**
	 * NaN-a balidatzen du.
	 * 
	 * @param zenbakiak
	 * @param letra
	 * @return
	 */
	public Boolean balidatuNan(String zenbakiak, String letra) {
		Boolean erabakia = true;
		int nanzenbakiak = 0;
		char ateraletra;
		char caracter = ' ';
		boolean znbkia = false;
		String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo;
		boolean chr = false;
		if (zenbakiak.length() != 8 || letra.length() != 1) {
			erabakia = false;
			PantailaErregistru.erakutsiErrorea("Zenbaki edo letra gehiegi/gutxiegi sartu duzu");
		}
		if (zenbakiak.length() == 8 && letra.length() == 1) {
			try {
				nanzenbakiak = Integer.parseInt(zenbakiak);
				znbkia = true;

			} catch (Exception e) {
				erabakia = false;
				PantailaErregistru.erakutsiErrorea("Ez duzu zenbakiak jarri");
			}

			try {
				int numero = Integer.parseInt(letra);
				PantailaErregistru.erakutsiErrorea2("Letra errorea");

			} catch (Exception e) {
				chr = true;
				letra = letra.toUpperCase();
				caracter = letra.charAt(0);
			}
		}
		if (znbkia == true && chr == true) {
			modulo = nanzenbakiak % 23;
			ateraletra = juegoCaracteres.charAt(modulo);
			String comparador1 = Character.toString(caracter);
			String comparador2 = Character.toString(ateraletra);

			if (comparador1.equals(comparador2)) {
				erabakia = true;
				PantailaErregistru.erakutsiErrorea("ONDO");
			} else {
				PantailaErregistru.erakutsiErrorea("Txarto sartuta Nan,letra/zenbakia ");
			}
		}
		return erabakia;

	}

	public void erreserbarenPrezioa(String prezioa) {
		PantailaOrdainketa.setPrezioa(prezioa);
	}

}
