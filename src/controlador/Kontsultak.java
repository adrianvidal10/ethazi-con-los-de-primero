package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import modelo.Hotela;
import modelo.Konexioa;
import modelo.Ostatua;
import vista.DatuakErakutsi;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Bezeroa;

public class Kontsultak {

	//private Koordinatzailea micoordinador = new Koordinatzailea();
	private Konexioa conexion = new Konexioa();
	private ResultSet resultado;
	private String herria;
	private String izena;
	private String erabilKodigoa;
	private int kodigoa, izarrak;
	private double prezioa;
	private ArrayList<Hotela> hotelZerrenda = new ArrayList<Hotela>();
	private ArrayList<String> ostMotaZerrenda = new ArrayList<String>();
	
	
	private ArrayList<Bezeroa> bezeroaZerrenda = new ArrayList<Bezeroa>();

	Ostatua ostatua = new Ostatua();
	private ArrayList<Ostatua> zerrendaOstatua = new ArrayList<Ostatua>();
	//private ArrayList<String> ostMotaZerrenda = new ArrayList<String>();

	public void selectOstatuak(String herri, String ostMota) {
		String where = " WHERE ";
		String sHerria = " herria = '";
		String sKodOst = " AND ostMota = '";
		if (herri.equalsIgnoreCase("")==true) {
			sHerria = "";
		}else {
			sHerria += herri;
			sHerria += "'";
		}
		if (ostMota.equalsIgnoreCase("")==true) {
			sKodOst = "";
		}else {
			sKodOst += ostMota;
			sKodOst += "'";
		}
		if (ostMota.equalsIgnoreCase("")==true && sHerria.equalsIgnoreCase("")==true) {
			where = "";
		}
		resultado = conexion.getQuery("SELECT * FROM ostatua "+ where + sHerria + sKodOst);
		try {
			while (resultado.next()) {
				String izena = resultado.getString("izena");
				ostatua.setIzena(izena);
				String herria = resultado.getString("herria");
				ostatua.setHerria(herria);
				double tarifa = resultado.getDouble("tarifa");
				ostatua.setTarifa(tarifa);
				String gosaria = resultado.getString("gosaria");
				ostatua.setGosaria(gosaria);
				String ostatumota = resultado.getString("ostMota");
				ostatua.setOstMota(ostatumota);
				
				zerrendaOstatua.add(ostatua);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Ostatua> bidaliOstatua(String herri, String ostMota) {
		selectOstatuak(herri, ostMota);
		return this.zerrendaOstatua;
	}

	public boolean bezeroaDago(String nick, String pass) {
		boolean emaitza = false;
		String name = "";
		String passwd = "";
		try {
			resultado = conexion.getQuery("SELECT * FROM erabiltzaileak WHERE nick = '" + nick + "'");
			while (resultado.next()) {
				name = resultado.getString("nick");
				passwd = resultado.getString("pasahitza");
			}
		} catch (SQLException e) {
			System.out.println("Ez dago bezero hori!");
		}
		System.out.println(passwd);
		System.out.println(getMD5(pass));
		try {
			if (name.equalsIgnoreCase(nick) && passwd.equalsIgnoreCase(getMD5(pass))) {
				emaitza = true;
			}
		} catch (Exception e) {
			System.out.println("Ez dago bezero hori!");
		}

		return emaitza;
	}

	public boolean NANdago(String dni) {
		boolean emaitza = true;
		String NAN = "";
		try {
			resultado = conexion.getQuery("SELECT * FROM erabiltzaileak WHERE nan = '" + dni + "'");
			while (resultado.next()) {
				NAN = resultado.getString("nan");
			}
			if (NAN.equalsIgnoreCase(dni)) {
				emaitza = false;
			}
		} catch (SQLException e) {
			emaitza = true;
		}
		return emaitza;
	}

	public void insertBezero(Bezeroa beze) {
		boolean insert = NANdago(beze.getDni());
		try {
			if (insert = true) {
				conexion.setQuery("INSERT INTO erabiltzaileak "
						+ " (nan, izena, abizenaA, abizenaB, pasahitza, nick, promoKodigoa)" + " VALUES ('"
						+ beze.getDni() + "'," + "'" + beze.getIzena() + "','" + beze.getLehenAbizena() + "','"
						+ beze.getBigarrenAbizena() + "','" + getMD5(beze.getPasahitza()) + "', '" + beze.getNick()
						+ "','" + beze.getPromoa() + "')");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

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

	public boolean bilatuNick(String izena) {
		boolean emaitza = true;
		String datuak = "";
		try {
			resultado = conexion.getQuery("SELECT * FROM erabiltzaileak WHERE nick = '" + izena + "'");
			while (resultado.next()) {
				datuak = resultado.getString("nick");
			}
			if (datuak.equals(izena) == true) {
				emaitza = false;
			}

		} catch (SQLException e) {
			emaitza = true;
		}

		return emaitza;
	}

	public boolean bilatuPromoa(String promo) {
		boolean emaitza = true;
		String datua = "";
		try {
			resultado = conexion.getQuery("SELECT * FROM erabiltzaileak WHERE promoKodigoa = '" + promo + "'");
			while (resultado.next()) {
				datua = resultado.getString("promoKodigoa");
			}
			if (datua.equals(promo) == true) {
				emaitza = false;
			}

		} catch (SQLException e) {
			emaitza = true;
		}
		return emaitza;
	}

	public boolean dagoPromo(String promo) {
		boolean emaitza = false;
		String datua = "";
		try {
			resultado = conexion.getQuery("SELECT * FROM erabiltzaileak WHERE promoKodigoa = '" + promo + "'");
			while (resultado.next()) {
				datua = resultado.getString("promoKodigoa");
			}
			if (datua.equals(promo) == true) {
				emaitza = true;
			}

		} catch (SQLException e) {
			emaitza = false;
		}
		return emaitza;

	}

	public boolean oporraldiaDa(Date erreserba1, Date erreserba2, java.util.List<Date> listaEntreFechas) {

		boolean emaitza = false;
		// String data1, data2;
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		// SimpleDateFormat sdf = new SimpleDateFormat("E yyyy-MM-dd");

		// data1 = df.format(erreserba1);
		// data2 = df.format(erreserba2);

		Calendar c1 = Calendar.getInstance();
		c1.setTime(erreserba1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(erreserba2);

		// java.util.List<Date> listaEntreFechas =
		// Kontsultak.getErreserbarenDataGuztiak(c1.getTime(), c2.getTime());

		try {
			// jaiegun guztiak hartzen ditugu
			resultado = conexion.getQuery("SELECT * FROM jaiegunak");
			// banan banan konparatuko ditugu
			while (resultado.next()) {

				// erreserba daten harteko egunetan konprobatuko dugu ea
				// oporraldia den
				for (Date date : listaEntreFechas) {

					if (resultado.toString() == df.format(date)) {
						return true;
					}
				}
			}

		} catch (SQLException e) {
			emaitza = false;
		}
		return emaitza;

	}

	public boolean udaOporrakDira(Date erreserba1, Date erreserba2, java.util.List<Date> listaEntreFechas) {

		boolean emaitza = false;

		// String data1hilabetea, data2hilabetea;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		// data1hilabetea = df.format(erreserba1);
		// data2hilabetea = df.format(erreserba2);

		Calendar c1 = Calendar.getInstance();
		c1.setTime(erreserba1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(erreserba2);

		// java.util.List<Date> listaEntreFechas =
		// Kontsultak.getErreserbarenDataGuztiak(c1.getTime(), c2.getTime());

		for (Date date : listaEntreFechas) {

			// substring honek dataren stringetik hilabetea hartzen du eta
			// intera
			// bilakatzen du

			String hilea = date.toString().substring(4, 7);

			switch (hilea) {
			case "Jan":
				emaitza = false;
				break;
			case "Feb":
				emaitza = false;
				break;
			case "Mar":
				emaitza = false;
				break;
			case "Apr":
				emaitza = false;
				break;
			case "May":
				emaitza = false;
				break;
			case "Jun":
				emaitza = false;
				break;
			case "Oct":
				emaitza = false;
				break;
			case "Nov":
				emaitza = false;
				break;
			case "Dec":
				emaitza = false;
				break;
			case "Jul":
				emaitza = true;
				break;
			case "Aug":
				emaitza = true;
				break;
			case "Sep":
				emaitza = true;
				break;
			default:
				emaitza = false;
				break;
			}

		}

		return emaitza;

	}

	public static java.util.List<Date> getErreserbarenDataGuztiak(Date hasData, Date amaData) {

		// calendar bihurtuko ditugu datak haien harteko operazioak errezagoak
		// izan daitezen
		Calendar c1 = Calendar.getInstance();
		c1.setTime(hasData);
		System.out.println(c1.toString());
		Calendar c2 = Calendar.getInstance();
		c2.setTime(amaData);

		// datak gordeta egongo diren lista
		java.util.List<Date> listaFechas = new java.util.ArrayList<Date>();

		// bi daten artean ibiliko den buklea, pausu bakoitzean egun bat
		// gehituko zaio
		while (!c1.after(c2)) {
			listaFechas.add(c1.getTime());
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
		return listaFechas;
	}

	public void insertErreserba() {
		boolean insert = true;

		try {
			if (insert = true) {
				conexion.setQuery("INSERT INTO erreserbak "
						+ " (hasieraData, amaieraData, prezioa, tarifaMota, ostatuKod, errNick, gelaKant, oheLista)"
						+ " VALUES ('hasieradata'," + "amaieradata" + "'prezioa'" + "'tarifamota'"
						+ "'ostatuKod'" + "'errNick'" + "'gelaKant'");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	public String cogerPromocion(String erabilt){
		resultado = conexion.getQuery("SELECT * FROM erabiltzaileak WHERE nick = '" + erabilt + "'");
		try {
			while (resultado.next()) {
				
				
				erabilKodigoa = resultado.getString("promoKodigoa");
				
				String nick = resultado.getString("nick");

				String pasahitza = resultado.getString("pasahitza");
				
				String nan = resultado.getString("nan");
			
				String erabil = resultado.getString("izena");
				
				String LehenAbizena = resultado.getString("abizenaA");
				
				String BigarrenAbizena = resultado.getString("abizenaB");
				
				Bezeroa b = new Bezeroa(nan, erabil, LehenAbizena, BigarrenAbizena, pasahitza, nick);
				
				bezeroaZerrenda.add(b);
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return erabilKodigoa;
	}

}
