package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Konexioa;
import vista.DatuakErakutsi;

public class Kontsultak {

	Konexioa conexion = new Konexioa();
	ResultSet resultado;
	String  titulua, herria;
	int kodigoa, izarrak;
	double prezioa;
	

	public void selectHotelak() {
		resultado = conexion.getQuery("SELECT * FROM hotel WHERE herria = "+ DatuakErakutsi.getherriaBilatu());

		try {
			while (resultado.next()) {

				kodigoa = resultado.getInt("kodigoa");
				titulua = resultado.getString("titulua");
				herria = resultado.getString("herria");
				izarrak = resultado.getInt("izarrak");
				prezioa = resultado.getDouble("prezioa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}


	public ResultSet getbidaliResultSet() {
		
		return resultado;
	}

}
