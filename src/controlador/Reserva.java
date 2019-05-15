package controlador;

import java.util.*;

public class Reserva {
	private double prezioa = 0;
	private Date hasiData;
	private Date amaiData;
	private String erreserbaHasiera = "";
	private String erreserbaAmaiera = "";
	
	public Reserva() {
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

}
