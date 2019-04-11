package modelo;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class Konexioa {

	private String usuario = "root";
	private String pwd = "";
	private static String bd = "ostatu";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection konx = null;
	{

		try {
			Class.forName("com.mysql.jdbc.Connection");
			konx = (Connection) DriverManager.getConnection(url, usuario, pwd);
			if (konx != null) {
				// System.out.println("Ondo joan da konexioa, " + url + " . . . Konektatua");
			}
		} catch (SQLException | java.lang.ClassNotFoundException ex) {
			System.out.println(ex.getMessage());

		}

	}

	public ResultSet getQuery(String _query) {
		Statement state = null;
		ResultSet resultado = null;
		try {
			state = (Statement) konx.createStatement();
			resultado = state.executeQuery(_query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public void setQuery(String _query) {

		Statement state = null;

		try {
			state = (Statement) konx.createStatement();
			state.executeUpdate(_query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}