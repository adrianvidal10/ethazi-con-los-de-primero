package modelo;
//
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bezeroa {

	private String Dni;
	private String Izena;
	private String Abizena;
	private Date fecha;
	private String sexua;
	private String pasahitza;
	private String data;

	public Bezeroa(String dni, String izena, String abizena, Date fecha, String sexua, String pasahitza) {
		this.Dni = dni;
		this.Izena = izena;
		this.Abizena = abizena;
		this.fecha = fecha;
		this.sexua = sexua;
		this.pasahitza = pasahitza;
	}

	/*
	 * public static ArrayList<Bezeroa> ateraErabiltzaileak() {
	 * 
	 * Connection conexion = Konexioa.Konexioa(); ArrayList<Bezeroa> Arraybezero =
	 * new ArrayList<Bezeroa>(); String dni = ""; String izena = ""; String abizena
	 * = ""; Date jaiotze; String sexu; String pasahitza = ""; try { Statement s =
	 * conexion.createStatement();
	 * 
	 * // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
	 * String query = "select * from cliente";
	 * 
	 * ResultSet rs = s.executeQuery(query);
	 * 
	 * // Se recorre el ResultSet, mostrando por pantalla los resultados. while
	 * (rs.next()) { dni = rs.getString(1); izena = rs.getString(2); abizena =
	 * rs.getString(3); jaiotze = rs.getDate(4); sexu = rs.getString(5); pasahitza =
	 * rs.getString(6);
	 * 
	 * // fsdweduykuikdrgfswfgrejiregoiregoigjrje /* System.out.println(dni);
	 * System.out.println(izena); System.out.println(abizena);
	 * System.out.println(jaiotze); System.out.println(sexu);
	 * System.out.println(pasahitza);
	 */

	/*
	 * Bezeroa bezero = new Bezeroa(dni, izena, abizena, jaiotze, sexu, pasahitza);
	 * Arraybezero.add(bezero);
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return
	 * (Arraybezero); }
	 */

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getIzena() {
		return Izena;
	}

	public void setIzena(String izena) {
		Izena = izena;
	}

	public String getAbizena() {
		return Abizena;
	}

	public void setAbizena(String abizena) {
		Abizena = abizena;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSexua() {
		return sexua;
	}

	public void setSexua(String sexua) {
		this.sexua = sexua;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	
	  /*public static void txertatuBezeroa(Bezeroa bezeroa) { Connection conexion =
	  BD.getConexion(); try { // Statement s = conexion.createStatement();
	  PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
	  "INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellidos`, `Fecha_nac`, `Sexo`, `Contraseña`)"
	  + " VALUES(?, ?, ?, ?, ?, ?)"); s.setString(1, bezeroa.getDni());
	  s.setString(2, bezeroa.getIzena()); s.setString(3, bezeroa.getAbizena());
	  s.setString(4, bezeroa.getData()); s.setString(5, bezeroa.getSexua());
	  s.setString(6, bezeroa.getPasahitza());
	  
	 s.executeUpdate(); s.close();
	 
	 } catch (Exception e) { e.getMessage(); }
	 
	  }*/
	 

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	/*
	 * public static boolean konprobatuDatuBasea(String Nan) {
	 * 
	 * Connection conexion = BD.getConexion(); ArrayList<Bezeroa> Arraybezero = new
	 * ArrayList<Bezeroa>(); String dni =""; boolean erabakia = false;
	 * 
	 * try { Statement s = conexion.createStatement();
	 * 
	 * // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
	 * String query = "select * from cliente";
	 * 
	 * ResultSet rs = s.executeQuery(query);
	 * 
	 * // Se recorre el ResultSet, mostrando por pantalla los resultados. while
	 * (rs.next()) { dni=rs.getString(1); if (dni.equals(Nan)) { erabakia = true;
	 * break; }
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return
	 * erabakia; }
	 */

}
