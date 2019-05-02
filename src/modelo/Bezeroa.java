package modelo;

import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import controlador.Koordinatzailea;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bezeroa {
	private Koordinatzailea micoordinador;
	private String Dni;
	private String Izena;
	private String LehenAbizena;
	private String BigarrenAbizena;
	private String pasahitza;
	private String nick;
	private String promoa;

	public Bezeroa() {
		
	}
	
	public Bezeroa(String dni, String izena, String LehenAbizena, String BigarrenAbizena, String pasahitza, String nick) {
		this.Dni = dni;
		this.Izena = izena;
		this.LehenAbizena = LehenAbizena;
		this.BigarrenAbizena = BigarrenAbizena;
		this.pasahitza = pasahitza;
		this.nick = nick;
	}

	public String getDni() {
		return Dni;
	}

	public String getIzena() {
		return Izena;
	}

	public String getLehenAbizena() {
		return LehenAbizena;
	}

	public String getBigarrenAbizena() {
		return BigarrenAbizena;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public void setIzena(String izena) {
		Izena = izena;
	}

	public void setLehenAbizena(String lehenAbizena) {
		LehenAbizena = lehenAbizena;
	}

	public void setBigarrenAbizena(String bigarrenAbizena) {
		BigarrenAbizena = bigarrenAbizena;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPromoa() {
		return promoa;
	}

	public void setPromoa(String promoa) {
		this.promoa = promoa;
	}
	
	/*
	 * public static ArrayList<Bezeroa> ateraErabiltzaileak() {
	 * 
	 * Connection conexion = Konexioa.Konexioa(); ArrayList<Bezeroa> Arraybezero =
	 * new ArrayList<Bezeroa>(); String dni = ""; String izena = ""; String LehenAbizena
	 * = ""; Date jaiotze; String sexu; String pasahitza = ""; try { Statement s =
	 * conexion.createStatement();
	 * 
	 * // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
	 * String query = "select * from cliente";
	 * 
	 * ResultSet rs = s.executeQuery(query);
	 * 
	 * // Se recorre el ResultSet, mostrando por pantalla los resultados. while
	 * (rs.next()) { dni = rs.getString(1); izena = rs.getString(2); LehenAbizena =
	 * rs.getString(3); jaiotze = rs.getDate(4); sexu = rs.getString(5); pasahitza =
	 * rs.getString(6);
	 * 
	 * // fsdweduykuikdrgfswfgrejiregoiregoigjrje /* System.out.println(dni);
	 * System.out.println(izena); System.out.println(LehenAbizena);
	 * System.out.println(jaiotze); System.out.println(sexu);
	 * System.out.println(pasahitza);
	 */

	/*
	 * Bezeroa bezero = new Bezeroa(dni, izena, LehenAbizena, jaiotze, sexu, pasahitza);
	 * Arraybezero.add(bezero);
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } return
	 * (Arraybezero); }
	 */
	
	  /*public static void txertatuBezeroa(Bezeroa bezeroa) { Connection conexion =
	  BD.getConexion(); try { // Statement s = conexion.createStatement();
	  PreparedStatement s = (PreparedStatement) conexion.prepareStatement(
	  "INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellidos`, `Fecha_nac`, `Sexo`, `Contraseña`)"
	  + " VALUES(?, ?, ?, ?, ?, ?)"); s.setString(1, bezeroa.getDni());
	  s.setString(2, bezeroa.getIzena()); s.setString(3, bezeroa.getLehenAbizena());
	  s.setString(4, bezeroa.getData()); s.setString(5, bezeroa.getSexua());
	  s.setString(6, bezeroa.getPasahitza());
	  
	 s.executeUpdate(); s.close();
	 
	 } catch (Exception e) { e.getMessage(); }
	 
	  }*/
	 

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
