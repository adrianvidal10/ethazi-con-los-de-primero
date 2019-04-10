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
	private ArrayList<String> emaitzak = new ArrayList<String>();

	public void selectHotelak(String herri) {
		String testua;
		resultado = conexion.getQuery("SELECT * FROM hotel WHERE herria = '" + herri + "'");
		try {
			while (resultado.next()) {
				kodigoa = resultado.getInt("kodigoa");
				izena = resultado.getString("izena");
				herria = resultado.getString("herria");
				izarrak = resultado.getInt("izarrak");
				prezioa = resultado.getDouble("prezioa");
				testua = "Izena: " + izena + " Herria: " + herria + " Izarrak: " + izarrak + " Prezioa: " + prezioa + "€" + "\n";
				emaitzak.add(testua);
				}
			
		}catch(SQLException e){
			e.printStackTrace();
			}
		}

	public ArrayList<String> mandarhotel(String herri) {
		selectHotelak(herri);
		return this.emaitzak;
	}

}
