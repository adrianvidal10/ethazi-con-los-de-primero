package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Hotela;
import modelo.Konexioa;

public class Kontsultak {
	ArrayList<Hotela> hotelZerrenda = new ArrayList<Hotela>();
	Konexioa conexion = new Konexioa();
	ResultSet resultado;
	String herria;
	String izena;
	int kodigoa, izarrak;
	double prezioa;
	String testua;

	public void selectHotelak(String herria) {
		
		resultado = conexion.getQuery("SELECT * FROM hotel WHERE herria = '" + herria + "'");
		System.out.println(resultado);
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

				testua = " kodigoa: " + kodigoa + " izena: " + izena + " herria: " + herria + " izarrak: " + izarrak
						+ " prezioa: " + prezioa;
				System.out.println(testua);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  String mandarhotel(String herri) {
		String emaitza="";
		selectHotelak(herri);
		emaitza = this.testua;
		return emaitza;
	}
		
}
