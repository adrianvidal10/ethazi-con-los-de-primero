package controlador;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Hotela;
import modelo.Konexioa;

public class Kontsultak {
	private Konexioa conexion = new Konexioa();
	private ResultSet resultado;
	private String herria;
	private String izena;
	private int kodigoa, izarrak;
	private double prezioa;
	private ArrayList<Hotela> hotelZerrenda = new ArrayList<Hotela>();

	public void selectHotelak(String herri) {
		String testua;

		resultado = conexion.getQuery("SELECT * FROM hotel WHERE herria = '" + herri + "'");
		try {
			while (resultado.next()) {
				Hotela h = new Hotela();
				kodigoa = resultado.getInt("kodigoa");
				h.setKodigoa(kodigoa);
				izena = resultado.getString("izena");
				h.setIzena(izena);
				herria = resultado.getString("herria");
				h.setHerria(herria);
				izarrak = resultado.getInt("izarrak");
				h.setIzarrak(izarrak);
				prezioa = resultado.getDouble("prezioa");
				h.setPrezioa(prezioa);
				hotelZerrenda.add(h);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Hotela> mandarhotel(String herri) {
		selectHotelak(herri);
		return this.hotelZerrenda;
	}

	public boolean bezeroaDago(String DNI, String pass) {
		boolean emaitza = false;
		String dni = "";
		String passwd = "";
		try {
			resultado = conexion
					.getQuery("SELECT * FROM bezeroa WHERE DNI = '" + DNI + "'");
			while (resultado.next()) {
				dni = resultado.getString("DNI");
				passwd = resultado.getString("pasahitza");
			}
		} catch (SQLException e) {
			System.out.println("Ez dago bezero hori!");
		}
		System.out.println(passwd);
		System.out.println(getMD5(pass));
		try {
			if (dni.equalsIgnoreCase(DNI) && passwd.equalsIgnoreCase(getMD5(pass))) {
				emaitza = true;
			}
		} catch (Exception e) {
			System.out.println("Ez dago bezero hori!");
		}

		return emaitza;
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

}
