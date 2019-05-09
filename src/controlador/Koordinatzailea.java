package controlador;

//
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class Koordinatzailea {
	// Atributuak:
	private Kontsultak kon = new Kontsultak();
	private LoginPantaila PantailaLogin;
	private Ordainketa PantailaOrdainketa;
	private DatuakErakutsi PantailaDatuakErakutsi;
	private ErregistruPantaila PantailaErregistru;
	private ErreserbaEgin PantailaErreserbaEgin;
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
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
		PantailaDatuakErakutsi.setVisible(false);
		PantailaLogin.setVisible(false);
		PantailaErreserbaEgin.setVisible(false);
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
		PantailaErregistru.setVisible(false);
		PantailaDatuakErakutsi.setVisible(false);
		PantailaLogin.setVisible(false);
		PantailaDatuakErakutsi.setVisible(true);
		PantailaOrdainketa.dispose();
	}

	public void setDatuakErakutsi(ErreserbaEgin PantailaErreserbaEgin) {
		this.PantailaErreserbaEgin = PantailaErreserbaEgin;
	}
	
	/*
	 * Erregistru Pantaila.
	 */
	public void setPantailaErregistru(ErregistruPantaila Erregistru) {
		this.PantailaErregistru = Erregistru;
	}
	
	public void setPantailaErregistru(ErreserbaEgin PantailaErreserbaEgin) {
		this.PantailaErreserbaEgin = PantailaErreserbaEgin;
	}

	public ErregistruPantaila PantailaErregistru() {
		return PantailaErregistru;
	}

	public void mostrarPantailaErregistru() {
		PantailaLogin.setVisible(false);
		this.PantailaErregistru.setVisible(true);
	}

	public void mostrarErreserbaEgin() {
		PantailaLogin.setVisible(false);
		PantailaErregistru.setVisible(false);
		PantailaDatuakErakutsi.setVisible(false);
		PantailaErreserbaEgin.setVisible(true);
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
		return this.kon.mandarhotel(herria);

	}

	public boolean kontsultaBezeroa(String nick, String passwd) {
		return this.kon.bezeroaDago(nick, passwd);
	}

	public void balidatuInsert(String zenbakiak, String letra, String Izena, String Abizena, String BiAbizena,
			String passwd1, String passwd2, String nick) {

		Bezeroa beze = new Bezeroa();
		int kontagailua = 0;
		int kontagailua2 = 0;
		Boolean NAN;
		Boolean IZENA;
		Boolean ABIZENA;
		Boolean BiABIZENA;
		Boolean PASAHITZAK;
		Boolean Txertatu = false;
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
		BiAbizena = PantailaErregistru.balidatuAbizenaBi();
		BiABIZENA = balidatuAbizenaBi(Abizena);
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

		if (kon.bilatuNick(nick) == true) {
			if (NAN == true && IZENA == true && ABIZENA == true && PASAHITZAK == true) {
				Nan = zenbakiak + letra;
				beze.setDni(Nan);
				beze.setIzena(Izena);
				beze.setLehenAbizena(Abizena);
				beze.setBigarrenAbizena(BiAbizena);
				beze.setPasahitza(passwd1);
				beze.setNick(nick);
				beze.setPromoa(promoKodeaSortu());
				Txertatu = kon.NANdago(Nan);

				if (Txertatu == false) {
					PantailaErregistru.balidatuLogina("Bazaude datu basean");
				} else {
					kon.insertBezero(beze);
					PantailaErregistru.youshouldpass();

					System.out.println("Te estas registrando....");
				}

			}

		} else {
			JOptionPane.showMessageDialog(null, "'Erabiltzaile' hori dago, erabili beste bat.", "Mensaje Informativo",
					JOptionPane.INFORMATION_MESSAGE);
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
	 * Bigarren Abizena balidatzeko metodoa da.
	 * 
	 * @param Abizena
	 * @return
	 */
	public Boolean balidatuAbizenaBi(String Abizena) {
		Boolean erabakia = true;
		try {
			char lehena = Abizena.charAt(0);
			if (Abizena.length() < 100) {
				if (!Character.isUpperCase(lehena)) {
					PantailaErregistru.erakutsiErrorea6("Lehengo letra mayuscula ");
					erabakia = false;

				} else {
					PantailaErregistru.erakutsiErrorea6("ONDO");

				}

			} else {
				PantailaErregistru.erakutsiErrorea6("Letra gehiegi");
				erabakia = false;

			}

		} catch (Exception e) {
			erabakia = false;
			PantailaErregistru.erakutsiErrorea6("Eremu hutsa");

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


	public String promoKodeaSortu() {
		// promo kodea 6 karaktere
		String emaitza = "";
		String znb="";
		String[] gauzak = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		do {
			for (int i = 0; i < 6; i++) {
				int ramdom = (int) Math.round(Math.random() * 36);
				znb += gauzak[ramdom];
			}
		} while (kon.bilatuPromoa(emaitza) == true);

		emaitza=znb;
		return emaitza;
	}

	public boolean bilatuNick(String nick) {
		return kon.bilatuNick(nick);
	}
	
	
	//ERRESERBA EGIN BALIDAPENAK
	
	public int tarifaMotaBidali(Date erreserbaHasiera, Date erreserbaAmaiera) {
		int tarifa=0;
		java.util.List<Date> dataLista;
		boolean oporraldiaDa, udaOporrakDira;
		
		System.out.println(erreserbaHasiera);
		dataLista = Kontsultak.getErreserbarenDataGuztiak(erreserbaHasiera, erreserbaAmaiera);
		oporraldiaDa = kon.oporraldiaDa(erreserbaHasiera, erreserbaAmaiera, dataLista);
		udaOporrakDira = kon.udaOporrakDira(erreserbaHasiera, erreserbaAmaiera, dataLista);
		
		if (udaOporrakDira==true && oporraldiaDa==true){
			tarifa = 50;
		}
		else if (udaOporrakDira==true){
			tarifa = 50;
		}
		else if (oporraldiaDa==true){
			tarifa = 25;
		} else {
			tarifa = 0;
		}
			
		//metodo honek dataren arabera tarifa desberdin bat bidaltzen dizu
		
		//PantailaErreserba.
		
		return tarifa;
	}
	
	

}
