package controlador;

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
		Hotela h = new Hotela();
		resultado = conexion.getQuery("SELECT * FROM hotel WHERE herria = '" + herri + "'");
		try {
			while (resultado.next()) {

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
				// testua = "Izena: " + izena + " Herria: " + herria + " Izarrak: " + izarrak +
				// " Prezioa: " + prezioa + "€" + "\n";
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

}
