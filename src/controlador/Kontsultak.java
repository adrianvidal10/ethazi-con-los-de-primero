package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Konexioa;
import vista.DatuakErakutsi;

public class Kontsultak {

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

				kodigoa = resultado.getInt("kodigoa");
				izena = resultado.getString("izena");
				herria = resultado.getString("herria");
				izarrak = resultado.getInt("izarrak");
				prezioa = resultado.getDouble("prezioa");

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
