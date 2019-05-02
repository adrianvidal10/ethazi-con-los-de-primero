package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Hotela;
import modelo.Konexioa;
import vista.DatuakErakutsi;

public class Kontsultak {
	private Konexioa conexion = new Konexioa();
	private ResultSet resultado;
	private String herria;
	private String izena;
	private int kodigoa, izarrak;
	private double prezioa;
	private ArrayList<Hotela> hotelZerrenda = new ArrayList<Hotela>();
	private ArrayList<String> ostMotaZerrenda = new ArrayList<String>();

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

	public ArrayList<String> selectOstatuMota() {

		// Bilaketa orriko comboboxa ostatu mota desberdinez beteko duen metodoa

		resultado = conexion.getQuery("SELECT DISTINCT OstMota FROM ostatua ORDER BY ASC");

		try {
			while (resultado.next()) {

				ostMotaZerrenda.add(resultado.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ostMotaZerrenda;

	}

}
