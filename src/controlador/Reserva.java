package controlador;

import java.util.*;

public class Reserva {
	private double prezioa = 0;
	private Date hasiData;
	private Date amaiData;
	private String nick;
	private String erreserbaHasiera = "";
	private String erreserbaAmaiera = "";
	private int gelaKant;
	
	public Reserva() {
	}

	public Reserva(double prezioa, Date hasiData, Date amaiData, String nick) {
		this.prezioa = prezioa;
		this.hasiData = hasiData;
		this.amaiData = amaiData;
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public double getPrezioa() {
		
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public Date getHasiData() {
		return hasiData;
	}


	public Date getAmaiData() {
		return amaiData;
	}


	public void setHasiData(Date hasiData) {
		this.hasiData = hasiData;
	}


	public void setAmaiData(Date amaiData) {
		this.amaiData = amaiData;
	}

	public String getErreserbaHasiera() {
		return erreserbaHasiera;
	}

	public String getErreserbaAmaiera() {
		return erreserbaAmaiera;
	}

	public void setErreserbaHasiera(String erreserbaHasiera) {
		this.erreserbaHasiera = erreserbaHasiera;
	}

	public void setErreserbaAmaiera(String erreserbaAmaiera) {
		this.erreserbaAmaiera = erreserbaAmaiera;
	}

	@Override
	public String toString() {
		return "Reserva [prezioa=" + prezioa + ", hasiData=" + hasiData + ", amaiData=" + amaiData + ", nick=" + nick
				+ ", erreserbaHasiera=" + erreserbaHasiera + ", erreserbaAmaiera=" + erreserbaAmaiera + "]";
	}

	public int getGelaKant() {
		return gelaKant;
	}

	public void setGelaKant(int gelaKant) {
		this.gelaKant = gelaKant;
	}

}
